package com.example.liveasy.project.repository;

import com.example.liveasy.project.entity.Load;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface LoadDetailsRepository extends JpaRepository<Load, UUID> {
    List<Load> findByShipperId(String shipperId);
}
