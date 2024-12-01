package com.zaid.ezy_shop.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zaid.ezy_shop.model.Items;
import com.zaid.ezy_shop.model.User;
import com.zaid.ezy_shop.repository.EzyShop_ItemsRepository;
import com.zaid.ezy_shop.repository.EzyShop_UserRepository;

@Component
public class EzyShop_DaoImpl1 implements EzyShop_DaoInterface {

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
		User userFound = ezyShopUserRepo.findById(user.getUserId()).orElse(null);
		Items item = ezyShopItemsRepo.findById(id).orElse(null);
		User userItemAdded = null;
		if (userFound != null && item != null) {
			List<Items> itemList = userFound.getItemList();
			itemList.add(item);
			userItemAdded = ezyShopUserRepo.save(userFound);
			return userItemAdded;
		}
		return null;

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
