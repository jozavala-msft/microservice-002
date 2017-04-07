package com.unrealord.models;

import lombok.Builder;
import lombok.Data;

@Builder(toBuilder = true)
@Data
public class Todo {

    public String uuid;
    public String name;
    public String description;
}
