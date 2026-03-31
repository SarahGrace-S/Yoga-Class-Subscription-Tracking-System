package com.examly.springapp.service;

import com.examly.springapp.model.MembershipType;
import com.examly.springapp.repository.MembershipTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembershipTypeServiceImpl implements MembershipTypeService {

    @Autowired
    private MembershipTypeRepository repository;

    @Override
    public MembershipType save(MembershipType type) {
        return repository.save(type);
    }

    @Override
    public MembershipType getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<MembershipType> getAll() {
        return repository.findAll();
    }

    @Override
    public List<MembershipType> getByName(String typeName) {
        return repository.findByTypeName(typeName);
    }

    @Override
    public List<MembershipType> getByPriceRange(double min, double max) {
        return repository.findByPriceBetween(min, max);
    }

    @Override
    public List<MembershipType> getByDurationGreaterThan(int months) {
        return repository.findByDurationInMonthsGreaterThan(months);
    }

    @Override
    public List<MembershipType> getByPriceLessThan(double price) {
        return repository.findByPriceLessThan(price);
    }
}