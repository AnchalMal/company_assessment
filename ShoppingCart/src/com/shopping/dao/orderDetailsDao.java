package com.shopping.dao;

import com.shopping.domain.Order;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import com.shopping.dao.orderDetailsDao;
import com.shopping.dao.orderDetailsDaoImpl;

/**
 * Created by anchalmal on 2/2/17.
 */
public interface orderDetailsDao {
    public void createorderdetails(File ordrd1) throws FileNotFoundException, IOException, SQLException;
    public void deleteorderdetails(int id) throws SQLException;
    public void updateorderdetails(int id, int userid, int productid, int quantity, double price, double amount) throws SQLException;
    //public List<Order> displayorderdetails(int id) throws Exception;
}
