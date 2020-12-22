package com.spring.testproject.ems.employeemanagementsystem.entities.task.dto;

import com.spring.testproject.ems.employeemanagementsystem.entities.task.model.Priority;
import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class TaskDto {

    private Integer taskId;
    private String taskName;
    private Priority priority;
    private String ProjectName;
    private String employeeFullName;
}
