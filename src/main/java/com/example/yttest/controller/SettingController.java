package com.example.yttest.controller;


import com.example.yttest.dto.SettingDtoReq;
import com.example.yttest.dto.SettingDtoRes;
import com.example.yttest.service.interfaces.ISetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/settings")
public class SettingController {

    @Autowired
    private ISetting settingService;

    @GetMapping
    public List<SettingDtoRes> getAllSettings() {
        return settingService.findAll();
    }

    @GetMapping("/{id}")
    public SettingDtoRes getSettingById(@PathVariable Integer id) {
        return settingService.findById(id);
    }

    @PostMapping
    public SettingDtoRes createSetting(@RequestBody SettingDtoReq settingDtoReq) {
        return settingService.createUser(settingDtoReq);
    }

    @DeleteMapping("/{id}")
    public void deleteSetting(@PathVariable Integer id) {
        settingService.deleteById(id);
    }
}

