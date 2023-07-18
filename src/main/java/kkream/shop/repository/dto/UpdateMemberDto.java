package kkream.shop.repository.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateMemberDto {

    private String password;
    private String phoneNumber;
    private int shoeSize;
    private char adMessage;
    private char adEmail;
    private String profileFile;
    private String nickName;
    private String introduction;
    private String grade;

    public UpdateMemberDto(String password, String phoneNumber, int shoeSize, char adMessage, char adEmail, String profileFile, String nickName, String introduction, String grade) {
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.shoeSize = shoeSize;
        this.adMessage = adMessage;
        this.adEmail = adEmail;
        this.profileFile = profileFile;
        this.nickName = nickName;
        this.introduction = introduction;
        this.grade = grade;
    }
}
