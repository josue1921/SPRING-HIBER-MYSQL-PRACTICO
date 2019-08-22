package com.jcg.examples.dao;

import java.sql.SQLException;

/**
 * @author JOSUE SANCHEZ SOFTTEK 
 */
public interface UserDao {
	public boolean isValidUser(String username, String password) throws SQLException;
}
