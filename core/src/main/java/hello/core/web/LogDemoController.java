package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor //생성자에 autowired 자동으로 해주는 에노테이션
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final ObjectProvider<MyLogger> myLoggerProvider; //myLogger을 주입받는게 아니라 찾을 수 있는 디펜더시가 생성됨

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) { //고객 요청 정보를 받을 수 있음

        String requestURL = request.getRequestURL().toString(); //어떤 URL로 들어왔는지 알 수 있음
        MyLogger myLogger = myLoggerProvider.getObject(); //필요한 시점에 myLogger을 주입받음음
        myLogger.setMyLogger(requestURL);

        myLogger.log("controller test");
        logDemoService.logic("testID");
        return "OK";
    }
}
