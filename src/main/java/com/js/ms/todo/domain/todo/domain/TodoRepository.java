package com.js.ms.todo.domain.todo.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    Todo findByName(String name);

     List<Todo> findBySectionId(Long sectionId);
}
