package com.examly.springapp.controller;

import com.examly.springapp.model.MembershipType;
import com.examly.springapp.service.MembershipTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/membership-types")
public class MembershipTypeController {

    @Autowired
    private MembershipTypeService service;

    @PostMapping({"", "/"})
    @ResponseStatus(HttpStatus.CREATED)
    public MembershipType create(@RequestBody MembershipType type) {
        return service.save(type);
    }

    @PutMapping({"/{id}", "/{id}/"})
    public MembershipType update(@PathVariable Long id, @RequestBody MembershipType type) {
        type.setTypeId(id);
        return service.save(type);
    }
    @GetMapping({"", "/"})
    public List<MembershipType> getAll() {
        return service.getAll();
    }

    @GetMapping({"/{id}", "/{id}/"})
    public MembershipType getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping({"/name/{typeName}", "/name/{typeName}/"})
    public ResponseEntity<?> getByName(@PathVariable String typeName) {
        List<MembershipType> list = service.getByName(typeName);
        if (list == null || list.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .body("No membership types found");
        }
        return ResponseEntity.ok(list);
    }

    @GetMapping({"/price", "/price/"})
    public ResponseEntity<?> getByPriceRange(
            @RequestParam double min,
            @RequestParam double max) {

        List<MembershipType> list = service.getByPriceRange(min, max);
        if (list == null || list.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .body("No membership types found");
        }
        return ResponseEntity.ok(list);
    }

    @GetMapping({"/price-less/{price}", "/price-less/{price}/"})
    public ResponseEntity<?> getByPriceLessThan(@PathVariable double price) {
        List<MembershipType> list = service.getByPriceLessThan(price);
        if (list == null || list.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .body("No membership types found");
        }
        return ResponseEntity.ok(list);
    }

    @GetMapping({"/duration-greater/{months}", "/duration-greater/{months}/"})
    public ResponseEntity<?> getByDurationGreater(@PathVariable int months) {
        List<MembershipType> list = service.getByDurationGreaterThan(months);
        if (list == null || list.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .body("No membership types found with duration greater than " + months);
        }
        return ResponseEntity.ok(list);
    }
}