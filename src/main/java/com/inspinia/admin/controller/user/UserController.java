package com.inspinia.admin.controller.user;


import com.github.pagehelper.PageHelper;
import com.inspinia.admin.controller.common.BaseController;
import com.inspinia.admin.domain.page.TableDataInfo;
import com.inspinia.admin.domain.user.User;
import com.inspinia.admin.service.user.IUserService;
import com.inspinia.admin.utils.AjaxResult;
import com.inspinia.admin.utils.PageTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private IUserService userService;


    /**
     * 进入页面
     */
    @GetMapping()
    public String user(Model mmap, HttpServletRequest request, @RequestParam(value = "page", defaultValue = "1") int page) {
        PageHelper.startPage(page, 5);
        PageHelper.orderBy("create_time desc");
        List<User> list = userService.selectUserList();
        mmap.addAttribute("list", list);
        mmap.addAttribute("page", PageTool.getInstance().setData(list, request).render());
        return "user/user";
    }

    /**
     * 返回用户数据
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list() {
        //使用PageHelper实现分页
        startPage();
        List<User> list = userService.selectUserList();
        return getDataTable(list);
    }

    /**
     * 进入新增页面
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        return "user/add";
    }

    /**
     * 新增用户
     */
    @PostMapping("/add")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public AjaxResult addSave(User user) {
        return toAjax(userService.insertUser(user));
    }

    /**
     * 进入修改页面
     */
    @GetMapping("/edit/{userId}")
    public String edit(@PathVariable("userId") Long userId, ModelMap mmap) {
        mmap.put("user", userService.selectUserById(userId));
        return "user/edit";
    }
    /**
     * 校验手机号码
     */
    @PostMapping("/checkPhoneUnique")
    @ResponseBody
    public String checkPhoneUnique(User user) {
        return userService.checkPhoneUnique(user);
    }

    /**
     * 修改用户
     */
    @PutMapping("/edit")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public AjaxResult editSave(User user) {
        return toAjax(userService.updateUser(user));
    }

    /**
     * 删除用户
     */
    @DeleteMapping("/remove/{userId}")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public AjaxResult remove(@PathVariable("userId") Long userId) {
        if (userId != 0) {
            System.out.println("userId"+userId);
            userService.deleteUser(userId);
        }
        return toAjax(1);
    }

    /**
     * 通过用户id批量删除用户
     */
    @DeleteMapping("/remove")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public AjaxResult remove(String ids) {
        try {
            return toAjax(userService.deleteUserByIds(ids));
        } catch (Exception e) {
            return error(e.getMessage());
        }
    }


}
