package com.creatureox.squirrel.statemachine.context;

/**
 * @author CreatureOX
 * version: 1.0
 * date: 2020/7/8
 * description:
 */
public interface FireContext {

    /**
     * context in
     *
     * @return context in
     */
    FireContextIn getIn();

    /**
     * context out
     *
     * @return context out
     */
    FireContextOut getOut();

}
