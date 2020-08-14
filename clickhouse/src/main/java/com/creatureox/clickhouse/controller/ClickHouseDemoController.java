package com.creatureox.clickhouse.controller;

import com.creatureox.clickhouse.config.ClickHouseConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author CreatureOX
 * date: 2020/8/14
 * description:
 */
@Slf4j
@RequestMapping("/clickhouse")
@RestController
public class ClickHouseDemoController {

    @PostMapping("/exec")
    public String exec(String sql){
        List<Map> result = ClickHouseConfig.execSql(sql);
        StringBuilder stringBuilder = new StringBuilder(sql).append("=");
        if (!CollectionUtils.isEmpty(result)){
            for (Map map: result){
                stringBuilder.append(map);
            }
        }
        return stringBuilder.toString();
    }

}
