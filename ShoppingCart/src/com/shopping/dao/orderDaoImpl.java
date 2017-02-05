package com.shopping.dao;

import com.shopping.domain.Utils.DBConnection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.*;
import com.shopping.dao.orderDao;
import com.shopping.dao.orderDaoImpl;

//import java.util.Date;


/**
 * Created by anchalmal on 2/2/17.
 */

    public class orderDaoImpl implements orderDao {

    Connection con = DBConnection.getConnection();

    @Override
    public void createorder(File ordr1) throws FileNotFoundException, IOException, SQLException {

        String insertqry = "insert into order1 (order_date, amount, user_id) values (?,?,?)";

        File userread = ordr1;
        FileReader fr = new FileReader(userread);
        BufferedReader br = new BufferedReader(fr);

        String s;
        int i = 0;
        String[] str = new String[3];

        while ((s = br.readLine()) != null) {
            str[i] = s;
            i++;
        }

        for (String string : str) {
            String[] s2 = string.split(",");
            PreparedStatement ps = con.prepareStatement(insertqry);
            ps.setString(1, s2[0]);
            ps.setString(2, s2[1]);
            ps.setString(3, s2[2]);
            //ps.setString(4, s2[3]);
            ps.executeUpdate();
            ps.close();

        }
        System.out.println("User insertion");
        System.out.println();
    }

    @Override
    public void deleteorder(int id) throws SQLException {

        String deleteqry = "delete from order1 where id = ?";

        PreparedStatement ps = con.prepareStatement(deleteqry);
        ps.setInt(1, id);
        ps.executeUpdate();

        System.out.println();
        System.out.println("Deleted order " + id + " from order1");
        System.out.println();
        ps.close();

    }

    @Override
    public void updateorder(int uid7, java.sql.Date orderdate, double amount, String userid) throws SQLException {
        String updateqry = "update order1 set order_date=?, amount=?, user_id=? where id = ?";

        PreparedStatement ps = con.prepareStatement(updateqry);
        //java.sql.Date sqldate = java.sql.Date.valueOf( );
        ps.setDate(1, orderdate);
        ps.setDouble(2, amount);
        ps.setString(3, userid);

        ps.setInt(5, uid7);
        ps.executeUpdate();

        System.out.println("Updated order " + uid7 + " successfull");
        System.out.println();
        ps.close();

    }
    }









