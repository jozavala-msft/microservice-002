package com.unrealord.repositories;

import com.unrealord.models.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {

    Todo findByUuid(String uuid);

}
