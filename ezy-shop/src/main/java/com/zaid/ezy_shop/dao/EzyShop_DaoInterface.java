package com.zaid.ezy_shop.dao;

import java.util.List;

import com.zaid.ezy_shop.model.Items;
import com.zaid.ezy_shop.model.User;

public interface EzyShop_DaoInterface {

	void addUser(User user);

	User findUser(String userName, String password);

	void addItem(Items item);

	List<Items> itemsList();

	User addToCart(int id, User user);

	void deletedFromCart(int id, User user);

}
