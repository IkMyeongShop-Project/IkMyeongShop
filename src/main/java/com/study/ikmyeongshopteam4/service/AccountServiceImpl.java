package com.study.ikmyeongshopteam4.service;

import com.study.ikmyeongshopteam4.dto.RegisterReqDto;
import com.study.ikmyeongshopteam4.exception.CustomValidationException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AccountServiceImpl implements AccountService{

    @Override
    public void duplicateUserName(RegisterReqDto registerReqDto) throws Exception {
    }

    @Override
    public void passwordCheck(RegisterReqDto registerReqDto) throws Exception {
        if (registerReqDto.getPassword().equals(registerReqDto.getPasswordChk()) == false) {
            Map<String, String> errorMap = new HashMap<String, String>();
            errorMap.put("passwordChk", "비밀번호가 서로 다릅니다.");
            throw new CustomValidationException("Password Not Match", errorMap);
        }
    }

    @Override
    public void register(RegisterReqDto registerReqDto) throws Exception {
        if (registerReqDto.getPassword() != registerReqDto.getPasswordChk()) {
            Map<String, String> errorMap = new HashMap<String, String>();
            errorMap.put("password", "비밀번호가 서로 다릅니다.");
            throw new CustomValidationException("Duplicate email", errorMap);
        }
    }
}
