package sp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

public class Triangle implements Shape,ApplicationContextAware,BeanNameAware,InitializingBean,DisposableBean{

    private List<Point> points;
    private ApplicationContext applicationContext=null;

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public void draw() {
        System.out.println("Triangle{" +
                "points=" + points +
                '}');
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "points=" + points +
                '}';
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }

    @Override
    public void setBeanName(String beanName) {
        System.out.println("bean name: "+beanName);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("bean initialization completed. ");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("bean Destroy completed.");
    }
//@PostConstruct
    public void myInit() {
        System.out.println("in my init");
    }
//@PreDestroy
    public void myDestroy() {
        System.out.println("in my destroy");
    }
}
