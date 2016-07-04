package Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")

public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int uId;
	private String name;
	private String lname;
	private String uname;
	private int lcount;
	private String password;
	private String list_todo;

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public Person() {
		super();
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getlname() {
		return lname;
	}

	public void setlname(String lname) {
		this.lname = lname;
	}

	public String getuname() {
		return uname;
	}

	public void setuname(String uname) {
		this.uname = uname;
	}

	public String getpassword() {
		return password;
	}

	public void setpassword(String password) {
		this.password = password;
	}

	public int getlcount() {
		return lcount;
	}

	public void setlcount(int lcount) {
		this.lcount = lcount;
	}

	public String getlist_todo() {
		return list_todo;
	}

	public void setlist_todo(String list_todo) {
		this.list_todo = list_todo;
	}

	@Override
	public String toString() {
		return "Person [uId=" + uId + ", name=" + name + ", lname=" + lname + ", uname=" + uname + ", lcount=" + lcount
				+ ", password=" + password + "]";
	}
}