package com.js.ms.todo.domain.todo.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    Todo findByName(String name);

     List<Todo> findBySectionId(Long sectionId);

    List<Todo> findBySectionIdAndStatusAndEndDateBetween(Long id, Status status, LocalDateTime startDate, LocalDateTime endDate);

    List<Todo> findBySectionIdAndEndDateBetween(Long id, LocalDateTime startDate, LocalDateTime endDate);

    List<Todo> findBySectionIdAndStatus(Long id, Status status);
}
