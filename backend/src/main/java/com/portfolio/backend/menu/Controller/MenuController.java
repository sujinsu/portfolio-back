package com.portfolio.backend.menu.Controller;

import com.portfolio.backend.menu.domain.Menu;
import com.portfolio.backend.menu.dto.MenuCreateModifyDto;
import com.portfolio.backend.menu.sevrice.MenuService;
import com.portfolio.backend.menu.vo.MenuVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/menu")
@RequiredArgsConstructor
@Controller
public class MenuController {

    private final MenuService menuService;

    @GetMapping
    public List<Menu> getMenus() {
        return menuService.getAllMenus();
    }

    @GetMapping("/{id}")
    public Menu getMenu(@PathVariable Integer id) {
        return menuService.getMenu(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MenuVo> updateMenu(
            @PathVariable Integer id,
            @RequestBody MenuCreateModifyDto dto
    ) {
        return ResponseEntity.ok(menuService.updateMenu(id, dto));
    }

    @PostMapping
    public ResponseEntity<MenuVo> createMenu(
            @RequestBody MenuCreateModifyDto dto
    ) {
        return ResponseEntity.ok(menuService.createMenu(dto));
    }

    @DeleteMapping("/{id}")
    public void deleteMenu(@PathVariable Long id) {
        menuService.deleteMenu(id);
    }
}
