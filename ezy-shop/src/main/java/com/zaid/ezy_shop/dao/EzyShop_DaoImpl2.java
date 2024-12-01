package com.zaid.ezy_shop.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.zaid.ezy_shop.model.Items;
import com.zaid.ezy_shop.model.User;
import com.zaid.ezy_shop.repository.EzyShop_ItemsRepository;
import com.zaid.ezy_shop.repository.EzyShop_UserRepository;

public class EzyShop_DaoImpl2 implements EzyShop_DaoInterface {

	@Autowired
	private EzyShop_UserRepository ezyShopUserRepo;

	@Autowired
	private EzyShop_ItemsRepository ezyShopItemsRepo;

	@Override
	public void addUser(User user) {
		ezyShopUserRepo.save(user);
	}

	@Override
	public User findUser(String userName, String password) {

		User user = ezyShopUserRepo.findByUserNameAndPassword(userName, password);
		return user;
	}

	@Override
	public List<Items> itemsList() {
		List<Items> itemsList = ezyShopItemsRepo.findAll();
		return itemsList;
	}

	@Override
	public void addItem(Items item) {
		ezyShopItemsRepo.save(item);

	}

	@Override
	public User addToCart(int id, User user) {
		User userFound = ezyShopUserRepo.findById(user.getUserId()).orElse(user);
		Items item = ezyShopItemsRepo.findById(id).orElse(null);
		List<Items> itemList = userFound.getItemList();
		itemList.add(item);
		User userItemAdded = ezyShopUserRepo.save(userFound);
		return userItemAdded;

	}

	@Override
	public void deletedFromCart(int id, User user) {
		User userFound = ezyShopUserRepo.findById(user.getUserId()).orElse(null);
		Items item = ezyShopItemsRepo.findById(id).orElse(null);
		if (userFound != null && item != null) {
			List<Items> itemList = userFound.getItemList();
			if (itemList.contains(item)) {
				itemList.remove(item);
			}
			ezyShopUserRepo.save(userFound);
		}
	}

}
