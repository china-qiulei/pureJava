package com.three.stone.db.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class StudentInfo implements Serializable{

    private static final long serialVersionUID = -2985104987827595880L;
    private Integer studentId;
    private String name;
    private Integer age;
    private String email;
    private String phone;
}
