package pack;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class createnewcourse
 */
@WebServlet("/createnewcourse")
public class createnewcourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createnewcourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession s=request.getSession();
		 String netid= s.getAttribute("id").toString();
		 System.out.println("netid:"+netid);
	     String csi=request.getParameter("csi");
	     String cname=request.getParameter("cname");
	     
	     dbconnection obj=new dbconnection();
	     ResultSet rs=obj.selectdata("select course_id from course where course_name='"+ cname +"'");
	     ResultSet rs1=obj.selectdata("select course_name from course where course_csi='"+ csi +"'");
	     try {
			if(rs.next())
			 {
				while(rs1.next())
				{
				request.setAttribute("zc", "*Course already added");;
           	  	RequestDispatcher dispatch=request.getRequestDispatcher("createnewcourse.jsp");
            	dispatch.forward(request,response);
				}
			 }
			else{
				 obj.modify("insert into course(course_csi,course_name) values ('"+ csi+"','"+ cname+"')");
				 request.setAttribute("zc", "Course added");;
	           	  	RequestDispatcher dispatch=request.getRequestDispatcher("createnewcourse.jsp");
	            	dispatch.forward(request,response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
