package jetty;

import appium.ListenerImpl;
import org.testng.TestNG;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kranthi on 03-07-2017.
 */
public class InitialiseTestNG extends HttpServlet {
    String reportid;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        reportid = "hai";
        String[] checkedIds = request.getParameterValues("testclass");
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
//        for (String cla : checkedIds)
    //        response.getWriter().println(cla);

        response.getWriter().println("session=" + request.getSession(true).getId());
        response.getWriter().println("<h1>starting testNG</h1>");
        TestNG testng = new TestNG();
        List<String> tests = new ArrayList<>();
        tests.add("src/main/resources/testsuitsample.xml");
        testng.setTestSuites(tests);
        testng.setUseDefaultListeners(false);
        testng.addListener(new ListenerImpl());
        testng.run();
        //TODO response.redirect test background  html report.
        //response.sendRedirect("/getreport?reportid=" + reportid);
    }

    public void createReport() {
        new File("/hai/" + reportid).mkdirs();
    }
}
