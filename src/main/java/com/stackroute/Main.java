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

        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beans.xml"));
        Movie movie1 = (Movie)beanFactory.getBean("movieA");
        Actor actor1 = movie1.getActor();
        System.out.println(actor1.getName() + " " + actor1.getGender()+ " " + actor1.getAge());

        System.out.println();
        BeanDefinitionRegistry beanDefinitionRegistry=new DefaultListableBeanFactory();
        BeanDefinitionReader beanDefinitionReader=new XmlBeanDefinitionReader(beanDefinitionRegistry);
        beanDefinitionReader.loadBeanDefinitions(new ClassPathResource("beans.xml"));
        Movie movie2 = ((DefaultListableBeanFactory) beanDefinitionRegistry).getBean(Movie.class);
        Actor actor2 = movie2.getActor();
        System.out.println(actor2.getName() + " " + actor2.getGender()+ " " + actor2.getAge());

        System.out.println();
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Movie movie3 = context.getBean(Movie.class);
        Actor actor3 = movie3.getActor();
        System.out.println(actor3.getName() + " " + actor3.getGender()+ " " + actor3.getAge());


    }
}
