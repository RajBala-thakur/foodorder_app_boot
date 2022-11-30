package com.ty.food_app.food_app_boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.food_app.food_app_boot.dao.FoodOrderDao;
import com.ty.food_app.food_app_boot.dto.FoodOrder;
import com.ty.food_app.food_app_boot.dto.Items;
import com.ty.food_app.food_app_boot.dto.Product;
import com.ty.food_app.food_app_boot.exception.NoSuchIdFoundException;
import com.ty.food_app.food_app_boot.exception.UnableToDeleteException;
import com.ty.food_app.food_app_boot.exception.UnableToUpdateException;
import com.ty.food_app.food_app_boot.util.ResponseStructure;

@Service
public class FoodOrderService {
	@Autowired
	private FoodOrderDao dao;
	
	public ResponseStructure<FoodOrder> saveFoodOrder(FoodOrder foodOrder)
	{
		List<Product>list =foodOrder.getProduct();
		double totalcost=0;
		for(Product product:list)
		{
			totalcost=totalcost+(product.getPrice()*product.getQuantity());
		}
		  totalcost=totalcost+(totalcost*0.18);
		  foodOrder.setTotalcost(totalcost);
		ResponseStructure<FoodOrder>responseStructure= new ResponseStructure<FoodOrder>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("saved");
		responseStructure.setData(dao.saveFoodOrder(foodOrder));
		return responseStructure;
		
	}
	public ResponseStructure<FoodOrder> updateFoodOrder(FoodOrder foodOrder,int id)
	
	{
		FoodOrder foodOrder1=dao.getFoodOrderById(id);
		ResponseStructure<FoodOrder>responseStructure= new ResponseStructure<FoodOrder>();
		if(foodOrder1!=null) {
		
		
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("updated");
		responseStructure.setData(dao.saveFoodOrder(foodOrder));
		return responseStructure;
		}
		else
		{
			 throw new UnableToUpdateException();
//			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
//			responseStructure.setMessage("NotFound");
//			responseStructure.setData(null);
//			return responseStructure;
		}
		
	}
	
	public ResponseStructure<FoodOrder> getFoodOrderById(int id)
	{
		FoodOrder foodOrder1=dao.getFoodOrderById(id);
		
		ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<FoodOrder>();
		if(foodOrder1!=null) {
		
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Received");
		responseStructure.setData(dao.getFoodOrderById(id));
	}else
	{
		throw new NoSuchIdFoundException();
	}
	return responseStructure;
	}
	
	public ResponseStructure<String> DeleteFoodOrderById(int id)
	{    	FoodOrder foodOrder1=dao.getFoodOrderById(id);
		ResponseStructure<String>responseStructure= new ResponseStructure<String>();
		if(foodOrder1!=null) {
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("deleted");
		responseStructure.setData(dao.deleteFoodOrder(id));
		return responseStructure;
	}
		else
		{
			throw new UnableToDeleteException("Unable to delete Exception");
		}
	

	}
	
	
	


}
