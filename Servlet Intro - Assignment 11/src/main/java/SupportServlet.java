import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SupportServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>cstech support form</title></head><body>");
        out.println("<form method= 'post'>");
        out.println("Name") ;
        out.println("<input type = 'text' name='name'> <br /> <br />");
        out.println("Email Address");
        out.println("<input type = 'text' name='email'> <br /> <br />");
        out.println("Problem");
        out.println("<input type ='text' name='problem'> <br /> <br />");
        out.println("Problem Description");
        out.println("<textarea name='problemdescription' rows='10' cols='30'> </textarea> <br /> <br />");

        out.println("<input type= 'submit' value = 'help'>");
        out.print("</form>");
        out.print("</body></html>");

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          PrintWriter out = response.getWriter();
          String name  = request.getParameter("name");
          String emailAddress = request.getParameter("email");

        ServletContext sc = this.getServletContext();

          out.println("Thank you ! "+ name + "for contacting us." +
                  " We should receive reply from us with in 24 hrs in your Email Address " + emailAddress +
                   ". Let us know in our support email " + sc.getInitParameter("support-email") + " If you don’t receive reply within 24 hrs. " +
                          "Please be sure to attach your reference " + (int)(Math.random()*1000 ) + " in your email."
                  );
    }

}
