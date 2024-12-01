package com.zaid.ezy_shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.zaid.ezy_shop.dao.EzyShop_DaoInterface;
import com.zaid.ezy_shop.model.Items;
import com.zaid.ezy_shop.model.User;

public class EzyShop_ServiceImpl2 implements EzyShop_ServiceInterface {

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletedFromCart(int id, User user) {
		ezyShopDao.deletedFromCart(id, user);
	}

}
