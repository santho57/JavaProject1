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

@WebServlet("/NoteEditServlet")
public class NoteEditServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
		Integer noteid = Integer.parseInt(request.getParameter("noteid"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		PostDAO dao=new PostDAO(DBConnect.getConnection());
		boolean f=dao.PostUpdate(noteid, title, content);
		if(f)
		{
			System.out.println("Data update successfully.");
			HttpSession session=request.getSession();
			session.setAttribute("updateMsg", "Notes updated successfully");
			response.sendRedirect("ShowNotes.jsp");
		}else{
			System.out.println("Data not updated.");
		}
	}
		catch(Exception e)
		{
		e.printStackTrace();
	}
	}

}
