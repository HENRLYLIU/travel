package com.GTMStudio.dao.impl;

import com.GTMStudio.dao.ItemsDao;
import com.GTMStudio.domain.Items;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ItemsDaoImpl implements ItemsDao {

    public List<Items> findAll(){


        List<Items> list=new ArrayList<Items>();
        Connection connection=null;
        PreparedStatement psp=null;
        ResultSet resultSet=null;

        try {
            //1.加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获取connection对象
             connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/maven?serverTimezone=UTC",
                    "root", "123456");
            //3.获取真正操作数据的对象
             psp= connection.prepareStatement("select * from items");
            //4.执行数据库操作
            resultSet = psp.executeQuery();
            //5.处理结果集
            while (resultSet.next()) {
                Items items = new Items();
                items.setId(resultSet.getInt("id"));
                items.setName(resultSet.getString("name"));
                list.add(items);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }
        return list;
    }
}
