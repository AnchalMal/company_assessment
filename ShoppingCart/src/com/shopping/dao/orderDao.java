package com.shopping.dao;

import com.shopping.domain.User;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import com.shopping.dao.orderDao;
import com.shopping.dao.orderDaoImpl;

/**
 * Created by anchalmal on 2/2/17.
 */
public interface orderDao {
    public void createorder(File ordr1) throws FileNotFoundException, IOException, SQLException;
    public void deleteorder(int id) throws SQLException;
    //public void updateorder(int uid7, Date orderdate, double amount, String userid) throws SQLException;

    public void updateorder(int uid7, java.sql.Date orderdate, double amount, String userid) throws SQLException;
}
