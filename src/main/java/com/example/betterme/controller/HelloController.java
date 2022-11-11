package com.example.betterme.controller;

import com.example.betterme.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//JSON(데이터)를 반환하는 컨트롤러
@RestController
public class HelloController {

    //HTTP Method 인 GET 의 요청을 받을 수 있는 annotation
    @GetMapping("/hello")
    public String hello(){
        return "hello Spring Boot!";
    }

    @GetMapping("/hello/dto")
    /*RequestParam : 외부에서 API 로 넘긴 파라미터(@RequestPram("name"),@RequestParam("nickname"))를 가져와
    * String name, String nickname 에 각각 저장 */
    public HelloResponseDto helloResponseDto(@RequestParam("name") String name,@RequestParam("nickname") String nickname){
        return new HelloResponseDto(name, nickname);
    }

}
