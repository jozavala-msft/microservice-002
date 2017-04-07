package com.unrealord.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data(staticConstructor = "of")
public class Todo {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String uuid;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;

    public Todo() {}

}
