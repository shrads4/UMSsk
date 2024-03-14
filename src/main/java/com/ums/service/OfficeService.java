package com.ums.service;

import com.ums.dto.OfficeDto;
import com.ums.entity.Office;
import com.ums.exception.CustomException;
import com.ums.repository.IOffice;
import com.ums.utils.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;


import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Service
public class OfficeService {

    private final IOffice officeRepository;

    @Autowired
    public OfficeService(IOffice officeRepository) {
        this.officeRepository = officeRepository;
    }

    public Office createOffice(Office office) {
        return officeRepository.save(office);
    }
}