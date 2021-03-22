package com.js.ms.todo.domain.section.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {
    List<Section> findByCategoryId(Long categoryId);

    Section findByName(String name);
}
