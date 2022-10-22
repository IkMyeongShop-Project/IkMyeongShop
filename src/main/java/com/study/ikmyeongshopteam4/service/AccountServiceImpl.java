package com.study.ikmyeongshopteam4.service;

import com.study.ikmyeongshopteam4.domain.User;
import com.study.ikmyeongshopteam4.dto.RegisterReqDto;
import com.study.ikmyeongshopteam4.exception.CustomInternalServerErrorException;
import com.study.ikmyeongshopteam4.exception.CustomValidationException;
import com.study.ikmyeongshopteam4.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;
    @Override
    public void duplicateUsername(RegisterReqDto registerReqDto) throws Exception {

        User user = accountRepository.findUserByUsername(registerReqDto.getUserName());

        if (user != null) {
            Map<String, String> errorMap = new HashMap<String, String>();
            errorMap.put("username", "이미 사용중인 아이디입니다.");

            throw new CustomValidationException("Duplicate username", errorMap);
        }
    }

    @Override
    public void register(RegisterReqDto registerReqDto) throws Exception {
        //회원가입 진행
        User user = registerReqDto.toEntity();
        int result = accountRepository.saveUser(user);
        if(result == 0) {
            throw new CustomInternalServerErrorException("회원가입 중 문제가 발생하였습니다.");
        }
    }
}
