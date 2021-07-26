package com.piotrsarnecki.demo_gym.services;

import com.piotrsarnecki.demo_gym.entities.EmployeeEntity;
import com.piotrsarnecki.demo_gym.entities.GymEntity;
import com.piotrsarnecki.demo_gym.repositories.EmployeeRepository;
import com.piotrsarnecki.demo_gym.repositories.GymRepository;
import com.piotrsarnecki.demo_gym.rest.dto.EmployeeDTO;
import com.piotrsarnecki.demo_gym.util.EntityDtoMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final GymRepository gymRepository;

    public EmployeeService(EmployeeRepository employeeRepository, GymRepository gymRepository) {
        this.employeeRepository = employeeRepository;
        this.gymRepository = gymRepository;
    }


    public List<EmployeeDTO> findEmployees() {
        return employeeRepository.findAll().stream()
                .map(EntityDtoMapper::map)
                .collect(Collectors.toList());
    }

    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = EntityDtoMapper.map(employeeDTO);
        EmployeeEntity save = employeeRepository.save(employeeEntity);
        return EntityDtoMapper.map(save);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public EmployeeDTO addEmployeeToGym(Long employeeId, Long gymId) {
        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).get();
        GymEntity gymEntity = gymRepository.findById(gymId).get();
        employeeEntity.setGymEntity(gymEntity);
        gymEntity.getEmployeeEntities().add(employeeEntity);
        EmployeeEntity save = employeeRepository.save(employeeEntity);
        return EntityDtoMapper.map(save);
    }
}
