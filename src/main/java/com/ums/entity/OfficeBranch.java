package com.ums.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "office_branches")
public class OfficeBranch extends Base {

    @NotEmpty(message = "branchname is required")
    @Column(unique = true)
    private String branchName;

    @NotEmpty(message = "branchcode is required")
    @Column(unique = true)
    private String branchCode;

    @ManyToOne
    @JoinColumn(name = "officeid")
    @JsonIgnore
    private Office office;

    @OneToMany(mappedBy = "officeBranch", cascade = CascadeType.ALL)
    private List<Employee> employees;
    @JsonIgnore

    private Boolean isDelete = false;

}