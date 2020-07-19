package com.creatureox.prometheus.controller;

import com.creatureox.prometheus.monitor.PrometheusCustomMonitor;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author CreatureOX
 * date: 2020/7/19
 * description:
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @Resource
    private PrometheusCustomMonitor monitor;

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public String handle(Exception e){
        monitor.getRequestErrorCount().increment();
        return "error, message: " + e.getMessage();
    }

}
