package com.zaid.ezy_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zaid.ezy_shop.model.User;

public interface EzyShop_UserRepository extends JpaRepository<User, Integer> {

	User findByUserNameAndPassword(String userName, String password);

}
