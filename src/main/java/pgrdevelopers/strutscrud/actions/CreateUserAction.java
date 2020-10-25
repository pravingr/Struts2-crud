package pgrdevelopers.strutscrud.actions;

import com.opensymphony.xwork2.ActionSupport;

import pgrdevelopers.strutscrud.db.DBUtils;

public class CreateUserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7521720449465993897L;

	private String userId;
	private String userName;
	private String email;
	private boolean idExists = false;

	public String execute() {
		System.out.println("Inserting data into database....");
		String status = DBUtils.createUser(userId, userName, email);
		if (status.equals("id exists")) {
			idExists = true;
			return INPUT;
		} else {
			if (status.equals("success")) {
				System.out.println("Inserted data successfully into database!");
				return SUCCESS;
			} else {
				System.out.println("Failed to insert data");
				return ERROR;
			}
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

	public boolean isIdExists() {
		return idExists;
	}

	public void setIdExists(boolean idExists) {
		this.idExists = idExists;
	}

}
