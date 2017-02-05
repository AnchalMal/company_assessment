package com.shopping.service;

import com.shopping.domain.User;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by anchalmal on 2/1/17.
 */
public interface orderService {
    public void createorder(File ordr1) throws FileNotFoundException, IOException, SQLException;
    public void deleteorder(int id) throws SQLException;
    public void updateorder(int id, java.sql.Date orderdate, double amount, String userid) throws SQLException;

}
