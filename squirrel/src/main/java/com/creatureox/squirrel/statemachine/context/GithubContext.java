package com.creatureox.squirrel.statemachine.context;

import lombok.Setter;

/**
 * @author CreatureOX
 * version: 1.0
 * date: 2020/7/8
 * description:
 */
public class GithubContext implements FireContext {

    private static class GithubIn implements FireContextIn {

    }

    private static class GithubOut implements FireContextOut {

    }

    @Setter
    private GithubIn in;

    @Setter
    private GithubOut out;

    public static GithubContext newInstance(){
        GithubContext githubContext = new GithubContext();
        githubContext.setIn(new GithubIn());
        githubContext.setOut(new GithubOut());
        return githubContext;
    }

    @Override
    public FireContextIn getIn() {
        return in;
    }

    @Override
    public FireContextOut getOut() {
        return out;
    }

}
