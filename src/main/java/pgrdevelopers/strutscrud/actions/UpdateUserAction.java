package pgrdevelopers.strutscrud.actions;

import com.opensymphony.xwork2.ActionSupport;

import pgrdevelopers.strutscrud.db.DBUtils;

public class UpdateUserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2295821784113738920L;

	private String userId;
	private String userName;
	private String email;

	public String execute() {
		System.out.println("Updating data into database....");
		if (DBUtils.updateUser(userId, userName, email)) {
			System.out.println("User updated successfully into database!");
			return SUCCESS;
		} else {
			System.out.println("Failed to update user");
			return ERROR;
		}

	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
