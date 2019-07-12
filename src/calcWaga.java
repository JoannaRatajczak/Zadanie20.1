import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calcWaga")
public class calcWaga extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String miligramy = request.getParameter("miligramy");
        String gramy = request.getParameter("gramy");
        String kilogramy = request.getParameter("kilogramy");

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();


        if (!("".equals(miligramy)) && "".equals(gramy) && "".equals(kilogramy)) {
            double mg = Double.valueOf(miligramy);
            writer.println("Podana wartość w przeliczeniu na:\n\n");
            writer.println("miligramy: "+mg+"\n");
            writer.println("gramy: "+mg/1000+"\n");
            writer.println("kilogramy: "+mg/1000000+"\n");

        } else if ("".equals(miligramy) && !("".equals(gramy)) && "".equals(kilogramy)) {
            double g = Double.valueOf(gramy);
            writer.println("Podana wartość w przeliczeniu na:");
            writer.println("miligramy: "+g*1000);
            writer.println("gramy: "+g);
            writer.println("kilogramy: "+g/1000);

        } else if ("".equals(miligramy) && "".equals(gramy) && !("".equals(kilogramy))) {
            double kg = Double.valueOf(kilogramy);
            writer.println("Podana wartość w przeliczeniu na:");
            writer.println("miligramy: "+kg*1000000);
            writer.println("gramy: "+kg*1000);
            writer.println("kilogramy: "+kg);

        } else writer.println("należy wypełnić tylko jedno pole");


    }
}
