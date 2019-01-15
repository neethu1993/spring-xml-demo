package com.stackroute.domain;

public class Movie {
    private Actor actor;

    public Movie(){

    }

    public Movie(Actor actor) {
        this.actor = actor;
    }

    public Actor getActor() {
        //System.out.println("Inside Movie getActor");
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }
}
