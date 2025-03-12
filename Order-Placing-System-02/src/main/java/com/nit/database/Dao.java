package com.nit.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.springframework.stereotype.Component;

import com.nit.sbean.Product;
import com.nit.sbean.User;

@Component("dao")
public class Dao 
{
//    @Autowired
//    private Connection con;
    
    public int  insertDataInCreditCardTable(User user,Product product)
    {
    	int k =0;
    	try {
    		Class.forName("oracle.jdbc.driver.OracleDriver");
    		 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","akib");
    		 

    		 PreparedStatement statement = con.prepareStatement("INSERT into CREDIT_CARD_DATA (USER_ID,USER_NAME,MAILID,ADDRESS,PRODUCT_ID,PRODUCT_NAME,"
    		 		+ "PRODUCT_PRICE) VALUES(?,?,?,?,?,?,?)");
    		 
    		 statement.setInt(1, user.getUserId());
    		 statement.setString(2, user.getUserName());
    		 statement.setString(3, user.getEmailId());
    		 statement.setString(4, user.getAddress());
    		 statement.setInt(5, product.getProductId());
    		 statement.setString(6, product.getProductName());
    		 statement.setDouble(7, product.getProductPrice());
    		 
    		 k =statement.executeUpdate();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	
    	return k;
    }
	
    
    public int  insertDataInCodTable(User user,Product product)
    {
    	int k =0;
    	try {
    		
    		Class.forName("oracle.jdbc.driver.OracleDriver");
   		 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","akib");
   		 
    		 
    		 PreparedStatement statement = con.prepareStatement("INSERT INTO COD_DATA (USER_ID,USER_NAME,MAILID,ADDRESS,PRODUCT_ID,PRODUCT_NAME,"
    		 		+ "PRODUCT_PRICE) VALUES(?,?,?,?,?,?,?)");
    		 
    		 statement.setInt(1, user.getUserId());
    		 statement.setString(2, user.getUserName());
    		 statement.setString(3, user.getEmailId());
    		 statement.setString(4, user.getAddress());
    		 statement.setInt(5, product.getProductId());
    		 statement.setString(6, product.getProductName());
    		 statement.setDouble(7, product.getProductPrice());
    		 
    		 k =statement.executeUpdate();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	
    	return k;
    }
}
