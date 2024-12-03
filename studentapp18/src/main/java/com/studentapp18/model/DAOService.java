package com.studentapp18.model;

import java.sql.ResultSet;

public interface DAOService {
public boolean verifylogin(String email,String password);
public void connectDB();
public void addController(String name,String email,String mobile);
public ResultSet listInquiry();
public void deleteInquiry(String email);
public void updateInquiry(String email,String mobile);
}
