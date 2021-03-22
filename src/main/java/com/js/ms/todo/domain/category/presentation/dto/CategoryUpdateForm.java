package com.js.ms.todo.domain.category.presentation.dto;

import com.js.ms.todo.domain.category.domain.Status;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
public class CategoryUpdateForm {

    @NotNull
    private Long categoryId;

    @NotBlank
    @Length(min = 1, max = 30)
    private String name;

    @NotNull
    private Status status;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

//    private List<MemberCategoryUpdateForm> memberCategoryUpdateForms;

}
