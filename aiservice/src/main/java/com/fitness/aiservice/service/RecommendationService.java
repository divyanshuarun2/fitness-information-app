package com.fitness.aiservice.service;

import com.fitness.aiservice.model.Recomendation;
import com.fitness.aiservice.repository.RecommendationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationService {
    private final RecommendationRepo recommendationRepo;

    public List<Recomendation> getUserRecommendation(String userId) {
        return recommendationRepo.findByUserId(userId);
    }

    public Recomendation getActivityRecommendation(String activityId) {
        return recommendationRepo.findByActivityId(activityId).orElseThrow(()->new RuntimeException("No recommendation found for this activity"+activityId));

    }
}
