package com.example.betterme.domain.user;

/*User 테이블의 용도는 회원 CRUD, 로그인 등*/
/*필요한 column 은 아이디, 비밀번호, 이메일, 닉네임*/
/*role 을 추가해서 관리자, 사용자 구분 (권한)*/

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
/*NoArgsConstructor : lombok annotation 으로 빈 생성자를 만듦*/
@NoArgsConstructor
/*Entity: 해당 클래스가 엔터티를 위한 클래스이며, 해당 클래스의 인스턴스들이 JPA 로 관리되는 엔터티 객체라는 것을 의미
 * 즉, 테이블의 의미함
 * 디폴트 값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍(_) 으로 테이블 이름을 매칭함*/
@Entity
public class User {
    /*@Id: 테이블의 Primary Key(PK)*/
    @Id
    /*PK 를 자동으로 생성하고자 할 때 사용함
     * 즉, auto_increment 를 말함, 여기서는 JPA 의 넘버링 전략이 아닌 이 전략 사용
     * (전에 application.yml 설정에서 use-new-id-generate-mappings: false 로 한 것이 있음)*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //sequence, auto_increment

    /*@Column: 해당 필드가 column( 이라는 것을 말하고, @Column 에는 다양한 속성 지정 가능
     * (nullable=false: null 값이 되면 안됨! length=30: 길이 제한! )*/
    @Column(nullable = false, length = 30)
    private String username; //아이디

    @Column(nullable = false,length = 100)
    private String password; //비밀번호

    @Column(nullable = false, length = 50)
    private String email; //이메일

    @Column(nullable = false, length = 50)
    private String nickname; //닉네임

    /*JPA 로 DB 에 저장할 때 Enum 값을 어떤 형태로 저장할지 결정
    *기본적으로는 int 로 저장하지만 int 로 저장하면 무슨 의미인지 알 수가 없기 때문에
    문자열로 저장될 수 있도록 설정함*/
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

}