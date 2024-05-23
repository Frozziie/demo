package com.example.demo.controller;

import com.example.demo.dto.TestDTO;
import com.example.demo.service.TestService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/baja")
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> actualizarBaja(@PathVariable("id") Long id,
                                                 @Valid @RequestBody TestDTO testDTO) {
        return ResponseEntity.ok(testService.actualizarBaja(id, testDTO));
    }
}
