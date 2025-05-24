package com.example.integration.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.integration.entities.Integration;

public interface Repository extends JpaRepository<Integration, Integer> {
}
