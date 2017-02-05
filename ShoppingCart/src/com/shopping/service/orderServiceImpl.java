package com.shopping.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import com.shopping.dao.orderDao;
import com.shopping.dao.orderDaoImpl;

import java.util.*;

/**
 * Created by anchalmal on 2/1/17.
 */
public class orderServiceImpl implements orderService {
    static orderDao orderDao;

    static {
        orderDao = new orderDaoImpl();
    }

    @Override
    public void createorder(File ordr1) throws FileNotFoundException, IOException, SQLException {
        orderDao.createorder(ordr1);
    }

    @Override
    public void deleteorder(int id) throws SQLException {
        orderDao.deleteorder(id);

    }

    @Override
    public void updateorder(int id, java.sql.Date orderdate, double amount, String userid) throws SQLException {
        orderDao.updateorder(id, orderdate, amount, userid);

    }
}




