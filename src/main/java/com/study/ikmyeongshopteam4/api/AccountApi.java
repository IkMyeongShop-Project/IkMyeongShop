package com.study.ikmyeongshopteam4.api;

import com.study.ikmyeongshopteam4.aop.annotation.LogAspect;
import com.study.ikmyeongshopteam4.dto.CMRespDto;
import com.study.ikmyeongshopteam4.dto.RegisterReqDto;
import com.study.ikmyeongshopteam4.dto.validation.ValidationSequence;
import com.study.ikmyeongshopteam4.security.PrincipalDetails;
import com.study.ikmyeongshopteam4.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.security.Principal;

@RequestMapping("/api/account")
@RestController
@RequiredArgsConstructor
public class AccountApi {

    public final AccountService accountService;

    @LogAspect
    @PostMapping("/register")
    public ResponseEntity<?> register(@Validated(ValidationSequence.class) @RequestBody RegisterReqDto registerReqDto,
                                      BindingResult bindingResult) throws Exception{

        accountService.duplicateUserName(registerReqDto);
        accountService.passwordCheck(registerReqDto);
        accountService.register(registerReqDto);
        return ResponseEntity.created(URI.create("/account/register_ok")).body(new CMRespDto<>("회원가입 성공", registerReqDto.getUserName()));
    }

    @GetMapping("/principal")
    public ResponseEntity<?> getPrincipal(@AuthenticationPrincipal PrincipalDetails principalDetails ) {

        return ResponseEntity.ok(new CMRespDto<>("successfully get Principal", principalDetails == null ? "" : principalDetails));

    }

}
