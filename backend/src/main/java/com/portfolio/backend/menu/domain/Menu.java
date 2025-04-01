package com.portfolio.backend.menu.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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