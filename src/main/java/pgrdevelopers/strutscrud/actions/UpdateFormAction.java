package pgrdevelopers.strutscrud.actions;

import com.opensymphony.xwork2.ActionSupport;

import pgrdevelopers.strutscrud.db.DBUtils;
import pgrdevelopers.strutscrud.models.UserDataModel;

public class UpdateFormAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4120395273214708070L;

	private String userId;
	private String userName;
	private String email;

	public String execute() {
		System.out.println("Getting data from database....");
		UserDataModel user = DBUtils.getUserById(userId);
		userName = user.getUserName();
		email = user.getEmail();
		if (user != null) {
			System.out.println("User found!");
		}
		return SUCCESS;
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
