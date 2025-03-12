package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.demo.model.Product;

@Repository("productDao")
public class ProductDao  implements IProduct 
{
    //get the connection object
	private Connection con ;
	//get resultSet object for data retrieve 
	private ResultSet resultSet ;
	//get product data and store in product object
	private Product product;
	
	public ProductDao(DataSource dataSource) throws SQLException
	{
		this.con = dataSource.getConnection();
	}
	
	
	
	@Override
	public void addProducts(Product product)
	{
		try (PreparedStatement prepareStatement = con.prepareStatement("INSERT INTO PRODUCT_INFO VALUES(?,?,?,?)")) 
		{
			 prepareStatement.setInt(1, product.getProductId());
			 prepareStatement.setString(2, product.getProductName());
			 prepareStatement.setDouble(3, product.getProductPrice());
			 prepareStatement.setInt(4, product.getProductQuantity());
			 
			 int i = prepareStatement.executeUpdate();

			 if(i<=0)
			 {
				 throw new IllegalArgumentException("Data base cannt access your data");
			 }
			 else
			 {
				 System.out.println("Data sucessfully saved in database");
			 }
			 
		} catch (SQLException e) {
			
			e.printStackTrace();
		} 
	}

	@Override
	public List<Product> getAllProducts() {
	
		List<Product>  list  = new ArrayList<>();
		try (Statement createStatement = con.createStatement())
		{
			 resultSet = createStatement.executeQuery("SELECT * FROM PRODUCT_INFO");
			 
			 while(resultSet.next())
			 {
				  product = Product.builder().productId(resultSet.getInt(1)).productName(resultSet.getString(2)).productPrice(resultSet.getDouble(3)).productQuantity(resultSet.getInt(4)).build();
			    
				  list.add(product);
			 
			 }
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Product getProductById(Integer productId)
	{
		
		try (PreparedStatement prepareStatement = con.prepareStatement("SELECT * FROM PRODUCT_INFO WHERE PRODUCT_ID=?")) {
			
			prepareStatement.setInt(1, productId);
            resultSet = prepareStatement.executeQuery();
			
         	if(resultSet.next())
         	{
         		product = Product.builder().productId(resultSet.getInt(1)).productName(resultSet.getString(2)).productPrice(resultSet.getDouble(3)).productQuantity(resultSet.getInt(4)).build();
         	}
         	else
         	{
         		throw new IllegalAccessError("Invalid ProductId  try again.");
         	}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public void updateProducts(Product product) {
	    try {
	        PreparedStatement prepareStatement = con.prepareStatement(
	            "UPDATE PRODUCT_INFO SET PRODUCT_NAME=?, PRODUCT_PRICE=?, PRODUCT_QUANTITY=? WHERE PRODUCT_ID=?"
	        );

	        // Correcting the order of setting the parameters
	        prepareStatement.setString(1, product.getProductName());
	        prepareStatement.setDouble(2, product.getProductPrice());
	        prepareStatement.setInt(3, product.getProductQuantity());
	        prepareStatement.setInt(4, product.getProductId());

	        // Execute query
	        int executeUpdate = prepareStatement.executeUpdate();

	        if (executeUpdate <= 0) {
	            throw new IllegalAccessError("Invalid ProductId try again");
	        } else {
	            System.out.println("Existing product details updated into new product details");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


	@Override
	public void deleteProductById(Integer productId)
	{
		
		try( PreparedStatement prepareStatement= con.prepareStatement("DELETE FROM PRODUCT_INFO WHERE PRODUCT_ID=?")) {
			
			
			prepareStatement.setInt(1, productId);
			int deletedRow = prepareStatement.executeUpdate();
			
			if(deletedRow <=0)
			{
				throw new IllegalAccessError("Invalid ProductId try again");
			}
			else {
				System.out.println("Product details deleted from database tabel sucessfully..");
			}
		} catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
	}

}
