package com.esg.backend.controller;

import com.esg.backend.entity.Report;
import com.esg.backend.repository.ReportRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin("*")
public class ReportController {

    @Autowired
    private ReportRepository reportRepository;

    // GET ALL
    @GetMapping
    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    // CREATE
    @PostMapping
    public Report createReport(@RequestBody Report report) {
        return reportRepository.save(report);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Report updateReport(@PathVariable Long id,
                               @RequestBody Report updatedReport) {

        Report report = reportRepository.findById(id).orElseThrow();

        report.setCompanyName(updatedReport.getCompanyName());
        report.setCategory(updatedReport.getCategory());
        report.setScore(updatedReport.getScore());

        return reportRepository.save(report);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteReport(@PathVariable Long id) {

        reportRepository.deleteById(id);

        return "Report Deleted Successfully";
    }

    // SEARCH
    @GetMapping("/search")
    public List<Report> searchReports(@RequestParam String q) {

        return reportRepository
                .findByCompanyNameContainingIgnoreCase(q);
    }
}