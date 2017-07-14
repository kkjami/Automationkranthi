package jetty;

import org.testng.annotations.Test;
import org.testng.internal.ClassHelper;
import org.testng.internal.PackageUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by kranthikumar on 12/07/17.
 */
public class ListTestsClasses extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("<form type=get action=testng>");
        response.getWriter().println("Test name<input type=text name=testname>");
        response.getWriter().println("<table>");
        response.getWriter().println("<tr><th>Select</th><th>Method</th></tr>");
        String[] testClasses = PackageUtils.findClassesInPackage("appium", new ArrayList<String>(), new ArrayList<String>());
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        for (String eachClass : testClasses) {
            Class currentClass = null;
            try {
                currentClass = cl.loadClass(eachClass);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            Set<Method> allMethods = ClassHelper.getAvailableMethods(currentClass);
            Iterator<Method> iMethods = allMethods.iterator();
            while (iMethods.hasNext()) {
                Method eachMethod = iMethods.next();
                Test test = eachMethod.getAnnotation(Test.class);
                if (test != null) {
//                    System.out.println("Method Name = " + eachMethod.getName());
//                    System.out.println("Its class = " + eachMethod.getDeclaringClass().getName());
                    response.getWriter().println("<tr><td><input type=checkbox name=testclass value="+eachMethod.getDeclaringClass().getName()+"."+eachMethod.getName()+"></td><td>"+eachMethod.getName()+"</td></tr>");
                }
            }
        }
        response.getWriter().println("</table>");
        response.getWriter().println("<input type=submit value=\"start test\" >");
        response.getWriter().println("</form>");

    }
}
