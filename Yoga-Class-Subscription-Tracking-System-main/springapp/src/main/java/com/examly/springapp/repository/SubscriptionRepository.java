package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.Subscription;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription,Long>{

}