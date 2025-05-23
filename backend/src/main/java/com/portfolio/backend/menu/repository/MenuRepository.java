package com.portfolio.backend.menu.repository;

import com.portfolio.backend.menu.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Integer> {

    List<Menu> findAllByOrderBySortOrderAsc();
}
