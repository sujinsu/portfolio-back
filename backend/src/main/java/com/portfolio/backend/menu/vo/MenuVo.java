package com.portfolio.backend.menu.vo;

import com.portfolio.backend.menu.domain.Menu;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MenuVo {

        private Integer id;
        private Integer parentId;
        private Integer level;
        private Integer sortOrder;
        private String name;
        private String url;
        private String description;
        private Boolean useYn;

    public static MenuVo fromEntity(Menu menu) {
        return new MenuVo(
                menu.getId(),
                menu.getParentId(),
                menu.getLevel(),
                menu.getSortOrder(),
                menu.getName(),
                menu.getUrl(),
                menu.getDescription(),
                menu.getUseYn()
        );
    }
}
