package sp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {

//        AbstractApplicationContext context=new ClassPathXmlApplicationContext("drawingapp.xml");
        AbstractApplicationContext context=new ClassPathXmlApplicationContext("drawingapp.xml");
        context.registerShutdownHook();
        Shape shape= context.getBean("circle1",Shape.class);
        shape.draw();
    }
}