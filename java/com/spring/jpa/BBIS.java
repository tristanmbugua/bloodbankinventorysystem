package com.spring.jpa;

import java.sql.Date;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BBIS {

	public static void main(String[] args) {
		SpringApplication.run(BBIS.class, args);
		System.out.println("Blood Bank Information System running!");
	}
	
	@Bean
	public ApplicationRunner bloodStockInitializer(InMemoryBloodStockService inMemoryBloodStockService) {
		System.out.println("Initializing Blood Stocks.");
		return args -> {
			inMemoryBloodStockService.create(new BloodStock(
					1, 14, Date.valueOf("2024-12-13"), "Available"));
			inMemoryBloodStockService.create(new BloodStock(
					2, 82, Date.valueOf("2024-10-21"), "Unavailable"));
			inMemoryBloodStockService.create(new BloodStock(
					3, 91, Date.valueOf("2024-08-09"), "Available"));
		};
	}
	@Bean
	public ApplicationRunner bloodBankInitializer(InMemoryBloodBankService inMemoryBloodBankService) {
		System.out.println("Initializing Blood Banks.");
		return args -> {
			inMemoryBloodBankService.create(new BloodBank(
					123456789, "Tristan's Blood Donation Service",
					"123 Street Avenue", "Province City",
					"tristan.com", "tristan@tristan.com"
				));
			inMemoryBloodBankService.create(new BloodBank(
					987654321, "Mbugua's Blood Donation Service",
					"321 Street Avenue", "Province City",
					"mbugua.com", "mbugua@mbugua.com"
				));
			inMemoryBloodBankService.create(new BloodBank(
					142753869, "College's Blood Donation Service",
					"123 Avenue Street", "Province City",
					"college.com", "college@college.com"
				));
		};
	}
	@Bean
	public ApplicationRunner patientInitializer(InMemoryPatientService inMemoryPatientService) {
		System.out.println("Initializing Blood Patients.");
		return args -> {
			inMemoryPatientService.create(new Patient(
					123456789, "Tristan", "Mbugua",
					Date.valueOf("2004-01-02"), "Male",
					1, "Province City"));
			inMemoryPatientService.create(new Patient(
					987654321, "Mbugua", "Tristan",
					Date.valueOf("2004-01-20"), "Female",
					2, "Province City"));
			inMemoryPatientService.create(new Patient(
					142753869, "Tristan", "Centennial",
					Date.valueOf("2004-11-20"), "Female",
					3, "Province City"));
		};
	}

}
