

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dao.bean.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginCheck
 */
@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginCheck() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public static Connection getConnection() {
 		Connection con = null;
 		try {
 			Class.forName("com.mysql.jdbc.Driver");
 			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nrpprofile", "root", "hao123");
 		}catch (Exception e) {
 			System.out.println(e);
 		}
 		return con;
 	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String email = request.getParameter("email");
	     String password = request.getParameter("password");
	     
		 try {
				Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement("select password from profile_table where email = ?");
				ps.setString(1, email);
				ResultSet rs = ps.executeQuery();
				

				while(rs.next()) {
					String correctPassword = rs.getPassword("password");
				}
			}catch (Exception e) {
	 			System.out.println(e);
	 		}
		 
		 
	     if(email.equals("email") && password.equals(correctPassword)) {
	    	 response.sendRedirect("member.jsp");
	     }else {
	    	 response.sendRedirect("error.jsp");
	     }
	}

}
