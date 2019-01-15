package com.stackroute.domain;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Movie implements ApplicationContextAware, BeanFactoryAware , BeanNameAware {
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

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Actor actor= (Actor)applicationContext.getBean("actorB");
        System.out.println("from application context aware "+actor.getName());

    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        Actor actor1= (Actor) beanFactory.getBean("actorB");
        System.out.println("FRom Bean FActory"+actor1.getName());
    }

    public void setBeanName(String s) {
        System.out.println("Bean name is "+s);
    }
}
