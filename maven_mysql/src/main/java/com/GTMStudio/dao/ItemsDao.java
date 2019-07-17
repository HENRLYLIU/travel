package com.GTMStudio.dao;
import com.GTMStudio.domain.Items;
import java.util.List;

public interface ItemsDao {
    public List<Items> findAll() throws ClassNotFoundException;
}
