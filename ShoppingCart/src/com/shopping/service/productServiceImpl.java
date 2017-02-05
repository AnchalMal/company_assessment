package com.shopping.service;

import com.shopping.dao.productDao;
import com.shopping.dao.productDaoImpl;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.shopping.domain.Order;

public class productServiceImpl implements productService {

    static productDao productDao;
    static {
        productDao= new productDaoImpl();
    }
    @Override
    public void productcreate(File prod1) throws FileNotFoundException, IOException, SQLException {
        productDao.productcreate(prod1);

    }

    @Override
    public void productdelete(int id) throws SQLException {
        productDao.productdelete(id);

    }

    @Override
    public void productupdate(int id, String name, String code, double price, int stock1) throws SQLException {
        productDao.productupdate(id, name, code,price, stock1);


    }

   /* @Override
    public List<Order> productall(int uid4) throws SQLException {
        return null;
    }*/

    @Override
    public Order productbyid(int id) throws SQLException {
        return null;
    }
}
