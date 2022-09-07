package hello.springmvc.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController 사용시 String return 하는 문자 그대로를 반환함
//@Controller 와 같은 경우에는 viewName 으로 반환하기 때문에 다름 !
@RestController
public class LogTestController {

    private final Logger log = LoggerFactory.getLogger(getClass());
    //위의 코드 넣는 대신 클래스 단위로 @Slf4j 애노테이션을 붙여넣으면 됨

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "spring";

        System.out.println("name = " + name);

        log.trace("trace log={}", name); //로그가 남지 않음
        log.debug("debug log={}", name); //주로 개발 위치에서 봄
        log.info("info log={}", name); //ex. 비지니스 정보
        log.warn("info warn={}", name); //위험한 것
        log.error("info error={}", name); //에러

        return "ok";
    }
}
