package com.zaid.ezy_shop.model;

import java.util.List;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity
public class User {

	@Id
	@GeneratedValue(generator = "auto")
	@GenericGenerator(name = "auto", strategy = "increment")
	private int userId;
	private String userName;
	private String password;
	private String email;
	private long mobileNumber;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user-item", joinColumns = @JoinColumn(name = "userId"), inverseJoinColumns = @JoinColumn(name = "itemId"))
	private List<Items> itemList;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String user) {
		this.userName = user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Items> getItemList() {
		return itemList;
	}

	public void setItemList(List<Items> itemList) {
		this.itemList = itemList;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", mobileNumber=" + mobileNumber + "]";
	}

}
