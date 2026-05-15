package tool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import tool.entity.ESGRecord;
import tool.service.ESGService;

@RestController
@RequestMapping("/api/esg")
public class ESGController {

    @Autowired
    private ESGService service;

    // CREATE

    @PostMapping
    public ESGRecord create(@Valid @RequestBody ESGRecord record) {
        return service.create(record);
    }

    // GET ALL
    @GetMapping
    public List<ESGRecord> getAll() {
        return service.getAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ESGRecord getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ESGRecord update(
            @PathVariable Long id,
            @RequestBody ESGRecord record
    ) {
        return service.update(id, record);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Record deleted successfully";
    }

    // SEARCH BY COMPANY
    @GetMapping("/search")
    public List<ESGRecord> searchByCompany(
            @RequestParam String company
    ) {
        return service.searchByCompany(company);
    }

    // SEARCH BY CATEGORY
    @GetMapping("/category")
    public List<ESGRecord> searchByCategory(
            @RequestParam String category
    ) {
        return service.searchByCategory(category);
    }
}