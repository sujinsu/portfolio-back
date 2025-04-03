package com.portfolio.backend.menu.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer parentId;

    private Integer level;

    private Integer sortOrder;  // 정렬 순서

    private String name;        // 메뉴명

    private String url;         // 메뉴 URL

    private String description;

    private Boolean useYn;    // 노출 여부

}