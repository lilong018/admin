package com.inspinia.admin.service.user;

import com.inspinia.admin.domain.user.User;
import com.inspinia.admin.mapper.user.UserMapper;
import com.inspinia.admin.utils.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectUserList() {
        return userMapper.selectUserList();
    }

    @Override
    public int insertUser(User user) {
        int rows = userMapper.insertUser(user);
        return rows;
    }

   @Override
    public User selectUserById(Long userId) {
        return userMapper.selectUserById(userId);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int deleteUser(Long userId) {
        return userMapper.deleteUser(userId);
    }


    @Override
    public int deleteUserByIds(String ids) throws Exception {
        Long[] userIds = Convert.toLongArray(ids);
        return userMapper.deleteUserByIds(userIds);
    }
}
