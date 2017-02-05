package com.shopping.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.shopping.domain.Order;

public interface productService {

    public void productcreate(File prod1) throws FileNotFoundException, IOException, SQLException;
    public void productdelete(int id) throws SQLException;
    public void productupdate(int id, String name, String code, double price, int stock1) throws SQLException;
    //public List<Order> productall(int uid4) throws SQLException;
    public Order productbyid(int id) throws SQLException;

}
