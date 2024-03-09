package com.spring.jpa;

import java.sql.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {
	@Autowired
	private InMemoryPatientService patientService;
	private Patient patient;
	Optional<Patient> nullReturnP = Optional.empty();
	
	//GET Patient
			@GetMapping
			@ResponseBody
			public Object getPatient(
					@RequestParam(name="Phone", required=true) String phone
					) {
				if (patientService.find(phone) == null) {
					return new Error("1", "Get Patient", "This patient does not exist.");
				}
				return patientService.find(phone);
			}
			
	//GET ALL Patient
		@GetMapping("/all")
		@ResponseBody
		public Object getAllPatient() {
			return patientService.findAll();
		}
		
		
		
		//POST Patient
		@PostMapping
		@ResponseBody
		public Object addPatient(
				@RequestParam(name="Phone", required=true) String phone,
				@RequestParam(name="FirstName", required=true) String firstName,
				@RequestParam(name="LastName", required=true) String lastName,
				@RequestParam(name="DateOfBirth", required=true) String dateOfBirth,
				@RequestParam(name="Gender", required=true) String gender,
				@RequestParam(name="BloodGroup", required=true) String bloodGroup,
				@RequestParam(name="City", required=true) String city
				) {
			patient = new Patient();
			
			patient.setPhone(Long.parseLong(phone));
			patient.setFirstName(firstName);
			patient.setLastName(lastName);
			patient.setDateOfBirth(Date.valueOf(dateOfBirth));
			patient.setGender(gender);
			patient.setBloodGroup(Integer.parseInt(bloodGroup));
			patient.setCity(city);
			
			if (
					patientService.find(phone)
					== null
				) {
				patientService.create(patient);
				return patient;
			}
			return new Error("2", "Add Patient", "This patient already exists.");
		}
		
		//PUT Patient
		@PutMapping
		@ResponseBody
		public Object updatePatient(
				@RequestParam(name="Phone", required=true) String phone,
				@RequestParam(name="FirstName", required=true) String firstName,
				@RequestParam(name="LastName", required=true) String lastName,
				@RequestParam(name="DateOfBirth", required=true) String dateOfBirth,
				@RequestParam(name="Gender", required=true) String gender,
				@RequestParam(name="BloodGroup", required=true) String bloodGroup,
				@RequestParam(name="City", required=true) String city
				)
		{
			if (
					patientService.find(phone) 
					!= null
				) {
				patient = new Patient();
				
				patient.setPhone(Long.parseLong(phone));
				patient.setFirstName(firstName);
				patient.setLastName(lastName);
				patient.setDateOfBirth(Date.valueOf(dateOfBirth));
				patient.setGender(gender);
				patient.setBloodGroup(Integer.parseInt(bloodGroup));
				patient.setCity(city);
				patientService.delete(phone);
				patientService.create(patient);
				return patient;
			}
			return new Error("3", "Update Patient", "This patient does not exist.");
		}
		
		//DELETE Patient
		@DeleteMapping
		@ResponseBody
		public Object deletePatient(
				@RequestParam(name="Phone", required=true) String phone
				) {
			if (patientService.find(phone) == null) {
				return new Error("4", "Delete Patient", "This patient does not exist.");
			}
			patientService.delete(phone);
			return "Successful deletion of " + phone;
		}
}
