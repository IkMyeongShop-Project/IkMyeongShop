package com.study.ikmyeongshopteam4.dto;

import com.study.ikmyeongshopteam4.dto.validation.ValidationGroups;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class RegisterReqDto {
    // 통과 시 사용가능한 아이디입니다.
    @NotBlank(message = "필수항목 입니다.", groups = ValidationGroups.NotBlankGroup.class)
    @Size(min = 4, max = 50, message = "최소 4자, 최대 50자 이하 입력해 주세요.", groups = ValidationGroups.SizeGroup.class)
    private String userName;

    @NotBlank(message = "필수항목 입니다.", groups = ValidationGroups.NotBlankGroup.class)
    @Size(min = 10, max = 16, message = "최소 10자, 최대 16자 이하 입력해 주세요.", groups = ValidationGroups.SizeGroup.class)
    @Pattern(regexp = "^(([a-z]+[A-Z]+)|([a-z]+[0-9]+)|([a-z]+[~!@#$%^&*_]+)|([A-Z]+[0-9]+)|([A-Z]+[~!@#$%^&*_]+)|([0-9]+[~!@#$%^&*_]+))[a-zA-Z\\d-~!@#$%^&*_]*$",
            message = "사용불가! 영문대/소문자, 숫자, 특수문자 중 2가지 이상 조합하세요.", groups = ValidationGroups.PatternCheckGroup.class)
    private String password;

    @NotBlank(message = "필수항목 입니다.", groups = ValidationGroups.NotBlankGroup.class)
    @Size(min = 10, max = 16, message = "최소 10자, 최대 16자 이하 입력해 주세요.", groups = ValidationGroups.SizeGroup.class)
    @Pattern(regexp = "^(([a-z]+[A-Z]+)|([a-z]+[0-9]+)|([a-z]+[~!@#$%^&*_]+)|([A-Z]+[0-9]+)|([A-Z]+[~!@#$%^&*_]+)|([0-9]+[~!@#$%^&*_]+))[a-zA-Z\\d-~!@#$%^&*_]*$",
            message = "사용불가! 영문대/소문자, 숫자, 특수문자 중 2가지 이상 조합하세요.", groups = ValidationGroups.PatternCheckGroup.class)
    private String passwordChk;

    @NotBlank(message = "필수항목 입니다.", groups = ValidationGroups.NotBlankGroup.class)
    @Size(min = 2, max = 5, message = "최소 2자, 최대 5자 이하 입력해 주세요.", groups = ValidationGroups.SizeGroup.class)
    @Pattern(regexp = "^[가-힣]*$", message = "이름은 한글만 입력 가능합니다.", groups = ValidationGroups.PatternCheckGroup.class)
    private String name;

    // 이메일 형식
    @NotBlank(message = "필수항목 입니다.", groups = ValidationGroups.NotBlankGroup.class)
    @Email(message = "이메일을 정확하게 입력해 주세요.", groups = ValidationGroups.PatternCheckGroup.class)
    private String email;

    // null 허용
    private int cellPhone;
    private int phone;
    private int postCode;
    private String address;
    private String addressSub;


//    public User toEntity() {
//        return User.builder()
//                .build();
//    }
}
