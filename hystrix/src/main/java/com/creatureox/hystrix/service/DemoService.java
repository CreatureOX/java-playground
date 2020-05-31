package com.creatureox.hystrix.service;

/**
 * @author CreatureOX
 * date: 2020/5/30
 * description:
 */
public interface DemoService {

    /**
     * echo
     *
     * @param word word
     * @return response
     */
    String echo(String word);

    /**
     * echo
     *
     * @param word word
     * @return response
     */
    String echoWithFallback(String word);

}
