package pgrdevelopers.strutscrud.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import pgrdevelopers.strutscrud.db.DBUtils;
import pgrdevelopers.strutscrud.models.UserDataModel;

public class HomeAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8681257570612591496L;

	private List<UserDataModel> users = null;
	private boolean flag = false;

	public String execute() {

		System.out.println("Fetching data from database....");
		users = DBUtils.getUsers();

		if (users != null) {
			if (users.size() != 0) {
				System.out.println("Data fetched successfully from database!");
				System.out.println("Total Records Found: " + users.size());
				return SUCCESS;
			} else {
				flag = true;
				System.out.println("No Records Found!");
				return SUCCESS;
			}
		}

		else {
			return ERROR;
		}

	}

	public List<UserDataModel> getUsers() {
		return users;
	}

	public void setUsers(List<UserDataModel> users) {
		this.users = users;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}
