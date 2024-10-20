package com.example.springdatajpamappings.springdatajpamappings.services;

import com.example.springdatajpamappings.springdatajpamappings.entities.DepartmentEntity;
import com.example.springdatajpamappings.springdatajpamappings.entities.EmployeeEntity;
import com.example.springdatajpamappings.springdatajpamappings.repositories.DepartmentRepository;
import com.example.springdatajpamappings.springdatajpamappings.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    private final EmployeeRepository employeeRepository;

    public DepartmentService(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    public DepartmentEntity createNewDepartment(DepartmentEntity department) {
        return departmentRepository.save(department);
    }

    public DepartmentEntity getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public DepartmentEntity assignManagerToDepartment(Long departmentId, Long employeeId) {

        Optional<DepartmentEntity> department = departmentRepository.findById(departmentId);
        Optional<EmployeeEntity> employee = employeeRepository.findById(employeeId);

        return department.flatMap(department1 ->
           employee.map(employee1 -> {
               department1.setManager(employee1);
               return departmentRepository.save(department1);
           })).orElse(null);
    }

    public DepartmentEntity assignWorkerToDepartment(Long departmentId, Long employeeId) {

        Optional<DepartmentEntity> department = departmentRepository.findById(departmentId);
        Optional<EmployeeEntity> employee = employeeRepository.findById(employeeId);

//        return department.flatMap(departmentEntity ->
//                employee.map(employeeEntity -> {
//                    departmentEntity.getEmployeesInTheDepartment().add(employeeEntity);
//                    return departmentRepository.save(departmentEntity);
//                })).orElse(null);

        return department.flatMap(departmentEntity ->
                employee.map(employeeEntity -> {
                    employeeEntity.setEmployeeDepartment(departmentEntity);
                    employeeRepository.save(employeeEntity);
                    departmentEntity.getEmployeesInTheDepartment().add(employeeEntity);
                    return departmentEntity;
                })).orElse(null);
    }

    public DepartmentEntity getAssignedDepartmentOfManager(Long employeeId) {

        Optional<EmployeeEntity> manager = employeeRepository.findById(employeeId);

//        return manager.map(EmployeeEntity::getManagedDepartment)
//                .orElse(null);

//        return manager.map(
//                employeeEntity -> employeeEntity.getManagedDepartment()
//        ).orElse(null);

//        return departmentRepository.findByManager(manager.get());

        EmployeeEntity employeeEntity = EmployeeEntity.builder().id(employeeId)
                .build();

        return departmentRepository.findByManager(employeeEntity);
    }
}
