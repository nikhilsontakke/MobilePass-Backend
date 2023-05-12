package com.example.MobilePass.repository;

import com.example.MobilePass.model.ActivityLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ActivityLogRepository extends MongoRepository<ActivityLog,Integer> {
}
