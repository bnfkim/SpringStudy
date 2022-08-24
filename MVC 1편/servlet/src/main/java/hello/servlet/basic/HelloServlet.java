package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//url 입력할 때 hello 로 들어오면 들어와짐
@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    @Override //서블릿이 호출되면 서비스 메서드가 호출됨
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.service(req, resp);

        System.out.println("HelloServlet.service");
        System.out.println("req = " + req);
        System.out.println("resp = " + resp);

        // /hello?username=kim 이라고 했을 때 파라메터를 담아 할 수 있음.
        String username = req.getParameter("username");
        System.out.println("username = " + username);

        //header 정보에 들어감
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("utf-8");
        //http method body 에 write 를 해줌 -> 페이지 소스보기 하면 그대로 들어가는 것을 알 수 잇음
        resp.getWriter().write("hello " + username);

    }
}
