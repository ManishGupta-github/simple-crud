package com.studentapp18.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOServiceImpl implements DAOService{
	private Connection con;
	private Statement stmnt;
public static void main(String[] args) {
	
}
@Override
public boolean verifylogin(String email,String password)
{
	try {
		ResultSet result = stmnt.executeQuery("select * from login where email='"+email+"' and password='"+password+"'");
		return result.next();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return false;
}
@Override
public void connectDB() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/augdb4","root","test");
		stmnt=con.createStatement();
	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
@Override
public void addController(String name, String email, String mobile) {
	try {
		stmnt.executeUpdate("insert into inquiry values('"+name+"','"+email+"','"+mobile+"');");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
@Override
public ResultSet listInquiry() {
	try {
		ResultSet result = stmnt.executeQuery("select * from inquiry");
		return result;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	return null;
}

}
@Override
public void deleteInquiry(String email) {
	try {
		stmnt.executeUpdate("delete from inquiry where email='"+email+"'");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
@Override
public void updateInquiry(String email, String mobile) {
	try {
		stmnt.executeUpdate("update inquiry set mobile='"+mobile+"' where email='"+email+"'");
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}
}
