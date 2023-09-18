package com.sa.socialcoding.sms.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="file")
public class File {
    @Id
    @Column(name = "FILE_ID")
    private int id;

    @Column(name = "FILE_NAME")
    private String name;

    @Column(name = "FILE_TYPE")
    private String type;

    @Lob
    @Column(name = "DATA")
    private byte[] data;
}
