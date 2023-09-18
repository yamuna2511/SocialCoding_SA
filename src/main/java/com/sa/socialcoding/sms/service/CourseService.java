package com.sa.socialcoding.sms.service;

import com.sa.socialcoding.sms.model.Course;
import com.sa.socialcoding.sms.model.Module;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    List<Course> getCourses(Integer courseId);

    String createCourse(Course courseRequest);

    String createTopic(Module moduleDetails);
}
