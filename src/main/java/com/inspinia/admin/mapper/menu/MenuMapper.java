package com.inspinia.admin.mapper.menu;

import com.inspinia.admin.domain.menu.Menu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuMapper {

    public List<Menu> selectAllMenus();

    public List<Menu> selectMenuList(Menu menu);

    public Menu selectMenuById(Long menuId);

    public Menu checkMenuNameUnique(@Param("name") String name, @Param("parentId") Long parentId);

    public int insertMenu(Menu menu);

    public int updateMenu(Menu menu);

    public List<Menu> selectMenuAll();

    public int selectCountMenuByParentId(Long pid);

    public int deleteMenuById(Long menuId);
}
