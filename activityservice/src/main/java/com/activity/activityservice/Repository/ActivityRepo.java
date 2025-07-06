package com.activity.activityservice.Repository;

import com.activity.activityservice.model.Activity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ActivityRepo extends MongoRepository<Activity,String> {
    List<Activity> findByUserId(String userId);
}
