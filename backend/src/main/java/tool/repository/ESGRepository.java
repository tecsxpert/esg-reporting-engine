package tool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tool.entity.ESGRecord;

public interface ESGRepository extends JpaRepository<ESGRecord, Long> {

    List<ESGRecord> findByCompanyName(String companyName);

    List<ESGRecord> findByCompanyNameContainingIgnoreCase(String companyName);

    List<ESGRecord> findByCategory(String category);
}