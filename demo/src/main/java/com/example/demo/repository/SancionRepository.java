package com.example.demo.repository;

import com.example.demo.entities.Sancion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SancionRepository extends JpaRepository<Sancion,Long> {
}
