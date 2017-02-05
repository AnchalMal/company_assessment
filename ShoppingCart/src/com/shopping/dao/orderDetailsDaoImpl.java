package com.shopping.dao;

import com.shopping.domain.Utils.DBConnection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by anchalmal on 2/2/17.
 */
public class orderDetailsDaoImpl implements orderDetailsDao {
    Connection con = DBConnection.getConnection();

    @Override
    public void createorderdetails(File ordrd1) throws FileNotFoundException, IOException, SQLException {

        String insertqry = "insert into order_details (order_id, product_id, quantity, price ) values (?,?,?,?)";

        File userread = ordrd1;
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
            ps.setInt(1, Integer.parseInt(s2[0]));
            ps.setInt(2, Integer.parseInt(s2[1]));
            ps.setInt(3, Integer.parseInt(s2[2]));
            ps.setInt(4, Integer.parseInt(s2[3]));
            ps.executeUpdate();
            ps.close();

        }
        System.out.println("orderdetails insertion");
        System.out.println();
    }

    @Override
    public void deleteorderdetails(int id) throws SQLException {

        String deleteqry = "delete from order_details where id = ?";

        PreparedStatement ps = con.prepareStatement(deleteqry);
        ps.setInt(1, id);
        ps.executeUpdate();

        System.out.println();
        System.out.println("Deleted order " + id + " from order_details");
        System.out.println();
        ps.close();

    }

    @Override
    public void updateorderdetails(int id, int userid, int productid, int quantity, double price, double amount) throws SQLException {
        String updateqry = "update order_details set user_id=?, product_id=?, quantity=? , price=? where id = ?";

        PreparedStatement ps = con.prepareStatement(updateqry);
        ps.setInt(1, userid);
        ps.setInt(2, productid);
        ps.setInt(3, quantity);
        ps.setDouble(4, price);
        ps.setInt(5, id);
        ps.executeUpdate();

        System.out.println("Updated user " + id + " successfull");
        System.out.println();
        ps.close();

    }
}


