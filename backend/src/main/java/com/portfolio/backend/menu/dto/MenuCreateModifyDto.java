package com.portfolio.backend.menu.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MenuCreateModifyDto {

        private Integer parentId;
        private Integer level;
        private Integer sortOrder;
        private String name;
        private String url;
        private String description;
        private Boolean useYn;
}
