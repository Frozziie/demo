package com.example.demo.mapper;

import com.example.demo.dto.TestDTO;
import com.example.demo.entity.BajaEntity;

public class BajaMapper {

    public void updateEntity(BajaEntity bajaEntity, TestDTO testDTO) {
        bajaEntity.setCode(testDTO.getCode());
        bajaEntity.setDetail(testDTO.getDetail());
    }
}
