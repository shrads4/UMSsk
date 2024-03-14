package com.ums.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    @Table(name = "offices")
    public class Office extends Base {
        @NotEmpty(message = "Office name is required")
        @Column(unique = true)

        private String officeName;


        @NotEmpty(message = "Office region is required")
        private String region;

        @OneToMany(mappedBy="office", cascade =CascadeType.ALL)
        @JsonIgnore
        private List<OfficeBranch> OfficeBranch;

        private Boolean isDelete = false;
    }


