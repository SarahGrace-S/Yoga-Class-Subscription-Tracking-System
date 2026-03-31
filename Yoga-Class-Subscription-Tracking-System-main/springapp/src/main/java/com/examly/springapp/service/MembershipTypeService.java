package com.examly.springapp.service;

import com.examly.springapp.model.MembershipType;
import java.util.List;

public interface MembershipTypeService {

    MembershipType save(MembershipType type);
    MembershipType getById(Long id);
    List<MembershipType> getAll();

    // Filters
    List<MembershipType> getByName(String typeName);
    List<MembershipType> getByPriceRange(double min, double max);
    List<MembershipType> getByDurationGreaterThan(int months);
    List<MembershipType> getByPriceLessThan(double price);
}