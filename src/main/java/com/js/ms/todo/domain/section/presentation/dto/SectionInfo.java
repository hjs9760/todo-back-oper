package com.js.ms.todo.domain.section.presentation.dto;

import com.js.ms.todo.domain.section.domain.Section;
import lombok.Getter;

@Getter
public class SectionInfo {

    private Long sectionId;
    private String name;

    public static SectionInfo convertFrom(Section section) {
        SectionInfo sectionInfo = new SectionInfo();

        sectionInfo.sectionId = section.getId();
        sectionInfo.name = section.getName();

        return sectionInfo;
    }
}
