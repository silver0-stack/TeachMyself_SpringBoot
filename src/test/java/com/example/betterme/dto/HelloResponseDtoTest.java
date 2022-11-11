package com.example.betterme.dto;

import org.junit.jupiter.api.Test;

/*JUnit 의 기본 asserThat 이 아닌 assertj 로 사용했다는 점 주의!*/
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {
    @Test
    public void 롬복_기능_테스트(){
        //given
        String name="eunyoung";
        String nickname="babo";

        //when
        HelloResponseDto helloResponseDto=new HelloResponseDto(name,nickname);

        //then
        /*assertj 라는 테스트 검증 라이브러리로 검증함*/
        /*isEqualTo 로 값을 비교*/
        assertThat(helloResponseDto.getName()).isEqualTo(name);
        assertThat(helloResponseDto.getNickname()).isEqualTo(nickname);
    }
}
