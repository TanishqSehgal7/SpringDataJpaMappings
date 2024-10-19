package com.example.springdatajpamappings.springdatajpamappings.repositories;

import com.example.springdatajpamappings.springdatajpamappings.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
}
