package com.example.yttest.service.impl;

import com.example.yttest.dto.SettingDtoReq;
import com.example.yttest.dto.SettingDtoRes;
import com.example.yttest.entity.Setting;
import com.example.yttest.repository.SettingRepository;
import com.example.yttest.service.interfaces.ISetting;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class SettingService implements ISetting {
    private final SettingRepository settingRepository;
    @Autowired
    private ModelMapper modelMapper;

    public SettingService(SettingRepository settingRepository) {
        this.settingRepository = settingRepository;
    }


    @Override
    public List<SettingDtoRes> findAll() {
        List<Setting> setting = settingRepository.findAll();
        return setting.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public SettingDtoRes findById(Integer id) {
        Setting setting = settingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found with id: " + id));
        return convertToDto(setting);
    }

    @Override
    public SettingDtoRes createUser(SettingDtoReq settingCreateDto) {
        Setting setting = convertToEntity(settingCreateDto);
        Setting savedsetting = settingRepository.save(setting);
        return convertToDto(savedsetting);
    }

    @Override
    public long count() {
        return settingRepository.count();
    }

    @Override
    public void deleteById(Integer id) {
        settingRepository.deleteById(id);
    }

    private SettingDtoRes convertToDto(Setting setting) {
        return modelMapper.map(setting, SettingDtoRes.class);
    }

    private Setting convertToEntity(SettingDtoReq settingDtoReq) {
        return modelMapper.map(settingDtoReq, Setting.class);
    }
}
