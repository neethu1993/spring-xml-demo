package com.stackroute;

import com.stackroute.domain.Actor;
import com.stackroute.domain.Movie;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Main {
    public static void main(String[] args) {

        //Used Application context with name having two values
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Movie movie3 = (Movie)context.getBean("movieA");
        Actor actor3 = movie3.getActor();
        System.out.println(actor3.getName() + " " + actor3.getGender()+ " " + actor3.getAge());

        //Using same context to get beans of other name
        Movie movie4 = (Movie)context.getBean("movieC");
        Actor actor4 = movie4.getActor();
        System.out.println(actor4.getName() + " " + actor4.getGender()+ " " + actor4.getAge());

        //Comparing the objects
        System.out.println(movie3==movie4);

    }
}
