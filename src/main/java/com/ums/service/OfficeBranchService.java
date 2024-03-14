package com.ums.service;

import com.ums.dto.OfficeBranchDto;
import com.ums.entity.OfficeBranch;
import com.ums.entity.Office;
import com.ums.exception.CustomException;
import com.ums.repository.IOffice;
import com.ums.repository.IOfficeBranch;
import com.ums.utils.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
@Service
public class OfficeBranchService {
    @Autowired
    private IOfficeBranch officeBranchRepository;

    @Autowired
    private IOffice officeRepository;
    public OfficeBranch createOfficeBranch(OfficeBranchDto officeBranch) {
        Optional<Office> office = Optional.ofNullable(officeBranch.getOfficeId()).flatMap(officeRepository::findById);

        OfficeBranch office1 = new OfficeBranch();
        office.ifPresent(office1::setOffice);

        office1.setBranchName(officeBranch.getBranchName());
        office1.setBranchCode(officeBranch.getBranchCode());

        return officeBranchRepository.save(office1);
    }


}