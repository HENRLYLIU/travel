package com.GTMStudio.test;

import com.GTMStudio.dao.ItemsDao;
import com.GTMStudio.dao.impl.ItemsDaoImpl;
import com.GTMStudio.domain.Items;
import org.junit.Test;

import java.util.List;

public class ItemsTest {
    @Test
    public void findAll() throws ClassNotFoundException {
        ItemsDao itemsDao=new ItemsDaoImpl();
        List<Items> list = itemsDao.findAll();
        for(Items items:list){
            System.out.println(items.getName());
        }
    }
}
