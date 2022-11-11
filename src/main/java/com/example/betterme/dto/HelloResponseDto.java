package com.example.betterme.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/*선언된 모든 필드의 getter 메소드 생성*/
@Getter
/*선언된 모든 final 이 붙은 필드가 포함된 생성자 생성*/
@RequiredArgsConstructor
public class HelloResponseDto {
    /*DTO(Data Transfer Object): 계층 간 데이터 교환하기 위해 사용하는 객체 */
    /*DTO 는 로직을 가지지 않는 순수한 데이터 객체(getter&setter 만 가진 클래스)임*/
    private final String name;
    private final String nickname;
}
