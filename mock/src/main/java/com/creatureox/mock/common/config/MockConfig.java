package com.creatureox.mock.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author CreatureOX
 * date: 2021/11/24
 * description:
 */
@Data
@ConfigurationProperties(prefix = "mock")
@Component
public class MockConfig {

    private Map<String, Object> response;

}
