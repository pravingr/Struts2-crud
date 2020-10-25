package pgrdevelopers.strutscrud.actions;

import com.opensymphony.xwork2.ActionSupport;

import pgrdevelopers.strutscrud.db.DBUtils;

public class DeleteUserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7865291118053386349L;

	private String userId;

	public String execute() {
		System.out.println("Deleting data from database....");
		if (DBUtils.deleteUsers(userId)) {
			System.out.println("Deleted data successfully from database!");
			return SUCCESS;
		} else {
			System.out.println("Failed to delete data");
			return ERROR;
		}

	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
