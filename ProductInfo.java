package productdetails;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProductInfo")
public class ProductInfo extends HttpServlet {
private static final long serialVersionUID = 1L;
    
    public ProductInfo() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PreparedStatement p = null;
	        ResultSet rs = null;
	        PrintWriter out=response.getWriter();
	        try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				
				e1.printStackTrace();
			}
	        
            Connection co1 = null;
			try {
				co1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/productinfo","root", "Narendiran@2000");
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
	        try {
	 
	            String sql = "SELECT * FROM productinfo.eproduct";
	            p = co1.prepareStatement(sql);
	            rs = p.executeQuery();
	            out.println("ID\t\tProduct name\t");
	            while (rs.next()) {
	 
	                int id = rs.getInt("ID");String name = rs.getString("prname");
	                out.println(id + "\t\t" +name+ "\t\t" );
	            }
	        }
	 
	       
	        catch (SQLException e) {
	 
	            
	            out.println(e);
	        }
	    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}


}