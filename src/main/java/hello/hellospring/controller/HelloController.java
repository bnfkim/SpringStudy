package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("hello") //웹 어플리케이션에서 /hello 를 호출하면 아래 메서드를 호출해줌
    public String hello(Model model){
        //data 는 key(변수명)이 되고 hello 는 value 로 들어가짐
        model.addAttribute("data", "Spring!!");
        return "hello"; //hello.html 을 찾아서 해당 html을 렌더링 해줌
    }

    @GetMapping("hello-mvc")
    // hello-mvc?name=(넣고싶은 내용을 넣음) -> 해야 서버가 정상적으로 보잉ㅁ
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }
}
