package com.example.demo.service;

import com.example.demo.dto.TestDTO;
import com.example.demo.entity.BajaEntity;
import com.example.demo.mapper.BajaMapper;
import com.example.demo.repository.BajaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    private final BajaRepository bajaRepository;
    private BajaMapper bajaMapper;

    public TestService(BajaRepository bajaRepository) {
        this.bajaRepository = bajaRepository;
        this.bajaMapper = new BajaMapper();
    }

    public Object actualizarBaja(Long id, TestDTO testDTO) {

        BajaEntity bajaEntity = bajaRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Tipo de baja con id "  + id + " no existe"));
        bajaMapper.updateEntity(bajaEntity, testDTO);
        bajaRepository.save(bajaEntity);
        return "";
    }
}
