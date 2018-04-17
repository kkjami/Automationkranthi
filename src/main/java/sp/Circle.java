package sp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

import javax.annotation.Resource;

public class Circle implements Shape {

    private Point center;

    public Point getCenter() {
        return center;
    }

//    @Autowired
//    @Required
//    @Resource(name="Point2")
    public void setCenter(Point center) {
        this.center = center;
    }

    @Override
    public void draw() {
        System.out.println("Circle{" +
                "center=" + center +
                '}');
    }

    @Override
    public String toString() {
        return "Circle{" +
                "center=" + center +
                '}';
    }
}
