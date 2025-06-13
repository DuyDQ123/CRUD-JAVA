package com.example.DuyCodeWeb.service;

import com.example.DuyCodeWeb.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long employeeId);
    List<EmployeeDto> getAllEmployees();
    EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeDto);
    EmployeeDto deleteEmployee(Long employeeId); // Thêm phương thức xóa nhân viên
}
