package com.example.betterme.controller;

import ch.qos.logback.core.encoder.EchoEncoder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


/*JUnit4는 @RunWith(SpringRunner.class)를 쓰지만 JUnit5부터는 @ExtendWith(SpringExtension.class)를 써야함
 이는 테스트를 진행할 때 JUnit 에 내장된 실행자 외에 다른 실행자를 실행시킴*/
@ExtendWith(SpringExtension.class)
/*Web 에 집중할 수 있는 어노테이션*/
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {
    /*스프링이 관리하는 빈을 주입 받습니다*/
    @Autowired
    private MockMvc mvc;

    @Test
    public void hello_test() throws Exception {
        String hello = "hello Spring Boot!";

        mvc.perform(get("/hello"))
                /*HTTP Header 의 상태코드*/
                .andExpect(status().isOk())
                /*mvc.perform 의 결과를 검증*/
                .andExpect(content().string(hello));

    }

    @Test
    public void helloDto_Test() throws Exception {
        String name = "eunyoung";
        String nickname = "babo";

        /*param : API 테스트할 때 요청 파라미터를 설정, 값은 String 값만 허용됨*/
        /*jsonPath : JSON 응답값을 필드별로 검증할 수 있는 메소드, $ 를 기준으로 필드명 명시*/
        mvc.perform(
                        get("/hello/dto")
                                .param("name", name)
                                .param("nickname", nickname))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.nickname", is(nickname)));

    }

}
