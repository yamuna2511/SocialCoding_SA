package com.sa.socialcoding.sms.dto;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ModuleDTO {
    private int moduleId;
    private String moduleName;
    private String moduleDescription;
}
