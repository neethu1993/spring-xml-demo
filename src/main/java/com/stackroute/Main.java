/**
 * Create a Maven project and add required dependency of spring-context 5.1.4.RELEASE
 * Create a Main class in package com.stackroute and two Spring Beans – Movie, and Actor in
 * package com.stackroute.domain.
 * Actor has two String properties, name and gender, and an age property of type int.
 * An Actor can be initialized with the three properties via the corresponding setter methods. Use
 * property based injection in the bean definition file (beans.xml)
 * Movie “has a” Actor that can be initialized via the corresponding setter method. Use property
 * based object injection in the bean definition file (beans.xml)
 * The Main class looks up Movie bean via three ways to print out actor information:
 * 1. Using XmlBeanFactory
 * 2. Using Spring 3.2 BeanDefinitionRegistry and BeanDefinitionReader
 * 3. Using ApplicationContext
 * Create a spring-xml-demo repo and push the code to master branch.
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

        //Using XmlBeanFactory
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beans.xml"));
        Movie movie1 = (Movie)beanFactory.getBean("movieA");
        Actor actor1 = movie1.getActor();
        System.out.println(actor1.getName() + " " + actor1.getGender()+ " " + actor1.getAge());

        //Using BeanDefinitionRegistry
        BeanDefinitionRegistry beanDefinitionRegistry=new DefaultListableBeanFactory();
        BeanDefinitionReader beanDefinitionReader=new XmlBeanDefinitionReader(beanDefinitionRegistry);
        beanDefinitionReader.loadBeanDefinitions(new ClassPathResource("beans.xml"));
        Movie movie2 = ((DefaultListableBeanFactory) beanDefinitionRegistry).getBean(Movie.class);
        Actor actor2 = movie2.getActor();
        System.out.println(actor2.getName() + " " + actor2.getGender()+ " " + actor2.getAge());

        //Using ApplicationContext
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Movie movie3 = context.getBean(Movie.class);
        Actor actor3 = movie3.getActor();
        System.out.println(actor3.getName() + " " + actor3.getGender()+ " " + actor3.getAge());


    }
}
