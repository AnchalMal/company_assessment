package com.shopping.client;

import java.io.BufferedReader;
import java.io.File;
import com.shopping.service.productService;
import com.shopping.service.userService;
import com.shopping.service.userServiceImpl;
import com.shopping.service.productServiceImpl;
import com.shopping.service.orderService;
import com.shopping.service.orderServiceImpl;
import com.shopping.service.orderDetailsService;
import com.shopping.service.orderDetailsServiceImpl;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * Created by anchalmal on 2/2/17.
 */
public class shoppingClient {

    static userService userservice;
    static productService productservice;
    static orderService orderservice;
    static orderDetailsService orderdetailsservice;

    static {
        userservice = new userServiceImpl();
        productservice = new productServiceImpl();
        orderservice = new orderServiceImpl();
        orderdetailsservice = new orderDetailsServiceImpl();
    }

    public static void main(String[] args) throws IOException, SQLException {
        int uid1, uid2, uid3, uid4, uid5, uid6, uid7, uid8;
        String username, firstname, lastname, address;


        String productname, productcost, userid, date;
        int productprice, productstock;

        java.sql.Date orderdate;
        Double amount;


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        shoppingClient sc = new shoppingClient();

        File user = new File("/Users/anchalmal/Projects/AppDirect/AppDirect/ShoppingCart/src/com/shopping/data");


        sc.userservice.createuser(user);

        System.out.println("enter user id to delete");
        uid1 = Integer.parseInt(br.readLine());
        sc.userservice.deleteuser(uid1);

        System.out.println("enter user id to update");
        uid2 = Integer.parseInt(br.readLine());



        System.out.print("Enter the new user name: ");
        username = br.readLine();



        System.out.print("Enter the new first name: ");
        firstname = br.readLine();


        System.out.print("Enter the new last name: ");
        lastname = br.readLine();


        System.out.print("Enter the new address: ");
        address = br.readLine();


        sc.userservice.updateuser(uid2, username, firstname, lastname, address);

        //System.out.print("Enter new user in database ");

        //shoppingClient scp = new shoppingClient();
        File prod = new File("/Users/anchalmal/Projects/AppDirect/AppDirect/ShoppingCart/src/com/shopping/Product");
        sc.productservice.productcreate(prod);

        System.out.print("Enter the product id to delete: ");
        uid3 = Integer.parseInt(br.readLine());
        sc.productservice.productdelete(uid3);

        System.out.print("Enter the product id to update data: ");
        uid4 = Integer.parseInt(br.readLine());
        //sc.productservice.productupdate(uid4);


        System.out.print("Enter the product name: ");
        productname = br.readLine();
        //sc.productservice.productupdate(productname);


        System.out.print("Enter the product code: ");
        productcost = br.readLine();


        System.out.print("Enter the product price: ");
        productprice = Integer.parseInt(br.readLine());
        //System.out.println();

        System.out.print("Enter the product stock: ");
        productstock = Integer.parseInt(br.readLine());
        //System.out.println();
        sc.productservice.productupdate(uid4, productname, productcost, productprice, productstock);

        //sc.productservice.productall(uid4);

        System.out.println();
        System.out.print("Enter the userid to display details: ");
        uid5 = Integer.parseInt(br.readLine());

        sc.userservice.displayuser(uid5);

        //sc.productservice.productdisplay(uid4);

        File ordr1 = new File("/Users/anchalmal/Projects/AppDirect/AppDirect/ShoppingCart/src/com/shopping/order");
        sc.orderservice.createorder(ordr1);

        System.out.print("Enter the order id to delete: ");
        uid6 = Integer.parseInt(br.readLine());
        sc.orderservice.deleteorder(uid6);

        System.out.print("Enter the order id to update data: ");
        uid7 = Integer.parseInt(br.readLine());
        //sc.orderservice.updateorder(id);

        System.out.print("Enter new order date: ");
        //orderdate = br.readLine();
        //orderdate = new Date(date);
        //DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");


        System.out.print("Enter new amount: ");
        amount = Double.parseDouble(br.readLine());

        System.out.print("Enter new userid: ");
        userid = br.readLine();

        //sc.orderservice.updateorder(uid7, orderdate ,amount,userid);

        File ordrd1 = new File("/Users/anchalmal/Projects/AppDirect/AppDirect/ShoppingCart/src/com/shopping/orderDetails");
        sc.orderdetailsservice.createorderdetails(ordrd1);

        System.out.print("Enter the order id to delete: ");
        uid8 = Integer.parseInt(br.readLine());
        sc.orderservice.deleteorder(uid8);






    }
}

