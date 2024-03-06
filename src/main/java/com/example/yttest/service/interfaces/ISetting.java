package com.example.yttest.service.interfaces;

import com.example.yttest.dto.ClientDtoReq;
import com.example.yttest.dto.ClientDtoRes;
import com.example.yttest.dto.SettingDtoReq;
import com.example.yttest.dto.SettingDtoRes;

import java.util.List;

public interface ISetting {
    List<SettingDtoRes> findAll();

    SettingDtoRes findById(Integer id);
    SettingDtoRes createUser(SettingDtoReq settingDtoReq);

    long count();

    void deleteById(Integer id);
}
