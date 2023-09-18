package com.sa.socialcoding.sms.service.impl;

import com.sa.socialcoding.sms.assembler.CourseAssembler;
import com.sa.socialcoding.sms.model.Course;
import com.sa.socialcoding.sms.model.Module;
import com.sa.socialcoding.sms.model.Topic;
import com.sa.socialcoding.sms.repository.CourseRepository;
import com.sa.socialcoding.sms.repository.ModuleRepository;
import com.sa.socialcoding.sms.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseAssembler courseAssembler;

    @Autowired
    private ModuleRepository moduleRepository;
    @Override
    public List<Course> getCourses(Integer courseId) {

       //return courseRepository.getById(courseId);
        return null;
    }

    @Override
    public String createCourse(Course courseReq) {
        //Course course=courseAssembler.fromCourseDTOToEntity(courseReq);
        Course course= new Course();
        Module moduleNew = new Module();
        Set<Module> moduleSetNew = new HashSet<>();
        course.setCourseName(courseReq.getCourseName());
        course.setCourseDescription(courseReq.getCourseDescription());
        course.setDurationInMonth(courseReq.getDurationInMonth());
        Set<Module> moduleSet=courseReq.getModule();
        if(Objects.nonNull(moduleSet)){
            for(Module module : moduleSet){
                moduleNew.setModuleDescription(module.getModuleDescription());
                moduleNew.setModuleName(module.getModuleName());
                moduleNew.setCourse(course);
                moduleSetNew.add(moduleNew);
            }
        }

        course.setModule(moduleSetNew);
        courseRepository.save(course);
        return "course created successfully";
    }

    @Override
    public String createTopic(Module moduleDetails) {
        /*odule modules = new Module();
        modules.setCourse(moduleDetails.getCourse());
        modules.setModuleId(moduleDetails.getModuleId());
        modules.setModuleDescription(moduleDetails.getModuleDescription());
        modules.setModuleName(moduleDetails.getModuleName());*/
        Topic topic = new Topic();
        Set<Topic> topicSetNew = new HashSet<>();
        Set<Topic> topicSet=moduleDetails.getTopic();
        if(Objects.nonNull(topicSet)){
            for(Topic topics : topicSet){
                topic.setModule(moduleDetails);
                topic.setTopicName(topics.getTopicName());
                topic.setTopicDescription(topics.getTopicDescription());
                topic.setTopicType(topics.getTopicType());
                topic.setSeqNo(topics.getSeqNo());
                topicSetNew.add(topic);
            }
        }

        moduleDetails.setTopic(topicSetNew);
        moduleRepository.saveAndFlush(moduleDetails);
        return "Topic created successfully";
    }
}
