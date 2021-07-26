package com.piotrsarnecki.demo_gym.rest;

import com.piotrsarnecki.demo_gym.rest.dto.EmployeeDTO;
import com.piotrsarnecki.demo_gym.services.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public List<EmployeeDTO> findEmployees() {
        return employeeService.findEmployees();
    }

    @PostMapping("/employee")
    public EmployeeDTO addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        return employeeService.addEmployee(employeeDTO);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity deleteEmployee(@PathVariable(name = "id") Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok().build();
    }

    @Operation(description = "set employee gym where will be working")
    @PostMapping("/employee/{employeeId}/gym/{gymId}")
    public EmployeeDTO addEmployeeToGym(@PathVariable(name = "employeeId") Long employeeId,
                                        @PathVariable(name = "gymId") Long gymId) {
        return employeeService.addEmployeeToGym(employeeId, gymId);
    }
}
