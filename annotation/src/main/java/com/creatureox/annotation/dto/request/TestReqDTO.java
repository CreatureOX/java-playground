package com.creatureox.annotation.dto.request;

import com.creatureox.annotation.aop.annotation.ByteLength;
import lombok.Data;

/**
 * @author CreatureOX
 * date: 2020/7/26
 * description:
 */
@Data
public class TestReqDTO {

    @ByteLength(max = 5)
    private String test;

}
