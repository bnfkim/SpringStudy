package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    //문자를 그대로 데이터로 보내주는 방법
    @GetMapping("hello-String")
    @ResponseBody //데이터를 그대로 그냥 가져옴. 문자 그대로 하는 방식
    public String helloString(@RequestParam("name") String name){
        return "hello " + name; // "hello (요청한 내용)" -> html 태그없이 그냥 무식하게 내용만 가져가짐
    }

    //데이터를 그대로 가져오는 방법
    //api 방식 -> json방식 -> key와 value 방식
    @GetMapping("hello-api")
    @ResponseBody // 이게 안 붙어있으면 viewResover한테 던짐 -> 뷰리졸버는 그럼 알아서 맞는 템플릿을 찾아 반환
    //만약 ResponseBody가 붙어있으면 http에 데이터를 그대로 옮기는 식으로 함
    //문자면 응답을 그대로 주는데, 객체를 줌 -> 객체는 json 방식으로 넘겨주는 식으로 함
    //객체 return 하면 -> HttpMessageConverter 가 응답함.
    // String이면 -> StringConverter 작동
    // 객체면 -> JsonConverter 가 작동해서 json 형식으로 바꿔줌
    public Hello helloAp(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        //프르펄티 방식 : private 해놔서 바로 못 사용하기 때문에 get/set 을 사용하는 것
        //ctr + N
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
