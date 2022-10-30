package com.study.ikmyeongshopteam4.dto;

import com.study.ikmyeongshopteam4.dto.validation.ValidationGroups;
import lombok.Data;

import javax.validation.constraints.*;

@Data
public class RegisterReqDto {
    @NotBlank(message = "이름은 비워둘 수 없습니다.", groups = ValidationGroups.NotBlankGroup.class)
    @Size(min = 8, max = 16, message = "아이디는 8~16자여야 합니다.", groups = ValidationGroups.SizeGroup.class)
    private String username;

    @NotBlank(message = "비밀번호는 비워둘 수 없습니다.", groups = ValidationGroups.NotBlankGroup.class)
    @Size(min = 8, max = 16, message = "비밀번호는 8자부터 16자까지 입력해야 합니다.", groups = ValidationGroups.SizeGroup.class)
    @Pattern(regexp="(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}",
            message = "비밀번호는 영문 대,소문자와 숫자, 특수기호가 적어도 1개 이상씩 포함된 8자 ~ 20자의 비밀번호여야 합니다.",
            groups = ValidationGroups.PatternGroup.class)
    private String password;

    @NotBlank(groups = ValidationGroups.NotBlankGroup.class)
    @Size(min = 8, max = 16, message = "비밀번호는 8자부터 16자까지 입력해야 합니다.", groups = ValidationGroups.SizeGroup.class)
    @Pattern(regexp="(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}",
            message = "비밀번호는 영문 대,소문자와 숫자, 특수기호가 적어도 1개 이상씩 포함된 8자 ~ 20자의 비밀번호여야 합니다.",
            groups = ValidationGroups.PatternGroup.class)
    private String checkPassword;

    @NotBlank(message = "이름은 비워둘 수 없습니다.", groups = ValidationGroups.NotBlankGroup.class)
    @Size(min = 2, max = 5, groups = ValidationGroups.SizeGroup.class)
    @Pattern(regexp = "^[가-힇]*$", message = "한글만 입력할 수 있습니다.", groups = ValidationGroups.PatternGroup.class)
    private String name;

    @NotBlank(message = "이메일은 비워둘 수 없습니다.", groups = ValidationGroups.NotBlankGroup.class)
    @Email
    private String email;

    @NotBlank(message = "휴대폰 번호는 비워둘 수 없습니다.", groups = ValidationGroups.NotBlankGroup.class)
    @Size(min = 10, max = 11, groups = ValidationGroups.SizeGroup.class)
    @Pattern(regexp = "^[0-9]*$", message = "숫자만 입력할 수 있습니다.", groups = ValidationGroups.PatternGroup.class)
    private String cellphone;

    @Size(min = 10, max = 11, groups = ValidationGroups.SizeGroup.class)
    @Pattern(regexp = "^[0-9]*$", message = "숫자만 입력할 수 있습니다.", groups = ValidationGroups.PatternGroup.class)
    private String phone;

    @NotBlank(message = "주소는 비워둘 수 없습니다.", groups = ValidationGroups.NotBlankGroup.class)
    private String address;
}
