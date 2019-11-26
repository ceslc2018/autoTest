package hello;

import com.google.common.base.Predicates;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@SpringBootApplication
@ComponentScan(value = "GDDA")
@Configuration
public class Application {
    public static void main(String[] args){

        SpringApplication.run(Application.class,args);
    }

    public class SwaggerConfig {
        @Bean
        public Docket api() {
            return new Docket(DocumentationType.SWAGGER_2)
                    .apiInfo(apiInfo())
                    .pathMapping("/")
                    .select()
                    .paths(Predicates.not(PathSelectors.regex("/error.*")))//错误路径不监控
                    .paths(PathSelectors.regex("/.*"))
                    .apis(RequestHandlerSelectors.any())// 对所有api进行监控
                    .build();

        }

        private ApiInfo apiInfo() {
            return new ApiInfoBuilder()
                    .title("接口说明")
                    .description("档案解决方案事业部")
 //                   .contact(new Contact("罗春", "", ""))
                    .version("2.0")
                    .license("自动化接口测试")
                    .build();
        }

    }
}
