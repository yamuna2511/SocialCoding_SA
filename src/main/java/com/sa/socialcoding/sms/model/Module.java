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
@Table(name="MODULE")
public class Module
{
    @Id
    @GeneratedValue
    @Column(name = "MODULE_ID")
    private int moduleId;

    @Column(name = "MODULE_NAME")
    private String moduleName;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "COURSE_ID", nullable=false)
    private Course course;

    @Column(name = "MODULE_DESCRIPTION")
    private String moduleDescription;

    @OneToMany(mappedBy = "module", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Set<Topic> topic;
}
