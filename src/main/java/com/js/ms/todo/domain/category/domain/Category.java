package com.js.ms.todo.domain.category.domain;

import com.js.ms.todo.domain.category.presentation.dto.CategoryUpdateForm;
import com.js.ms.todo.domain.member.domain.Member;
import com.js.ms.todo.domain.member.domain.MemberCategory;
import com.js.ms.todo.domain.section.domain.Section;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    @OneToMany(mappedBy = "category", cascade = CascadeType.PERSIST, orphanRemoval = true)
    @Builder.Default private List<MemberCategory> memberCategories = new ArrayList<>();

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Section> sections = new ArrayList<>();

    @Column
    private String name;

    @Enumerated(EnumType.STRING)
    @Column
    private Status status;

    @Column
    private LocalDate startDate;

    @Column
    private LocalDate endDate;

    public void addMemberCategoryInfo(Member member) {
        MemberCategory memberCategory = MemberCategory.createMemberCategory(this, member);

        this.memberCategories.add(memberCategory);
    }

    public void update(CategoryUpdateForm dto) {
        this.name = dto.getName();
        this.status = dto.getStatus();
        this.startDate = dto.getStartDate();
        this.endDate = dto.getEndDate();
    }
}
