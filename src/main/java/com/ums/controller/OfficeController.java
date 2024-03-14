package com.ums.controller;

import com.ums.dto.OfficeDto;
import com.ums.entity.Office;
import com.ums.response.ResponseModel;
import com.ums.service.OfficeService;
import jakarta.validation.Valid;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/offices")
public class OfficeController {

    private OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @PostMapping("/create")
    public ResponseEntity<Office> createOffice(@RequestBody Office office) {
        Office createdOffice = officeService.createOffice(office);
        return new ResponseEntity<>(createdOffice, HttpStatus.CREATED);
    }
}