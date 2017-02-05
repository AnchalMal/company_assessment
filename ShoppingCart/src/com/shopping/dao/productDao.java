package com.shopping.dao;

/**
 * Created by anchalmal on 2/2/17.
 */
        import java.io.File;
        import java.io.FileNotFoundException;
        import java.io.IOException;
        import java.sql.SQLException;

        import com.shopping.domain.Order;

public interface productDao {

    public void productcreate(File prod2) throws FileNotFoundException, IOException, SQLException;
    public void productdelete(int id) throws SQLException;
    public void productupdate(int id, String name, String code, double price, int stock1) throws SQLException;

    public Order productbyid(int id) throws SQLException;

}
