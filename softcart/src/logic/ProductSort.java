package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;





public class ProductSort {
	PreparedStatement pr=null;
	public  ArrayList<ProductDetails> getProduct(String pop,String cat,String price) throws ClassNotFoundException, SQLException{
		
		   ArrayList<ProductDetails> listproduct = new ArrayList<ProductDetails>();
		   
		   
			     Class.forName("oracle.jdbc.driver.OracleDriver");
			     Connection cnx = (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
				 
				if(pop==null)
				{
					if(cat==null)
					{
						if(price==null)
						{
							pr =  (PreparedStatement) cnx.prepareStatement("select * from products");
						}
						else
						{
							pr =  (PreparedStatement) cnx.prepareStatement("select * from products where price<="+price+" ORDER BY price asc ");
						}
					}
					else
					{
						if(price==null)
						{
							pr =  (PreparedStatement) cnx.prepareStatement("select * from products where category='"+cat+"' ");
						}
						else
						{
							pr =  (PreparedStatement) cnx.prepareStatement("select * from products where category='"+cat+"' and price<="+price+" ORDER BY price asc ");
						}
					}			
				}
				else
				{
					if(cat==null)
					{
						if(price==null)
						{
							pr =  (PreparedStatement) cnx.prepareStatement("select * from products ORDER BY rate desc");
						}
						else
						{
							pr =  (PreparedStatement) cnx.prepareStatement("select * from products where price<="+price+" ORDER BY price asc,rate desc ");
						}
					}
					else
					{
						if(price==null)
						{
							pr =  (PreparedStatement) cnx.prepareStatement("select * from products where category='"+cat+"' ORDER BY rate desc");
						}
						else
						{
							pr =  (PreparedStatement) cnx.prepareStatement("select * from products where category='"+cat+"' and price<="+price+" ORDER BY price asc,rate desc ");
						}
					}			
				}
			       
				  ResultSet rs = pr.executeQuery();
				  
				    while(rs.next()){
					      ProductDetails product =  new ProductDetails();
					      product.setId(rs.getLong("id"));
					      product.setName(rs.getString("name"));
					      product.setDescription(rs.getString("description"));
					      product.setPrice(rs.getFloat("price"));
					      product.setImage(rs.getString("image"));
					      
					      listproduct.add(product);
					  
				      }
		   return listproduct;
	}
	public  ArrayList<UserDetails> getUsers()throws ClassNotFoundException, SQLException{
		
		   ArrayList<UserDetails> listuser = new ArrayList<UserDetails>();
		   
		   
			     Class.forName("oracle.jdbc.driver.OracleDriver");
			     Connection cnx = (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			     pr =  (PreparedStatement) cnx.prepareStatement("select * from users");
				  ResultSet rs = pr.executeQuery();
				  
				    while(rs.next()){
					      UserDetails user =  new UserDetails();
					      user.setId(rs.getLong("id"));
					      user.setUsername(rs.getString("username"));
					      user.setFname(rs.getString("fname"));
					      user.setLname(rs.getString("lname"));
					      user.setPassword(rs.getString("password"));
					      user.setEmail(rs.getString("email"));
					      user.setRole(rs.getString("role"));
					      user.setStatus(rs.getInt("status"));
					      
					      
					     
					     
					      listuser.add(user);
					  
				      }
				    
				
			
				return listuser;
}
	public  ArrayList<TransactionDetails> getTrans(long userid,int type)throws ClassNotFoundException, SQLException{
		
		   ArrayList<TransactionDetails> listuser = new ArrayList<TransactionDetails>();
		   
		   
			     Class.forName("oracle.jdbc.driver.OracleDriver");
			     Connection cnx = (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			     pr =  (PreparedStatement) cnx.prepareStatement("select * from transactions where iduser="+userid+" and type="+type);
				  ResultSet rs = pr.executeQuery();
				  
				    while(rs.next()){
				    	TransactionDetails user =  new TransactionDetails();
					      user.setId(rs.getInt("id"));
					      user.setIdProduct(rs.getInt("idproduct"));
					      user.setIdUser(rs.getInt("iduser"));
					      user.setQty(rs.getInt("qty"));
					      user.setType(rs.getInt("type"));
					      user.setName(rs.getString("name"));
					      user.setDescription(rs.getString("description"));
					      user.setPrice(rs.getFloat("price"));
					      user.setImage(rs.getString("image"));
					      
					      
					     
					     
					      listuser.add(user);
					  
				      }
				    
				
			
				return listuser;
}
	public  ArrayList<OrderDetails> getOrders(long userid)throws ClassNotFoundException, SQLException{
		
		   ArrayList<OrderDetails> listuser = new ArrayList<OrderDetails>();
		   
		   
			     Class.forName("oracle.jdbc.driver.OracleDriver");
			     Connection cnx = (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			     if(userid==0){
			    	 pr =  (PreparedStatement) cnx.prepareStatement("select * from orders ");
			     }
			     else pr =  (PreparedStatement) cnx.prepareStatement("select * from orders where iduser="+userid);
				  ResultSet rs = pr.executeQuery();
				  
				    while(rs.next()){
				    	OrderDetails user =  new OrderDetails();
					      user.setId(rs.getInt("id"));
					      user.setIdUser(rs.getInt("iduser"));
					      user.setOrders(rs.getString("orders"));
					      user.setPayment(rs.getString("pay"));
					      user.setTotal(rs.getLong("total"));
					     user.setStatus(rs.getInt("status"));
					      
					      
					     
					     
					      listuser.add(user);
					  
				      }
				    
				
			
				return listuser;
	}
	public  ArrayList<UserDetails> getUsers(long id)throws ClassNotFoundException, SQLException{
		
		   ArrayList<UserDetails> listuser = new ArrayList<UserDetails>();
		   
		   
			     Class.forName("oracle.jdbc.driver.OracleDriver");
			     Connection cnx = (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			     pr =  (PreparedStatement) cnx.prepareStatement("select * from users where id="+id);
				  ResultSet rs = pr.executeQuery();
				  
				    while(rs.next()){
					      UserDetails user =  new UserDetails();
					      user.setId(rs.getLong("id"));
					      user.setUsername(rs.getString("username"));
					      user.setFname(rs.getString("fname"));
					      user.setLname(rs.getString("lname"));
					      user.setPassword(rs.getString("password"));
					      user.setEmail(rs.getString("email"));
					      user.setRole(rs.getString("role"));
					      user.setStatus(rs.getInt("status"));
					      
					      
					     
					      listuser.add(user);
					     
					  
				      } return listuser;
	}
	}
	


