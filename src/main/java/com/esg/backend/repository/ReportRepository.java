package com.esg.backend.repository;

import com.esg.backend.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {

    List<Report> findByCompanyNameContainingIgnoreCase(String companyName);
}