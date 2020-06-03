package com.baizhi.entity;

//学生标签实体对象--->t_student_tag表

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class StudentTag {
    private String id;
    private String studentid;
    private String tagid;
}
