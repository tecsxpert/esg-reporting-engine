package tool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tool.entity.ESGRecord;
import tool.repository.ESGRepository;

@Service
public class ESGService {

    @Autowired
    private ESGRepository repository;

    // CREATE
    public ESGRecord create(ESGRecord record) {
        return repository.save(record);
    }

    // GET ALL
    public List<ESGRecord> getAll() {
        return repository.findAll();
    }

    // GET BY ID
    public ESGRecord getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // UPDATE
    public ESGRecord update(Long id, ESGRecord updatedRecord) {

        ESGRecord existing = repository.findById(id).orElse(null);

        if (existing != null) {
            existing.setCompanyName(updatedRecord.getCompanyName());
            existing.setCategory(updatedRecord.getCategory());
            existing.setScore(updatedRecord.getScore());
            existing.setDescription(updatedRecord.getDescription());

            return repository.save(existing);
        }

        return null;
    }

    // DELETE
    public void delete(Long id) {
        repository.deleteById(id);
    }

    // SEARCH BY COMPANY
    public List<ESGRecord> searchByCompany(String companyName) {
        return repository.findByCompanyNameContainingIgnoreCase(companyName);
    }

    // SEARCH BY CATEGORY
    public List<ESGRecord> searchByCategory(String category) {
        return repository.findByCategory(category);
    }
}