package com.ums.controller;

import com.ums.dto.OfficeBranchDto;
import com.ums.entity.OfficeBranch;
import com.ums.response.ResponseModel;
import com.ums.service.OfficeBranchService;
import jakarta.validation.Valid;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/officeBranches")
public class OfficeBranchController {
    @Autowired
    private OfficeBranchService officeBranchService;


    @PostMapping("/create")
    public ResponseEntity<OfficeBranch> createOfficeBranch(@RequestBody OfficeBranchDto officeBranch) {
        OfficeBranch createdOfficeBranch = officeBranchService.createOfficeBranch(officeBranch);
        return new ResponseEntity<>(createdOfficeBranch, HttpStatus.CREATED);
    }
}

