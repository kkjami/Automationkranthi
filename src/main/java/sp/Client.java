package sp;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Client {
    public static void main(String[] args) {
//        Employee emp=new Employee();
//        emp.setEid(101);
//        emp.setName("jk");
//        emp.setAddr("dabba");
//
//        System.out.println("Emloyee details " +emp);


//        Resource res=new ClassPathResource("employeebean.xml");
//        BeanFactory factory=new XmlBeanFactory(res);

        ApplicationContext context=new ClassPathXmlApplicationContext("employeebean.xml");



        Employee e1= (Employee) context.getBean("emp");
Employee e2= (Employee) context.getBean("emp2");
Employee e4= (Employee) context.getBean("employee");
        System.out.println("Emloyee1 details " +e1);
        System.out.println("Emloyee2 details " +e2);
        System.out.println("Emloyee4 details " +e4);
        ClassPathXmlApplicationContext cxt =(ClassPathXmlApplicationContext)context;
        cxt.close();
    }
}
