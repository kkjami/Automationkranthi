package jetty;

import org.testng.TestNG;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kranthi on 03-07-2017.
 */
public class InitiliseTestNG extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("<h1>Hello Servlet</h1>");
        response.getWriter().println("session=" + request.getSession(true).getId());
        response.getWriter().println("<h1>starting testNG</h1>");
        TestNG testng=new TestNG();
        List tests=new ArrayList();
        tests.add("src\\main\\resources\\testsuitsample.xml");
        testng.setTestSuites(tests);
        testng.run();

    }

}
