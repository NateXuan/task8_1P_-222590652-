package web.service;


public class LoginService {

	/**
	 * Static method returns true for successful login, false otherwise.
	 * @param username
	 * @param password
	 * @return
	 */
	public static boolean login(String username, String password, String dob) {
		// Match a fixed user name and password.
		// assume DoB is 01 Jan 2000
		if ("wenzong".equals(username) && "wenzong_pass".equals(password) && "2000-01-01".equals(dob)) {
            return true;
        }
        return false;
	}
	
	
}
