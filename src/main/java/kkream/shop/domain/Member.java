package kkream.shop.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Member {

    private Long memberId;
    private String email;
    private String password;
    private String phoneNumber;
    private int shoeSize;
    private char adMessage;
    private char adEmail;
    private String profileFile;
    private String nickName;
    private String name;
    private String introduction;
    private String grade;
    private String memberDate;
    private char deletedStatus;

    public Member() {
    }

    public Member(String email, String password, String phoneNumber, int shoeSize, char adMessage,
                  char adEmail, String nickName, String name,String grade) {
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.shoeSize = shoeSize;
        this.adMessage = adMessage;
        this.adEmail = adEmail;
        this.nickName = nickName;
        this.name = name;
        this.grade = grade;
    }
}
