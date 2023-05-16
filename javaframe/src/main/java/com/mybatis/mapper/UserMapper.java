package com.mybatis.mapper;

import com.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author xjy
 * @Date 2023/5/12 10:14
 * @Version 1.0
 **/
public interface UserMapper {
    // 查看所有
    List<User> selectAll();

    //根据id查看详情
    User selectById(int id);

    //根据多条件查看详情
    List<User> selectByMultipleID(@Param("username") String userName, @Param("addr") String addr);
    List<User> selectByMultipleID(User user);
    List<User> selectByMultipleID(Map map);
    List<User> selectByMultipleIDSingle(User user);

    //增
    void add(User user);

    int update(User user);

    int delete(User user);

    int deleteByIds(@Param("ids")int[] ids);
}
