package com.creatureox.redisson.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ReflectionUtils;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author CreatureOX
 * date: 2020/6/21
 * description:
 */
@Configuration
@ConditionalOnClass({Redisson.class})
@EnableConfigurationProperties({RedisProperties.class})
public class RedissonConfig {

    @Resource
    private RedisProperties redisProperties;

    @Bean(destroyMethod = "shutdown")
    @ConditionalOnMissingBean(RedissonClient.class)
    @SuppressWarnings({"unchecked", "rawtypes"})
    public RedissonClient redissonClient() {
        Config config;
        Method clusterMethod = ReflectionUtils.findMethod(RedisProperties.class, "getCluster");
        Method timeoutMethod = ReflectionUtils.findMethod(RedisProperties.class, "getTimeout");
        Object timeoutValue = ReflectionUtils.invokeMethod(timeoutMethod, redisProperties);
        int timeout;
        if (null == timeoutValue){
            timeout = 0;
        }else if (!(timeoutValue instanceof Integer)){
            Method millisMethod = ReflectionUtils.findMethod(timeoutValue.getClass(), "toMillis");
            timeout = ((Long) ReflectionUtils.invokeMethod(millisMethod, timeoutValue)).intValue();
        }else {
            timeout = (Integer) timeoutValue;
        }

        if (redisProperties.getSentinel() != null){
            Method nodesMethod = ReflectionUtils.findMethod(RedisProperties.Sentinel.class, "getNodes");
            Object nodesValue = ReflectionUtils.invokeMethod(nodesMethod, redisProperties.getSentinel());

            String[] nodes;
            if (nodesValue instanceof String){
                nodes = convert(Arrays.asList(((String)nodesValue).split(",")));
            }else {
                nodes = convert((List<String>) nodesValue);
            }

            config = new Config();
            config.useSentinelServers()
                    .setMasterName(redisProperties.getSentinel().getMaster())
                    .addSentinelAddress(nodes)
                    .setDatabase(redisProperties.getDatabase())
                    .setConnectTimeout(timeout)
                    .setPassword(redisProperties.getPassword());
        }else if (clusterMethod != null && ReflectionUtils.invokeMethod(clusterMethod, redisProperties) != null){
            Object clusterObject = ReflectionUtils.invokeMethod(clusterMethod, redisProperties);
            Method nodesMethod = ReflectionUtils.findMethod(clusterObject.getClass(), "getNodes");
            List<String> nodesObject = (List) ReflectionUtils.invokeMethod(nodesMethod, clusterObject);

            String[] nodes = convert(nodesObject);

            config = new Config();
            config.useClusterServers()
                    .addNodeAddress(nodes)
                    .setConnectTimeout(timeout)
                    .setPassword(redisProperties.getPassword());
        }else {
            String prefix = "redis://";
            Method method = ReflectionUtils.findMethod(RedisProperties.class, "isSsl");
            if (method != null && (Boolean)ReflectionUtils.invokeMethod(method, redisProperties)) {
                prefix = "rediss://";
            }

            config = new Config();
            config.useSingleServer()
                    .setAddress(prefix + redisProperties.getHost() + ":" + redisProperties.getPort())
                    .setConnectTimeout(timeout)
                    .setDatabase(redisProperties.getDatabase())
                    .setPassword(redisProperties.getPassword());
        }
        return Redisson.create(config);
    }

    private String[] convert(List<String> nodesObject){
        List<String> nodes = new ArrayList<>(nodesObject.size());
        for (String node: nodesObject){
            if (!node.startsWith("redis://") && !node.startsWith("rediss://")){
                nodes.add("redis://" + node);
            }else {
                nodes.add(node);
            }
        }
        return nodes.toArray(new String[nodes.size()]);
    }
}
