package com.portfolio.backend.menu.Controller;

import com.portfolio.backend.common.vo.ResultVo;
import com.portfolio.backend.menu.domain.Menu;
import com.portfolio.backend.menu.dto.MenuCreateModifyDto;
import com.portfolio.backend.menu.sevrice.MenuService;
import com.portfolio.backend.menu.vo.MenuVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/menu")
@RequiredArgsConstructor
@Tag(name = "Menu", description = "메뉴 관리 API")
@RestController
public class MenuController {

    private final MenuService menuService;

    @Operation(summary = "메뉴 목록 조회", description = "메뉴 정보 목록을 조회합니다.")
    @GetMapping
    public ResultVo getMenus() {
        return new ResultVo(menuService.getAllMenus());
    }

    @Operation(summary = "메뉴 상세 조회", description = "메뉴 ID로 단건 메뉴 정보를 조회합니다.")
    @GetMapping("/{id}")
    public ResultVo getMenu(@PathVariable Integer id) {
        return new ResultVo(menuService.getMenu(id));
    }

    @Operation(summary = "메뉴 수정", description = "메뉴 ID로 단건 메뉴 정보를 수정합니다.")
    @PutMapping("/{id}")
    public ResultVo updateMenu(
            @PathVariable Integer id,
            @RequestBody MenuCreateModifyDto dto
    ) {
        return new ResultVo(menuService.updateMenu(id, dto));
    }
    @Operation(summary = "메뉴 등록", description = "단건 메뉴 정보를 등록합니다.")
    @PostMapping
    public ResultVo createMenu(
            @RequestBody MenuCreateModifyDto dto
    ) {
        return new ResultVo(menuService.createMenu(dto));
    }

    @Operation(summary = "메뉴 삭제", description = "메뉴 ID로 단건 메뉴 정보를 삭제합니다.")
    @DeleteMapping("/{id}")
    public void deleteMenu(@PathVariable Integer id) {
        menuService.deleteMenu(id);
    }
}
