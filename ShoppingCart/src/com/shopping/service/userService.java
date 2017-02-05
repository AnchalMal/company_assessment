package com.shopping.service;
import com.shopping.domain.User;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by anchalmal on 2/2/17.
 */
public interface userService {
    public void createuser(File user1) throws FileNotFoundException, IOException, SQLException;
    public void deleteuser(int id) throws SQLException;
    public void updateuser(int id, String username, String firstname, String lastname, String address) throws SQLException;
    public List<User> displayuser(int id) throws SQLException;
    //public void displayuser(int id) throws SQLException;


}
