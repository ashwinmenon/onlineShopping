package controller;

import logic.UserDetails;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class for Servlet: LogServlet
 *
 */
 public class LogServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public LogServlet() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String log=request.getParameter("log");
		
		if(log.equalsIgnoreCase("login")){
			
		try{
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			java.sql.Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe","system","system");
			Statement st = (Statement) con.createStatement();
			ResultSet rs = st.executeQuery("select * from users where username='"
					+ username + "'");
			if (rs.next()) {
				if (rs.getString(5).equals(password)) {
					
					String role=rs.getString("role");
					Long id = rs.getLong("id");
					
					String email=rs.getString("email");
					request.getSession().setAttribute("user", new UserDetails(id,username,password,email,role));
					response.sendRedirect("index.jsp");

				} else {
					
					System.out.println( "Invalid password try again");
					response.sendRedirect("login.jsp");
				}
			}else{
			
			System.out.println( "Invalid password try again");
			response.sendRedirect("login.jsp");}
			
	  }catch(Exception e){ System.out.println( "Error!"); }
	       
	}
		if(log.equalsIgnoreCase("register"))
		{
			String username = request.getParameter("username");
			   String fname = request.getParameter("fname");
			   String lname = request.getParameter("lname");
			   String password = request.getParameter("password");
			   String email = request.getParameter("email");
			   String role = "user";
		
		try {
			   
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection cnx = (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
		    PreparedStatement pr =  (PreparedStatement) cnx.prepareStatement(
					"insert into users (id,username,fname,lname,password,email,role,status) values (user_id.nextval,?,?,?,?,?,?,default)"
					);
			
			   pr.setString(1,username);
			   pr.setString(2,fname );
			   pr.setString(3, lname);
			   pr.setString(4,password );
			   pr.setString(5,email );
			   pr.setString(6,role );
			  
			   pr.executeUpdate();
			   pr.close();
			   
			   response.sendRedirect("LogServlet?log=login&username="+username+"&password="+password);
			   
			   
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		if(log.equalsIgnoreCase("cart"))
		{
			String userid = request.getParameter("userid");
			   String prodid = request.getParameter("prodid");
			   //String prod_name=null;
			   
			   try {
				   
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
					Statement st = (Statement) con.createStatement();
					ResultSet rs =  st.executeQuery("select * from products where id="+prodid);
					if (rs.next()) {
						String prod_name=rs.getString("name");
						int qty=1;
						float price=rs.getFloat("price");
						String image=rs.getString("image");
						String description=rs.getString("description");
						System.out.println("reached");
						int type=2;
						 PreparedStatement pr =  (PreparedStatement) con.prepareStatement(
	"insert into transactions (id,idproduct,iduser,qty,type,name,description,price,image) values (tran_id.nextval,?,?,?,?,?,?,?,?)"
									);
						 pr.setString(1,prodid);
						   pr.setString(2,userid );
						   pr.setInt(3, qty);
						   pr.setInt(4,type );
						   pr.setString(5,prod_name );
						   pr.setString(6,description );
						   pr.setFloat(7,price );
						   pr.setString(8,image );
						  
						   pr.executeUpdate();
						   pr.close();
					}
			   } catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   response.sendRedirect("index.jsp");
		}
		if(log.equalsIgnoreCase("wish"))
		{
			String userid = request.getParameter("userid");
			   String prodid = request.getParameter("prodid");
			   //String prod_name=null;
			   
			   try {
				   
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
					Statement st = (Statement) con.createStatement();
					ResultSet rs =  st.executeQuery("select * from products where id="+prodid);
					if (rs.next()) {
						String prod_name=rs.getString("name");
						int qty=1;
						float price=rs.getFloat("price");
						String image=rs.getString("image");
						String description=rs.getString("description");
						System.out.println("reached");
						int type=1;
						 PreparedStatement pr =  (PreparedStatement) con.prepareStatement(
	"insert into transactions (id,idproduct,iduser,qty,type,name,description,price,image) values (tran_id.nextval,?,?,?,?,?,?,?,?)"
									);
						 pr.setString(1,prodid);
						   pr.setString(2,userid );
						   pr.setInt(3, qty);
						   pr.setInt(4,type );
						   pr.setString(5,prod_name );
						   pr.setString(6,description );
						   pr.setFloat(7,price );
						   pr.setString(8,image );
						  
						   pr.executeUpdate();
						   pr.close();
					}
			   } catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   response.sendRedirect("index.jsp");
		}
		if(log.equalsIgnoreCase("cartdelete"))
		{
			String tranid = request.getParameter("tranid");
			   
			   //String prod_name=null;
			   
			   try {
				   
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
					PreparedStatement pr =  (PreparedStatement) con.prepareStatement(
							"Delete from transactions where id="+tranid);
					pr.executeUpdate();
					   pr.close();
			   }
			   catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   response.sendRedirect("cart.jsp");
		}
		if(log.equalsIgnoreCase("wishdelete"))
		{
			String tranid = request.getParameter("tranid");
			   
			   //String prod_name=null;
			   
			   try {
				   
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
					PreparedStatement pr =  (PreparedStatement) con.prepareStatement(
							"Delete from transactions where id="+tranid);
					pr.executeUpdate();
					   pr.close();
			   }
			   catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   response.sendRedirect("wishlist.jsp");
		}
		if(log.equalsIgnoreCase("updateOrder"))
		{
			String orderid = request.getParameter("orderid");
			try {
				   
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
				PreparedStatement pr =  (PreparedStatement) con.prepareStatement(
						"Update orders set status=2 where id="+orderid);
				pr.executeUpdate();
				   pr.close();
		   }
		   catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   response.sendRedirect("transactionlist.jsp");
		}
		if(log.equalsIgnoreCase("updateuser"))
		{
			String userid = request.getParameter("userid");
			try {
				   
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
				PreparedStatement pr =  (PreparedStatement) con.prepareStatement(
						"Update users set status=0 where id="+userid);
				pr.executeUpdate();
				   pr.close();
		   }
		   catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   response.sendRedirect("userlist.jsp");
		}
		if(log.equalsIgnoreCase("insertprod"))
		{
			String name = request.getParameter("name");
			String desc = request.getParameter("desc");
			String cat = request.getParameter("cat");
			String price = request.getParameter("price");
			String image = request.getParameter("image");
			try {
				   
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
				PreparedStatement pr =  (PreparedStatement) con.prepareStatement(
						"insert into products (id,name,description,price,category,rate,image) values(prod_id.nextval,?,?,?,?,default,?)");
				pr.setString(1, name);
				pr.setString(2, desc);
				pr.setFloat(3,Float.parseFloat(price));
				pr.setString(4, cat);
				
				pr.setString(5,image);
				
				pr.executeUpdate();
				   pr.close();
		   }
		   catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   response.sendRedirect("productlist.jsp");
		}
		if(log.equalsIgnoreCase("deleteprod"))
		{
			String prodid = request.getParameter("prodid");
			
			try {
				   
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
				PreparedStatement pr =  (PreparedStatement) con.prepareStatement(
						"delete from products where id="+prodid);
				
				pr.executeUpdate();
				   pr.close();
		   }
		   catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   response.sendRedirect("productlist.jsp");
		}
		
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String log=request.getParameter("log");
		if(log.equalsIgnoreCase("checkout"))
		{
			String userid = request.getParameter("idUser");
			String orders=request.getParameter("orders");
			String total=request.getParameter("total");
			String pay=request.getParameter("optradio");
			
			   //String prod_name=null;
			System.out.println("inside post"+"\t"+userid+"\t"+orders+"\t"+total);
			   
			   try {
				   
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
					PreparedStatement pr =  (PreparedStatement) con.prepareStatement(
							"insert into orders (id,iduser,pay,orders,total,status ) values (ord_id.nextval,?,?,?,?,default)" );
					pr.setString(1, userid);
					pr.setString(2, pay);
					pr.setString(3, orders);
					pr.setString(4, total);
					
					pr.executeUpdate();
					 
					   
			   }
			   catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   //request.getRequestDispatcher("payment.jsp").forward(request, response);
			   response.sendRedirect("index.jsp");
			   
		}
		/*if(log.equalsIgnoreCase("checkout1"))
		{
			//String userid = request.getParameter("idUser");
			//String orders=request.getParameter("orders");
			String total=request.getParameter("total");
			String pay=request.getParameter("optradio");
			 try {
				   
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
					PreparedStatement pr =  (PreparedStatement) con.prepareStatement(
							"insert into orders (id,iduser,pay,orders,total,status ) values (ord_id.nextval,?,?,?,?,default)" );
					pr.setString(1, userid);
					pr.setString(2, pay);
					pr.setString(3, orders);
					pr.setString(4, total);
					
					pr.executeUpdate();
					 
					   
			   }
			   catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   response.sendRedirect("index.jsp");
		}*/
	}   	  	    
}