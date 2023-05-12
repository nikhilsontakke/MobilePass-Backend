package com.example.MobilePass.services;

import com.example.MobilePass.model.ActivityLog;
import com.example.MobilePass.repository.ActivityLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ActivityLogService")
public class ActivityLogServiceImpl implements ActivityLogService{
    @Autowired
    ActivityLogRepository activityLogRepository;
    public List<ActivityLog> getAllRecords() {
        return activityLogRepository.findAll();
    }
}
