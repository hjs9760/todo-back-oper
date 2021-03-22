package com.js.ms.todo.domain.category.presentation.dto;

import com.js.ms.todo.domain.category.domain.Category;
import com.js.ms.todo.domain.category.domain.Status;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class CategoryInfo {

    private Long id;

    private String name;

    private Status status;

    private LocalDate startDate;

    private LocalDate endDate;

    public static CategoryInfo convertFrom(Category category) {
        CategoryInfo categoryInfo = new CategoryInfo();

        categoryInfo.id = category.getId();
        categoryInfo.name = category.getName();
        categoryInfo.status = category.getStatus();
        categoryInfo.startDate = category.getStartDate();
        categoryInfo.endDate = category.getEndDate();

        return categoryInfo;
    }
}
