package com.js.ms.todo.domain.section.domain;

import com.js.ms.todo.domain.category.domain.Category;
import com.js.ms.todo.domain.section.presentation.dto.SectionUpdateForm;
import com.js.ms.todo.domain.todo.domain.Todo;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "section_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "section")
    @Builder.Default private List<Todo> todoList = new ArrayList<>();

    @Column
    private String name;

    public void update(SectionUpdateForm dto) {
        this.name = dto.getName();
    }
}
