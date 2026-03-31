package com.examly.springapp.repository;

import com.examly.springapp.model.MembershipType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MembershipTypeRepository extends JpaRepository<MembershipType, Long> {

    // Filters for Day 11
    List<MembershipType> findByTypeName(String typeName);
    List<MembershipType> findByPriceBetween(double min, double max);
    List<MembershipType> findByDurationInMonthsGreaterThan(int months);
    List<MembershipType> findByPriceLessThan(double price);
}