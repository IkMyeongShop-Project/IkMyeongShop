package com.study.ikmyeongshopteam4.service;


import com.study.ikmyeongshopteam4.domain.User;
import com.study.ikmyeongshopteam4.dto.RegisterReqDto;
import com.study.ikmyeongshopteam4.exception.CustomValidationException;
import com.study.ikmyeongshopteam4.exception.CustominternalServerErrorException;
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
    public void duplicateEmail(RegisterReqDto registerReqDto) throws Exception{

        User user = accountRepository.findUserByEmail((registerReqDto.getEmail()));

        if(user != null){
            Map<String,String> errorMap = new HashMap<String,String>();
            errorMap.put("email", "이미 사용중인 이메일 주소입니다.");

            throw new CustomValidationException("Duplicate email", errorMap);

        }
    }

    @Override
    public void register(RegisterReqDto registerReqDto) throws Exception{

        User user = registerReqDto.toEntity();
        int result = accountRepository.saveUser(user);
        if(result == 0){
            throw new CustominternalServerErrorException("회원가입중 문제가 발생했습니다.");
        }
    }
}
