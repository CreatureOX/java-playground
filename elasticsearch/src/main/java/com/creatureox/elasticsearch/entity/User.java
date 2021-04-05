package com.creatureox.elasticsearch.entity;

import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author CreatureOX
 * date: 2021/4/5
 * description:
 */
@Document(indexName = "userindex", type = "user")
public class User {

    private Long id;

    private String name;

    private Integer age;

}
