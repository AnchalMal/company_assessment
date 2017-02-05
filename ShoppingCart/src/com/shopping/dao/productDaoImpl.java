package com.shopping.dao;

/**
 * Created by anchalmal on 2/2/17.
 */

import com.shopping.domain.Utils.DBConnection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.shopping.domain.User;
import com.shopping.domain.Order;


    public class productDaoImpl implements productDao {
        Connection con = DBConnection.getConnection();

        @Override
        public void productcreate(File prod1) throws FileNotFoundException, IOException, SQLException {

            String insertqry = "insert into product_details (p_name, p_code, p_price, stock ) values (?,?,?,?)";

            File userread = prod1;
            FileReader fr = new FileReader(userread);
            BufferedReader br = new BufferedReader(fr);

            String s;
            int i=0;
            String[] str = new String[3];

            while ((s = br.readLine()) != null) {
                str[i]=s;
                i++;
            }

            for (String string:str) {
                String[] s2 = string.split(",");

                PreparedStatement ps = con.prepareStatement(insertqry);
                ps.setString(1, s2[0]);
                ps.setString(2, s2[1]);
                ps.setString(3, s2[2]);
                ps.setString(4, s2[3]);
                ps.executeUpdate();
                ps.close();

            }
            System.out.println("User insertion");
            System.out.println();
        }

        /*@Override
        public void productcreate(File prod2) throws FileNotFoundException, IOException, SQLException {

        }*/

        @Override
        public void productdelete(int id) throws SQLException {
            String deleteqry = "delete from product_details where id = ?";

            PreparedStatement ps = con.prepareStatement(deleteqry);
            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println();
            System.out.println("Deleted product " +id+ " from product_details");
            System.out.println();
            ps.close();


        }

        @Override
        public void productupdate(int id, String name, String code, double price, int stock1) throws SQLException {
            String updateqry = "update product_details set p_name=?, p_code=?, p_price=?, stock=? where id = ?";

            PreparedStatement ps = con.prepareStatement(updateqry);
            ps.setString(1,name);
            ps.setString(2,code);
            ps.setDouble(3,price);
            ps.setInt(4,stock1);
            ps.setInt(5,id);
            ps.executeUpdate();

            System.out.println("Updated user " +id+ " successfull");
            System.out.println();
            ps.close();


        }

        /*@Override
        public List<Order> productall() throws SQLException {
            return null;
        }*/

        @Override
        public Order productbyid(int id) throws SQLException {
            return null;
        }
    }


