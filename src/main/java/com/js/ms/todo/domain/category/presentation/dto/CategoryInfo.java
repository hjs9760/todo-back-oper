package com.js.ms.todo.domain.category.presentation.dto;

import com.js.ms.todo.domain.category.domain.Category;
import com.js.ms.todo.domain.category.domain.Status;
import com.js.ms.todo.domain.section.domain.Section;
import com.js.ms.todo.domain.section.presentation.dto.SectionInfo;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
public class CategoryInfo {

    private Long id;

    private String name;

    private List<SectionInfo> sectionInfo = new ArrayList<>();

    private Status status;

    private LocalDate startDate;

    private LocalDate endDate;

    private String statusColor;

    public static CategoryInfo convertFrom(Category category) {
        CategoryInfo categoryInfo = new CategoryInfo();

        categoryInfo.id = category.getId();
        categoryInfo.name = category.getName();
        for (Section section : category.getSections()) {
            categoryInfo.sectionInfo.add(SectionInfo.convertFrom(section));
        }
        categoryInfo.status = category.getStatus();
        categoryInfo.startDate = category.getStartDate();
        categoryInfo.endDate = category.getEndDate();
        for (Status status : Status.values()) {
            if (category.getStatus().equals(status)) categoryInfo.statusColor = status.getColor();
        }

        return categoryInfo;
    }
}
