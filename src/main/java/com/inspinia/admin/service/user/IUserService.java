package com.inspinia.admin.service.user;


import com.inspinia.admin.domain.user.User;

import java.util.List;

public interface IUserService {
    public List<User> selectUserList();

    public int insertUser(User user);

    public User selectUserById(Long userId);

    public int updateUser(User user);

    public int deleteUser(Long userId);

    public int deleteUserByIds(String ids) throws Exception;

}
