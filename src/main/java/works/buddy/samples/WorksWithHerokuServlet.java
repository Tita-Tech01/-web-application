package works.buddy.samples;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class WorksWithHerokuServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        response.setStatus(404);
        PrintWriter writer = response.getWriter();
        writer.print("If you are able to see this message, it means i succeded in deploying a web application to tomcat via jenkins. It wasn't an easy task to come up with a script, so i added to an already created script");
        writer.close();
    }
}
