/**
 * From the constructor-injection branch of spring-xml-demo repo create a
 * autowire-xml branch.
 * For the Movie bean, delete the constructor based object injection in the bean definition file
 * (beans.xml) that injects an Actor bean.
 * Use autowire byName in the Movie bean to inject an Actor bean.
 * Run the application.
 * Create another Movie bean and try autowire byType.
 * Run the application and note the exception thrown.
 * Fix the Movie bean by removing autowire byType and using constructor injection instead.
 * Push the code to autowire-xml branch.
 */
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

        //Used ApplicationContext for movieB
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Movie movie3 = (Movie)context.getBean("movieB");
        Actor actor3 = movie3.getActor();
        System.out.println(actor3.getName() + " " + actor3.getGender()+ " " + actor3.getAge());

        //Used movieD
        Movie movie4 = (Movie)context.getBean("movieD");
        Actor actor4 = movie4.getActor();
        System.out.println(actor4.getName() + " " + actor4.getGender()+ " " + actor4.getAge());

    }
}
