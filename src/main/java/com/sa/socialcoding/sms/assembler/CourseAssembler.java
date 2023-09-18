package com.sa.socialcoding.sms.assembler;

import com.sa.socialcoding.sms.dto.CourseDTO;
import com.sa.socialcoding.sms.dto.ModuleDTO;
import com.sa.socialcoding.sms.model.Course;
import com.sa.socialcoding.sms.model.Module;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Slf4j
@Component
public class CourseAssembler {

    public Course fromCourseDTOToEntity(CourseDTO courseDTO){
        Course courseEntity = new Course();
        BeanUtils.copyProperties(courseDTO, courseEntity);
        courseEntity.setCourseName(courseDTO.getCourseName());
        courseEntity.setCourseDescription(courseDTO.getCourseDescription());
        courseEntity.setDurationInMonth(courseDTO.getDurationInMonth());
        if(Objects.nonNull(courseDTO.getModuleDTO())){
            courseEntity = fromModuleEntityToDTO(courseEntity, courseDTO.getModuleDTO());
        }
        return courseEntity;
    }

    private Course fromModuleEntityToDTO(Course courseEntity, Set<ModuleDTO> moduleDTOSet){
        Set<Module> moduleSet=new HashSet<>();
        Module module = new Module();
            for(ModuleDTO moduleDTO : moduleDTOSet){
                module.setModuleDescription(moduleDTO.getModuleDescription());
                module.setModuleName(moduleDTO.getModuleName());
                module.setCourse(courseEntity);
                moduleSet.add(module);
            }
        courseEntity.setModule(moduleSet);
        return courseEntity;
    }
}
