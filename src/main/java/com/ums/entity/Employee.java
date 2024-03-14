package com.ums.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name="Employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee extends Base {


    @NotEmpty(message = "Employee name:")
    @Column(unique = true)
    private String employeeName;

    @NotNull(message = "Employee Phone number")
    private String phoneNumber;

    @NotNull(message = "Employee Salary:")
    private Double salary;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    @JoinColumn(name = "office_branch_id")
    private OfficeBranch officeBranch;


    public void setOfficeBranch(OfficeBranch officeBranch){
        this.officeBranch = officeBranch;
    }

    private Boolean isDelete = false;
}


