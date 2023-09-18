package com.sa.socialcoding.sms.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="COURSE")
public class Course
{
    @Id
    @GeneratedValue
    @Column(name = "COURSE_ID")
    private int courseId;

    @Column(name = "COURSE_NAME")
    private String courseName;

    @Column(name = "DURATION_IN_MONTH")
    private int durationInMonth;

    @Column(name = "COURSE_DESCRIPTION")
    private String courseDescription;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Set<Module> module;

}
