package com.activity.activityservice.service;

import com.activity.activityservice.Repository.ActivityRepo;
import com.activity.activityservice.dto.ActivityRequest;
import com.activity.activityservice.dto.ActivityResponse;
import com.activity.activityservice.model.Activity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepo activityRepo;

    public ActivityResponse trackActivity(ActivityRequest request) {
 Activity activity = Activity.builder()
         .userId(request.getUserId())
         .type(request.getType())
         .duration(request.getDuration())
         .caloriesBurnt(request.getCaloriesBurnt())
         .startTime(request.getStartTime())
         .additionalMetrics(request.getAdditionalMetrics())
         .build();
 Activity savedActivity= activityRepo.save(activity);
 return createActivityResponse(savedActivity);
    }

    private ActivityResponse createActivityResponse(Activity savedActivity) {
        ActivityResponse activityResponse= new ActivityResponse();
        activityResponse.setId(savedActivity.getId());
        activityResponse.setUserId(savedActivity.getUserId());
        activityResponse.setType(savedActivity.getType());
        activityResponse.setDuration(savedActivity.getDuration());
        activityResponse.setCaloriesBurnt(savedActivity.getCaloriesBurnt());
        activityResponse.setStartTime(savedActivity.getStartTime());
        activityResponse.setAdditionalMetrics(savedActivity.getAdditionalMetrics());
        activityResponse.setCreatedAt(savedActivity.getCreatedAt());
        activityResponse.setUpdatedAt(savedActivity.getUpdatedAt());
        return activityResponse;
    }

    public List<ActivityResponse> getAllActivities(String userId) {
        List<Activity> activities = activityRepo.findByUserId(userId);
        return activities.stream()
                .map(this::createActivityResponse)
                .collect(Collectors.toList());
    }

    public ActivityResponse getActivity(String id) {
         Activity activity = activityRepo.findById(id).orElseThrow(()->new RuntimeException("Id not found"));
        return createActivityResponse(activity);
    }
}
