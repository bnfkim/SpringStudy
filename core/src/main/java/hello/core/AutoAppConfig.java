package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        //뺄 것을 미리 지정해줌 (annotation 에 Configuration 이라고 붙은 것을 뺄거라고 지정해둔 것)
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
//자동으로 Bean 을 끌어와주는 Annotation
//@Configuration 을 붙은 클래스를 찾아서 자동으로 Bean 을 붙여주는 것
public class AutoAppConfig {
}
