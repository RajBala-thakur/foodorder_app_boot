package com.ty.food_app.food_app_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.food_app.food_app_boot.dto.FoodOrder;
import com.ty.food_app.food_app_boot.dto.Items;
import com.ty.food_app.food_app_boot.service.FoodOrderService;
import com.ty.food_app.food_app_boot.util.ResponseStructure;

@RestController
@RequestMapping("foodOrder")
public class FoodOrderController {
	@Autowired
	private FoodOrderService service;
	
	@PostMapping
	public ResponseStructure<FoodOrder> saveFoodOrder(@RequestBody FoodOrder foodOrder)
	{
		return service.saveFoodOrder(foodOrder);
		
	}
	@PutMapping
	public ResponseStructure<FoodOrder> updateFoodOrder(@RequestBody FoodOrder foodOrder,@RequestParam int id)
	{
		return service.updateFoodOrder(foodOrder, id);
		
	}
	@GetMapping
	public ResponseStructure<FoodOrder> getFoodOrderById(@RequestParam int id)
	{
		return service.getFoodOrderById(id);
		
	}
	@DeleteMapping
	public ResponseStructure<String> deleteFoodOrder(@RequestParam int id)
	{
		return service.DeleteFoodOrderById(id);
		
	}
	

}
