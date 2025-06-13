package com.example.DuyCodeWeb.service.impl;
import java.util.List;
import java.util.stream.Collectors;
import com.example.DuyCodeWeb.entity.Employee;
import com.example.DuyCodeWeb.mapper.EmployeeMapper;
import com.example.DuyCodeWeb.repository.EmployeeRepository;
import com.example.DuyCodeWeb.service.EmployeeService;
import com.example.DuyCodeWeb.dto.EmployeeDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Comparator;
@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.maptoEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);


        return EmployeeMapper.maptoEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new RuntimeException("Employee not found with id: " + employeeId));

        return EmployeeMapper.maptoEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .sorted(Comparator.comparing(Employee::getId))
                .map(EmployeeMapper::maptoEmployeeDto)
                .collect(Collectors.toList());
    }
    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeDto) {
        Employee existingEmployee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + employeeId));

        existingEmployee.setFirstName(employeeDto.getFirstName());
        existingEmployee.setLastName(employeeDto.getLastName());
        existingEmployee.setEmail(employeeDto.getEmail());

        Employee updatedEmployee = employeeRepository.save(existingEmployee);
        return EmployeeMapper.maptoEmployeeDto(updatedEmployee);
    }
    @Override
    public EmployeeDto deleteEmployee(Long employeeId) {
        Employee existingEmployee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + employeeId));

        employeeRepository.delete(existingEmployee);
        return EmployeeMapper.maptoEmployeeDto(existingEmployee);
    }
}