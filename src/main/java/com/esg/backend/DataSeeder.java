package com.esg.backend;

import com.esg.backend.entity.Report;
import com.esg.backend.repository.ReportRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final ReportRepository reportRepository;

    public DataSeeder(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (reportRepository.count() == 0) {

            reportRepository.save(
                    new Report("Tesla", "Environment", 88)
            );

            reportRepository.save(
                    new Report("Microsoft", "Governance", 92)
            );

            reportRepository.save(
                    new Report("Infosys", "Social", 85)
            );
        }
    }
}