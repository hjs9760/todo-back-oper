package com.js.ms.todo.domain.todo.domain;

import com.js.ms.todo.domain.section.domain.Section;
import lombok.*;

import javax.persistence.*;
import java.io.File;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "section_id")
    private Section section;

    @Column
    private String name;

    @Column
    private String content;

    @Column
    private List<File> fileList;

    @Column
    private LocalDateTime startDate;

    @Column
    private LocalDateTime endDate;

}
