package com.zaid.ezy_shop.model;

import java.util.List;

import org.hibernate.annotations.GenericGenerator;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity
public class Items {

	@Id
	@GeneratedValue(generator = "auto")
	@GenericGenerator(name = "auto", strategy = "increment")
	private int itemId;
	private String itemName;
	private String itemBrand;
	private int itemCost;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user-item", joinColumns = @JoinColumn(name = "itemId"), inverseJoinColumns = @JoinColumn(name = "userId"))
	private List<User> userList;

	public String getItemBrand() {
		return itemBrand;
	}

	public void setItemBrand(String itemBrand) {
		this.itemBrand = itemBrand;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemCost() {
		return itemCost;
	}

	public void setItemCost(int itemCost) {
		this.itemCost = itemCost;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	@Override
	public String toString() {
		return "Items [itemId=" + itemId + ", itemName=" + itemName + ", itemBrand=" + itemBrand + ", itemCost="
				+ itemCost + "]";
	}

}
