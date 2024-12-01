package com.zaid.ezy_shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zaid.ezy_shop.dao.EzyShop_DaoInterface;
import com.zaid.ezy_shop.model.Items;
import com.zaid.ezy_shop.model.User;

@Component
public class EzyShop_ServiceImpl1 implements EzyShop_ServiceInterface {

	@Autowired
	private EzyShop_DaoInterface ezyShopDao;

	@Override
	public void addUser(User user) {
		ezyShopDao.addUser(user);
	}

	@Override
	public User findUser(String userName, String password) {
		User user = ezyShopDao.findUser(userName, password);
		return user;
	}

	@Override
	public List<Items> itemsList() {
		List<Items> itemsList = ezyShopDao.itemsList();
		return itemsList;
	}

	@Override
	public void addItem(Items item) {
		ezyShopDao.addItem(item);

	}

	@Override
	public User addToCart(int id, User user) {
		User userItemAdded = ezyShopDao.addToCart(id, user);
		return userItemAdded;
	}

	@Override
	public void deletedFromCart(int id, User user) {
		ezyShopDao.deletedFromCart(id, user);

	}

}
