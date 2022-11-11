package com.example.betterme.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    /*Spring Security 에서는 권한 코드에 항상 ROLE_ 이 앞에 있어야 함
    따라서 키 값을 ROLE_USER, ROLE_ADMIN 로 지정*/
    USER("ROLE_USER","사용자"),
    ADMIN("ROLE_ADMIN","관리자");

    private final String key;
    private final String title;
}
