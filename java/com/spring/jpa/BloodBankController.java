package com.spring.jpa;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bloodbank")
public class BloodBankController {
	@Autowired
	private InMemoryBloodBankService bloodBankService;
	private BloodBank bloodBank;
	Optional<BloodBank> nullReturnBB = Optional.empty();
	
	//GET BloodBank
			@GetMapping
			@ResponseBody
			public Object getBloodBank(
					@RequestParam(name="Phone", required=true) String phone
					) {
				if (bloodBankService.find(phone) == null) {
					return new Error("1", "Get Blood Bank", "This blood bank does not exist.");
				}
				return bloodBankService.find(phone);
			}
	//GET ALL BloodBank
		@GetMapping("/all")
		@ResponseBody
		public Object getAllBloodBank() {
			return bloodBankService.findAll();
		}
		
	//POST BloodBank
		@PostMapping
		@ResponseBody
		public Object addBloodBank(
				@RequestParam(name="Name", required=true) String name,
				@RequestParam(name="Address", required=true) String address,
				@RequestParam(name="City", required=true) String city,
				@RequestParam(name="Phone", required=true) String phone,
				@RequestParam(name="Website", required=true) String website,
				@RequestParam(name="Email", required=true) String email 
				) {
			bloodBank = new BloodBank();
			
			bloodBank.setName(name);
			bloodBank.setAddress(address);
			bloodBank.setCity(city);
			bloodBank.setPhone(Long.parseLong(phone));
			bloodBank.setWebsite(website);
			bloodBank.setEmail(email);
			
			if (
					bloodBankService.find(phone) == null
				) {
				bloodBankService.create(bloodBank);
				return bloodBank;
			}
			
			return new Error("2", "Add Blood Bank", "This blood bank already exists.");
		}
		
	//PUT BloodBank
		@PutMapping
		@ResponseBody
		public Object updateBloodBank(
				@RequestParam(name="Name", required=true) String name,
				@RequestParam(name="Address", required=true) String address,
				@RequestParam(name="City", required=true) String city,
				@RequestParam(name="Phone", required=true) String phone,
				@RequestParam(name="Website", required=true) String website,
				@RequestParam(name="Email", required=true) String email
				) {
			if (
					bloodBankService.find(phone) != null
				) {
				bloodBank = new BloodBank();
				
				bloodBank.setName(name);
				bloodBank.setAddress(address);
				bloodBank.setCity(city);
				bloodBank.setPhone(Integer.valueOf(phone));
				bloodBank.setWebsite(website);
				bloodBank.setEmail(email);
				bloodBankService.delete(phone);
				bloodBankService.create(bloodBank);
				return bloodBank;
			}
			return new Error("3", "Update Blood Bank", "This blood bank does not exist.");
		}
		
		
	//DELETE BloodBank
		@DeleteMapping
		@ResponseBody
		public Object deleteBloodBank(
				@RequestParam(name="Phone", required=true) String phone
				) {
			if (bloodBankService.find(phone) == null) {
				return new Error("4", "Delete Blood Bank", "This blood bank does not exist. It cannot be deleted.");
			}
			bloodBankService.delete(phone);
			return "Successful deletion of blood bank with the phone number: " + phone + ".";
		}
}
