package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DB.DBConnect;
import com.Dao.PostDAO;

@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer noteid=Integer.parseInt(request.getParameter("note_id"));
		PostDAO dao=new PostDAO(DBConnect.getConnection());
		boolean f=dao.DeleteNotes(noteid);
		HttpSession session=null;
		if(f)
		{
			System.out.println("Data delete successfully.");

			 session=request.getSession();
			session.setAttribute("DeleteMsg", "Notes delete successfully.");
			response.sendRedirect("ShowNotes.jsp");
		}
		else{
			session=request.getSession();
			session.setAttribute("wrongMsg", "Something went wrong on server.");
			response.sendRedirect("ShowNotes.jsp");
		}
	}

}