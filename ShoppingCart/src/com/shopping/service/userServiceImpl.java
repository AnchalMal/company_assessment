package com.shopping.service;

import com.shopping.domain.User;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import com.shopping.dao.userDaoImpl;
import com.shopping.dao.userDao;
/**
 * Created by anchalmal on 2/2/17.
 */
public class userServiceImpl implements userService {
    static userDao userDao;

    static {
        userDao = new userDaoImpl();
    }


    @Override
    public void createuser(File user1) throws FileNotFoundException, IOException, SQLException {
        userDao.createuser(user1);

    }

    @Override
    public void deleteuser(int id) throws SQLException {
        userDao.deleteuser(id);

    }

    @Override
    public void updateuser(int id, String username, String firstname, String lastname, String address) throws SQLException {
        userDao.updateuser(id, username, firstname, lastname, address);

    }

    /*@Override
    public List<User> displayuser(int id) throws SQLException {
        return null;
    }*/

    /*@Override
    public void displayuser(int id) throws SQLException {
        userDao.displayuser();

    }*/

    @Override
    public List<User> displayuser(int id
    ) throws SQLException {
        List<User> list = null;
        try {
            list = new ArrayList<>();
            list = userDao.displayuser();
            return list;
        } catch (Exception e) {
            System.out.println("Exception caught");
        }
        return list;
    }
}

