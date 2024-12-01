package com.zaid.ezy_shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zaid.ezy_shop.model.Items;
import com.zaid.ezy_shop.model.User;
import com.zaid.ezy_shop.service.EzyShop_ServiceInterface;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class EzyShopController {

	@Autowired
	private EzyShop_ServiceInterface ezyShopService;

	@GetMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/get-userregistration-jsp")
	public String registrationPage() {
		return "user-registrationpage-view";
	}

	@PostMapping("/registration")
	public String addUser(@ModelAttribute User user) {
		ezyShopService.addUser(user);
		return "loginpage";
	}

	@PostMapping("/login")
	public String login(@RequestParam String userName, @RequestParam String password, Model model,HttpServletRequest request) {
		User user = ezyShopService.findUser(userName, password);
		if (user != null) {
			List<Items> itemsList = ezyShopService.itemsList();
			model.addAttribute("itemsList", itemsList);
			HttpSession session = request.getSession(true);
			session.setAttribute("user", user);
			return "homepage";
		}

		return "nouserfound";

	}

	@GetMapping("/get-itemregistration-jsp")
	public String itemPage() {
		return "item-registrationpage-view";
	}

	@PostMapping("/additem")
	public String addItem(@ModelAttribute Items item) {
		ezyShopService.addItem(item);
		return "item-registerdpage-view";
	}

	@GetMapping("/get-login-jsp")
	public String loginPage() {
		return "loginpage";
	}

	@GetMapping("/addtocart/{id}")
	public String addToCart(@PathVariable int id, HttpServletRequest req, Model model,RedirectAttributes redirectattribute) {
		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("user");
		User userItemAdded = ezyShopService.addToCart(id, user);
		redirectattribute.addFlashAttribute("user", userItemAdded);
		return "redirect:/addedtocart";
	}

	@GetMapping("/addedtocart")
	public String login_AddedToCart(@ModelAttribute User user, Model model, HttpServletRequest request) {
		if (user != null) {
			List<Items> itemsList = ezyShopService.itemsList();
			model.addAttribute("itemsList", itemsList);
			return "useritem-added";
		}
		return "nouserfound";

	}

	@GetMapping("/cart")
	public String myCart(HttpServletRequest req, Model model) {
		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("user");
		User userFound = ezyShopService.findUser(user.getUserName(), user.getPassword());
		List<Items> itemList = userFound.getItemList();
		if (itemList != null && !itemList.isEmpty()) {
			int price = 0;
			for (Items items : itemList) {
				price += items.getItemCost();
			}
			model.addAttribute("total", price);
			model.addAttribute("items", itemList);
			return "cart";

		}

		return "empty-cart";
	}

	@GetMapping("/deletefromcart/{id}")
	public String deleteFromCart(@PathVariable int id, HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("user");
		ezyShopService.deletedFromCart(id, user);
		return "redirect:/cart";
	}

	@GetMapping("/buy")
	public String buyNow(HttpServletRequest req, Model model) {
		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("user");
		User userFound = ezyShopService.findUser(user.getUserName(), user.getPassword());
		if (userFound != null) {

			List<Items> itemList = userFound.getItemList();
			int price = 0;
			for (Items items : itemList) {
				price += items.getItemCost();
			}
			model.addAttribute("total", price);
			model.addAttribute("items", itemList);
			return "billing";
		} else {
			return "loginpage";
		}
	}

	@GetMapping("/placeorder")
	public String placeOrder() {
		return "orderplaced";

	}

	@GetMapping("/logout")
	public String logOut(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		session.invalidate();
		return "loginpage";
	}

	@GetMapping("/continueshopping")
	public String continueShopping(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");
		String userName = user.getUserName();
		String password = user.getPassword();
		User userFound = ezyShopService.findUser(userName, password);
		if (userFound != null) {
			List<Items> itemsList = ezyShopService.itemsList();
			model.addAttribute("itemsList", itemsList);
			return "homepage";
		}
		return "nouserfound";

	}

}
