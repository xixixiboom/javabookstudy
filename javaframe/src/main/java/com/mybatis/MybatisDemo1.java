package com.mybatis;

import com.mybatis.mapper.UserMapper;
import com.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName MybatisDemo1
 * @Description
 * mybatis  使用流程：
 * 1.创建实体类
 * 2.创建模块，导入坐标
 * 3.编写mybatis核心配置文件-->替换连接信息，解决编码问题
 * 4.编写sql映射文件-->统一管理sql语句，解决编码问题
 * 5.编码  1.定义pojo类
 *                2.加载核心配置文件，获取SqlSessionFactory对象
 *                3.获取SqlSession对象，执行sql语句
 *                4.释放资源
 * @Author xjy
 * @Date 2023/5/11 23:00
 * @Version 1.0
 **/

public class MybatisDemo1 {
    @Test
    //快速入门代码
    public  void  quickStart(){
        //1.加载核心配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象，用它执行sql
        SqlSession sqlSession  = sqlSessionFactory.openSession();

        //3. 执行sql
        List<User> users = sqlSession.selectList("test.selectAll");
        System.out.println(users);

        //4.释放资源
        sqlSession.close();
    }

    /**
     * @Description
     * 常用的还是代理开发，和快速入门区别在于
     * 1.resource 下的xml文件名需要与接口文件名一致且在同一目录
     * 2.创建resource 目录时   使用/代替.  不然会造成包名为xx.xx.xx   不会分层
     * 3.config.xml 中package   直接代理包下的所有xml文件
     * 4.在 Mapper接口中定义方法，方法名就是SQL映射文件中sql语句的id，并保持参数类型和返回值类型一致
     * 5.namespace 为 mapper接口路径全限定名
     * 6.使用sqlSession.getMapper();
     * @Date 2023/5/12 10:57
     **/
    @Test
    public void agentDevelopment(){
        //1.加载核心配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象，用它执行sql   参数为true时自动提交事务，否则需要sqlSession.commit();
        SqlSession sqlSession  = sqlSessionFactory.openSession(true);

        //3. 执行sql

        //3.1   select
        UserMapper users = sqlSession.getMapper(UserMapper.class);
        List<User> users1 = users.selectAll();
        // System.out.println(users1);

        //按条件查询
        int id =2;
        User usersByID = users.selectById(id);
        // System.out.println(usersByID);

        //多条件查询   方式一  param
        String userName = "%"+ "zhang" +"%";
        String addr =  "%"+ "北" +"%";
        List<User> usersByMultipleID = users.selectByMultipleID(userName, addr);
        // System.out.println(usersByMultipleID);

        //方式二  实体类
        User userInput = new User();
        userInput.setAddr(addr);
        userInput.setUsername(userName);
        usersByMultipleID = users.selectByMultipleID(userInput);
        // System.out.println(usersByMultipleID);

        //方式三 map
/*        Map<String,String> map = new HashMap<String,String>();
        // map.put("username", userName);
        map.put("addr", addr);
        usersByMultipleID = users.selectByMultipleID(map);
        // System.out.println(usersByMultipleID);*/

        // 下拉框
        List<User> usersByMultipleIDSingle = users.selectByMultipleIDSingle(userInput);
        // System.out.println(usersByMultipleIDSingle);

        //3.2 add   注意 sqlSessionFactory.openSession()中默认为false，需手动提交事务，否则事务回滚，可以传参为true则自动提交
        //主键返回
/*
        users.add(userInput);
        Integer id1 = userInput.getId();
        System.out.println(id1);
        sqlSession.commit();
*/

        //3.3 update
/*        int idUpdate = 5;
        userInput.setPassword("111");
        userInput.setId(idUpdate);
        int update = users.update(userInput);
        System.out.println(update);*/

        //3.4 delete
        /*int delete = users.delete(userInput);
        System.out.println(delete);*/

        int[] ids = {5,6};
        int delete = users.deleteByIds(ids);
        //4.释放资源
        sqlSession.close();
    }

}
