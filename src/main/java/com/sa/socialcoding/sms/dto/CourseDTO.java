package com.sa.socialcoding.sms.dto;

import lombok.*;

import java.util.Set;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {
    private int courseId;
    private String courseName;
    private int durationInMonth;
    private String courseDescription;
    private Set<ModuleDTO> moduleDTO;
}
