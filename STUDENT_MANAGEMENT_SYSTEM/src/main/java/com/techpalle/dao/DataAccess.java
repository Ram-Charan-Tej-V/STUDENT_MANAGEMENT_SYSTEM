package com.techpalle.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.techpalle.model.Student;

public class DataAccess {
	public static ArrayList<Student> getStudents() {
		ArrayList<Student> al = new ArrayList<Student>();//empty
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/j2eeproject","root","admin@2002");
			Statement s = con.createStatement();
			ResultSet res = s.executeQuery("select * from student");
			if(res != null) {
				while(res.next() == true) {
					//read each row from student table
					int sid = res.getInt(1);
					String sname = res.getString(2);
					String sub = res.getString(3);
					String gender = res.getString(4);
					String email = res.getString(5);
					String education = res.getString(6);
					//create student object
					Student obj = new Student(sid,sname,sub,gender,email,education);
					//add statement object to arraylist
					al.add(obj);
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return al;		
	}
	public static boolean insertStudent(String sname, String sub, String gender, String email, String education) {
		//jdbc code to insert student and check in work bench
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/j2eeproject","root","admin@2002");
			PreparedStatement s = con.prepareStatement("insert into student(sname,sub,gender,email,education) values(?,?,?,?,?)");
			s.setString(1, sname);
			s.setString(2, sub);
			s.setString(3, gender);
			s.setString(4, email);
			s.setString(5, education);
			s.executeUpdate();
			s.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}		
		return false;		
	}
	public static boolean checkAdminLogin(String email, String pw) {
		//JDBC code to read all rows from admin table
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/j2eeproject","root","admin@2002");
			Statement s = con.createStatement();
			ResultSet res = s.executeQuery("select * from admin");
			int count = 0;
			if(res != null) {
				while(res.next() == true){
					String dbemail = res.getString(2);//read email
					String dbpw = res.getString(3);//read pw
					if(dbemail.equals(email) && dbpw.equals(pw)){
						count++;
						break;
					}
				}
			}			
			if(count==1)
				return true;
			else
				return false;		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return false; //admin login failure		
	}
}
