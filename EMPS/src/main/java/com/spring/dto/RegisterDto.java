package com.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {
    private String staffNo;
    private String staffName;
    private String email;
    private String password;
    private Long roleId;
    private Long positionId;
    private Long departmentId;
}