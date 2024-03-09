package com.spring.jpa;

import java.sql.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bloodStock")
public class BloodStockController {
	@Autowired
	private InMemoryBloodStockService bloodStockService;
	private BloodStock bloodStock;
	
	//GET BloodStock
		@GetMapping
		@ResponseBody
		public Object getBloodStock(
			@RequestParam(name="BloodGroup", required=true) String bloodGroup
			) {
			if (bloodStockService.find(bloodGroup) == null) {
				return new Error("1", "Get Blood Group", "This blood group does not exist.");
			}
			return bloodStockService.find(bloodGroup);
			}
	
	//GET ALL BloodStock
		@GetMapping("/all")
		@ResponseBody
		public Object getAllBloodStock() {
			
			return bloodStockService.findAll();
		}
		
		

	//POST BloodStock
		@PostMapping
		@ResponseBody
		public Object addBloodStock(
				@RequestParam(name="BloodGroup", required=true) String bloodGroup,
				@RequestParam(name="Quantity", required=true) String quantity,
				@RequestParam(name="BestBefore", required=true) String bestBefore,
				@RequestParam(name="Status", required=true) String status
				) {
			bloodStock = new BloodStock();
			
			bloodStock.setBloodGroup(Integer.parseInt(bloodGroup));
			bloodStock.setQuantity(Integer.parseInt(quantity));
			bloodStock.setBestBefore(Date.valueOf(bestBefore));
			bloodStock.setStatus(status);
			
			if (
					bloodStockService.find(
						String.valueOf(bloodStock.getBloodGroup())) == null
				) {
				bloodStockService.create(bloodStock);
				return bloodStock;
			}
			return new Error("2", "Add Blood Group", "This blood group already exists.");
		}
		
		//PUT BloodStock
		@PutMapping
		@ResponseBody
		public Object updateBloodStock(
				@RequestParam(name="BloodGroup", required=true) String bloodGroup,
				@RequestParam(name="Quantity", required=true) String quantity,
				@RequestParam(name="BestBefore", required=true) String bestBefore,
				@RequestParam(name="Status", required=true) String status
				) {
			if (
					bloodStockService.find(bloodGroup) != null
				) {
				bloodStock = new BloodStock();
				
				bloodStock.setBloodGroup(Integer.parseInt(bloodGroup));
				bloodStock.setQuantity(Integer.parseInt(quantity));
				bloodStock.setBestBefore(Date.valueOf(bestBefore));
				bloodStock.setStatus(status);
				
				bloodStockService.delete(bloodGroup);
				bloodStockService.create(bloodStock);
				return bloodStock;
			}
			return new Error("3", "Update Blood Group", "This blood group does not exist.");
		}
		
		//DELETE BloodStock
		@DeleteMapping
		@ResponseBody
		public Object deleteBloodStock(
				@RequestParam(name="BloodGroup", required=true) String bloodGroup
				) {
			if (bloodStockService.find(bloodGroup) == null) {
				return new Error("4", "Delete Blood Group", "This blood group does not exist.");
			}
			bloodStockService.delete(bloodGroup);
			return "Successful deletion of " + bloodGroup;
		}
}