package com.shopping.dao;


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
        import java.util.*;

        import com.shopping.domain.User;


/**
 * Created by anchalmal on 3/2/17.
 */
public class userDaoImpl implements userDao {

    Connection con = DBConnection.getConnection();

    @Override
    public void createuser(File user2) throws FileNotFoundException, IOException, SQLException {

        String insertqry = "insert into user (user_name, first_name, last_name, address) values (?,?,?,?)";

        File userread = user2;
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
            ps.setString(4, s2[3]);
            ps.executeUpdate();
            ps.close();

        }
        System.out.println("User insertion");
        System.out.println();
    }

    @Override
    public void deleteuser(int id) throws SQLException {

        String deleteqry = "delete from user where id = ?";

        PreparedStatement ps = con.prepareStatement(deleteqry);
        ps.setInt(1, id);
        ps.executeUpdate();

        System.out.println();
        System.out.println("Deleted user " + id + " from user");
        System.out.println();
        ps.close();

    }

    @Override
    public void updateuser(int uid2, String username, String firstname, String lastname, String address) throws SQLException {

        String updateqry = "update user set user_name=?, first_name=?, last_name=?, address=? where id = ?";

        PreparedStatement ps = con.prepareStatement(updateqry);
        ps.setString(1, username);
        ps.setString(2, firstname);
        ps.setString(3, lastname);
        ps.setString(4, address);
        ps.setInt(5, uid2);
        ps.executeUpdate();

        System.out.println("Updated user " + uid2 + " successfull");
        System.out.println();
        ps.close();

    }

    /*@Override
    public void displayuser() throws SQLException {

        Statement stmt = null;
        String disp = "select * from user ";
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(disp);

        System.out.println("Display all the user table");

        while (rs.next()) {
            int id = rs.getInt(1);
            String username = rs.getString(2);
            String firstname = rs.getString(3);
            String lastname = rs.getString(4);
            String add = rs.getString(5);

            System.out.println();
            System.out.println("User Id: " +id+ "\tUser Name: " +username+ "\tFirst Name: fn" +firstname+ "\tLast Name: " +lastname+ "\tAddress: " +add);

        }
        rs.close();
        stmt.close();*/

        @Override
        public List<User> displayuser() {

            //Properties props = new Properties();
            User user;
            List<User> userlist = new ArrayList<>();
            try {
                Connection conn = DBConnection.getConnection();
                Statement st = conn.createStatement();


                st.executeQuery("select * from user");
                ResultSet rs = st.getResultSet();

                while (rs.next()) {

                    user = new User();
                    user.setId(rs.getInt("id"));
                    user.setFirstName(rs.getString("first_name"));
                    user.setUserName(rs.getString("user_name"));
                    user.setLastName(rs.getString("last_name"));
                    user.setAddress(rs.getString("address"));
                    userlist.add(user);
                }
            } catch(Exception e)
            {
                //System.out.println("exception caught");
            }

            return(userlist);
        }
    }




