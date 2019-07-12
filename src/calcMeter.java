import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calcMeter")
public class calcMeter extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String metry = request.getParameter("metry");
        String centrymetry = request.getParameter("centymetry");
        String milimetry = request.getParameter("milimetry");

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();

        if (!("".equals(metry)) && "".equals(centrymetry) && "".equals(milimetry)) {
            double m = Double.valueOf(metry);
            writer.println("Podana wartość w przeliczeniu na:\n\n");
            writer.println("metry: "+m+"\n");
            writer.println("centymetry: "+m*100+"\n");
            writer.println("milimetry: "+m*1000+"\n");

        } else if ("".equals(metry) && !("".equals(centrymetry)) && "".equals(milimetry)) {
            double cm = Double.valueOf(centrymetry);
            writer.println("Podana wartość w przeliczeniu na:");
            writer.println("metry: "+cm/100);
            writer.println("centymetry: "+cm);
            writer.println("milimetry: "+cm*10);

        } else if ("".equals(metry) && "".equals(centrymetry) && !("".equals(milimetry))) {
            double mm = Double.valueOf(milimetry);
            writer.println("Podana wartość w przeliczeniu na:");
            writer.println("metry: "+mm/1000);
            writer.println("centymetry: "+mm/10);
            writer.println("milimetry: "+mm);

        } else writer.println("należy wypełnić tylko jedno pole");

    }
}
