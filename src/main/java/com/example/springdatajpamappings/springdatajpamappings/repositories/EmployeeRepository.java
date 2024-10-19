package com.example.springdatajpamappings.springdatajpamappings.repositories;

import com.example.springdatajpamappings.springdatajpamappings.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}
