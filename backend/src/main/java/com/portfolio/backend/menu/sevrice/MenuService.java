package com.portfolio.backend.menu.sevrice;

import com.portfolio.backend.menu.domain.Menu;
import com.portfolio.backend.menu.dto.MenuCreateModifyDto;
import com.portfolio.backend.menu.repository.MenuRepository;
import com.portfolio.backend.menu.vo.MenuVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;

    public List<MenuVo> getAllMenus() {
        return menuRepository.findAllByOrderBySortOrderAsc().stream()
                .map(MenuVo::fromEntity)
                .collect(Collectors.toList());
    }

    public MenuVo getMenu(Integer id) {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("메뉴 없음"));
        return MenuVo.fromEntity(menu);
    }
    public MenuVo createMenu(MenuCreateModifyDto dto) {
        Menu menu = new Menu();
        menu.setParentId(dto.getParentId());
        menu.setLevel(dto.getLevel());
        menu.setSortOrder(dto.getSortOrder());
        menu.setName(dto.getName());
        menu.setUrl(dto.getUrl());
        menu.setDescription(dto.getDescription());
        menu.setUseYn(dto.getUseYn());

        return MenuVo.fromEntity(menuRepository.save(menu));
    }

    public MenuVo updateMenu(Integer id, MenuCreateModifyDto dto) {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("메뉴 없음"));

        menu.setParentId(dto.getParentId());
        menu.setLevel(dto.getLevel());
        menu.setSortOrder(dto.getSortOrder());
        menu.setName(dto.getName());
        menu.setUrl(dto.getUrl());
        menu.setDescription(dto.getDescription());
        menu.setUseYn(dto.getUseYn());

        return MenuVo.fromEntity(menuRepository.save(menu));
    }

    public void deleteMenu(Integer id) {
        menuRepository.deleteById(id);
    }
}
