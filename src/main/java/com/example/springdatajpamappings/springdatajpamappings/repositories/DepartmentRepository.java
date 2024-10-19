package com.example.springdatajpamappings.springdatajpamappings.repositories;

import com.example.springdatajpamappings.springdatajpamappings.entities.DepartmentEntity;
import com.example.springdatajpamappings.springdatajpamappings.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {

    DepartmentEntity findByManager(EmployeeEntity employeeEntity);

}
