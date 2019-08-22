/**
 *
 */
package com.jcg.examples.service;

import java.sql.SQLException;

/**
 * @author JOSUE SANCHEZ SOFTTEK
 *
 */
public interface UserService {
	public boolean isValidUser(String username, String password) throws SQLException;
}
