package com.shopping.service;

import com.shopping.dao.orderDetailsDao;
import com.shopping.dao.orderDetailsDaoImpl;
import com.shopping.domain.OrderDetail;
import com.shopping.domain.Order;
import com.shopping.domain.Utils.DBConnection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by anchalmal on 2/2/17.
 */
public class orderDetailsServiceImpl implements orderDetailsService {
    static orderDetailsDao orderDetailsDao;

    static {
        orderDetailsDao = new orderDetailsDaoImpl();
    }

    @Override
    public void createorderdetails(File ordrd1) throws FileNotFoundException, IOException, SQLException {
        orderDetailsDao.createorderdetails(ordrd1);
    }

    @Override
    public void deleteorderdetails(int id) throws SQLException {
        orderDetailsDao.deleteorderdetails(id);

    }

    @Override
    public void updateorderdetails(int id, int userid, int productid, int quantity,double price, double amount ) throws SQLException {
        orderDetailsDao.updateorderdetails(id, userid, productid, quantity, price, amount);

    }

    /*@Override
    public List<Order> displayorderdetails(int id
    ) throws SQLException {
        List<Order> list = null;
        try {
            list = new ArrayList<>();
            list = orderDetailsDao.displayorderdetails();
            return list;
        } catch (Exception e) {
            System.out.println("Exception caught");
        }
        return list;
    }*/

}
