package com.shopping.dao;
import com.shopping.domain.User;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public interface userDao {

    public void createuser(File user2) throws FileNotFoundException, IOException, SQLException;
    public void deleteuser(int id) throws SQLException;
    public void updateuser(int id, String username, String firstname, String lastname, String address) throws SQLException;
    public List<User> displayuser() throws Exception;
    //public void displayuser() throws SQLException;

}
