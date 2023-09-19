package com.sa.socialcoding.sms.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class StudentBatchId implements Serializable {
    private static final long serialVersionUID = 1L;

    private int studentBatchId;
}
