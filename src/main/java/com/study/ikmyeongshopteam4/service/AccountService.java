package com.study.ikmyeongshopteam4.service;

import com.study.ikmyeongshopteam4.dto.RegisterReqDto;

public interface AccountService {

    public void duplicateUsername(RegisterReqDto registerReqDto) throws Exception;

    public void register(RegisterReqDto registerReqDto) throws Exception;

}
