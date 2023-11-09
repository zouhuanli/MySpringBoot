package com.homura.myspringboot.entity.dvo;

import lombok.Data;

import java.util.Date;

@Data
public class Actor {
    private Integer actorId;
    private String firstName;
    private String lastName;
    private Date lastUpdate;
}
