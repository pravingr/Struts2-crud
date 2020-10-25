package pgrdevelopers.strutscrud.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import pgrdevelopers.strutscrud.models.UserDataModel;

public class DBUtils {

	public static List<UserDataModel> getUsers() {

		Connection conn = null;
		List<UserDataModel> users = new ArrayList<UserDataModel>();

		try {

			conn = DBConnect.getDBConnection();
			String sql = "SELECT * FROM users";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				UserDataModel userDataModel = new UserDataModel(rs.getString("userId"), rs.getString("userName"),
						rs.getString("email"));
				System.out.println(userDataModel.toString());
				users.add(userDataModel);
			}
		} catch (Exception e) {
			System.out.println("Failed to fetch data from database!");
			return null;
		} finally {
			if (conn != null) {
				DBConnect.closeDBConnection(conn);
			}
		}

		return users;

	}

	public static UserDataModel getUserById(String userId) {

		Connection conn = null;

		try {

			conn = DBConnect.getDBConnection();
			String sql = "SELECT userId, userName, email FROM users where userId=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();
			UserDataModel user = null;

			while (rs.next()) {
				user = new UserDataModel(rs.getString("userId"), rs.getString("userName"), rs.getString("email"));
				System.out.println(user.toString());

			}
			return user;
		} catch (Exception e) {
			System.out.println("Failed to fetch data from database!");
			return null;
		} finally {
			if (conn != null) {
				DBConnect.closeDBConnection(conn);
			}
		}

	}

	public static String createUser(String userId, String userName, String email) {
		Connection conn = null;
		String flag = "error";

		try {

			conn = DBConnect.getDBConnection();
			String sql = "INSERT INTO users values(?,?,?)";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, userName);
			ps.setString(3, email);

			ps.executeUpdate();
			flag = "success";
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("User Id already exists!");
			flag = "id exists";
		} catch (Exception e) {
			System.out.println("Failed to insert data in database!");
		} finally {
			if (conn != null) {
				DBConnect.closeDBConnection(conn);
			}
		}
		return flag;

	}

	public static boolean updateUser(String userId, String userName, String email) {
		Connection conn = null;
		boolean flag = false;

		try {

			conn = DBConnect.getDBConnection();
			String sql = "UPDATE users SET userName=?, email=? WHERE userId=?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, email);
			ps.setString(3, userId);

			ps.executeUpdate();
			flag = true;
		} catch (Exception e) {
			System.out.println("Failed to update data in database!");
		} finally {
			if (conn != null) {
				DBConnect.closeDBConnection(conn);
			}
		}
		return flag;

	}

	public static boolean deleteUsers(String userId) {
		Connection conn = null;
		boolean flag = false;

		try {

			conn = DBConnect.getDBConnection();
			String sql = "DELETE FROM users WHERE userId=?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userId);

			ps.executeUpdate();
			flag = true;
		} catch (Exception e) {
			System.out.println("Failed to delete data in database!");
		} finally {
			if (conn != null) {
				DBConnect.closeDBConnection(conn);
			}
		}
		return flag;

	}
}
