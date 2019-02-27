package com.inspinia.admin.service.menu;

import com.inspinia.admin.domain.menu.Menu;
import com.inspinia.admin.mapper.menu.MenuMapper;
import com.inspinia.admin.utils.StringUtils;
import com.inspinia.admin.utils.TreeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MenuServiceImpl implements IMenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> selectAllMenus() {
        List<Menu> menus = menuMapper.selectAllMenus();
        return TreeUtils.getChildPerms(menus, 0);
    }

    @Override
    public List<Menu> selectMenuList(Menu menu) {
        List<Menu> menus = menuMapper.selectMenuList(menu);
        return menus;
    }

    @Override
    public Menu selectMenuById(Long menuId) {
        return menuMapper.selectMenuById(menuId);
    }

    @Override
    public String checkMenuNameUnique(Menu menu) {
        Long menuId = StringUtils.isNull(menu.getId()) ? -1L : menu.getId();
        Menu info = menuMapper.checkMenuNameUnique(menu.getName(), menu.getPid());
        if (StringUtils.isNotNull(info) && info.getId().longValue() != menuId.longValue()) {
            return "1";
        }
        return "0";
    }

    @Override
    public int insertMenu(Menu menu) {
        return menuMapper.insertMenu(menu);
    }

    @Override
    public int updateMenu(Menu menu) {
        return menuMapper.updateMenu(menu);
    }

    @Override
    public List<Map<String, Object>> menuTreeData() {
        List<Map<String, Object>> trees = new ArrayList<Map<String, Object>>();
        List<Menu> menuList = menuMapper.selectMenuAll();
        trees = getTrees(menuList, false, null, true);
        return trees;
    }

    @Override
    public int selectCountMenuByParentId(Long pid) {
        return menuMapper.selectCountMenuByParentId(pid);
    }

    @Override
    public int deleteMenuById(Long menuId) {
        return menuMapper.deleteMenuById(menuId);
    }


    private List<Map<String, Object>> getTrees(List<Menu> menuList, boolean isCheck, List<String> roleMenuList,
                                              boolean permsFlag)
    {
        List<Map<String, Object>> trees = new ArrayList<Map<String, Object>>();
        for (Menu menu : menuList)
        {
            Map<String, Object> deptMap = new HashMap<String, Object>();
            deptMap.put("id", menu.getId());
            deptMap.put("pId", menu.getPid());
            deptMap.put("name", transMenuName(menu, roleMenuList, permsFlag));
            deptMap.put("title", menu.getName());
            trees.add(deptMap);
        }
        return trees;
    }

    private String transMenuName(Menu menu, List<String> roleMenuList, boolean permsFlag)
    {
        StringBuffer sb = new StringBuffer();
        sb.append(menu.getName());
        return sb.toString();
    }
}
