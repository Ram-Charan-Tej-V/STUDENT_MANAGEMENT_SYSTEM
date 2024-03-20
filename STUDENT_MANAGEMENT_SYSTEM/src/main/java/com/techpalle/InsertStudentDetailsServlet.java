package com.techpalle;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.techpalle.dao.DataAccess;
@WebServlet("/insertstudent")
public class InsertStudentDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public InsertStudentDetailsServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sname = request.getParameter("sname");
		String sub = request.getParameter("sub");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String education = request.getParameter("education");		
		DataAccess.insertStudent(sname, sub, gender, email, education);
	}

}
