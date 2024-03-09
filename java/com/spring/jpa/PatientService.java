package com.spring.jpa;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;


public interface PatientService {
	Object findAll();
	Object find(String phone);
	Object create(Patient Patient);
	Object delete(String phone);
	Object update(Patient Patient);
}

@Service
class InMemoryPatientService implements PatientService{
	private final List<Patient> Patients = new ArrayList<Patient>();
	
	@Override
	public Iterable<Patient> findAll() {
		return Patients;
	}
	
	@Override
	public Optional<Patient> find(String phone) {
		Patient Patient;
		for (int i = 0; i < Patients.size(); i++) {
			Patient = Patients.get(i);
			if (Patient.getPhone() == Integer.valueOf(phone)) {
				return Optional.ofNullable(Patient);
			}
		}
		return null; 
	}
	
	@Override
	public Patient create(Patient Patient) {
		Patients.add(Patient);
		return Patient;
	}
	
	@Override
	public Patient delete(String phone) {
		Patient Patient;
		for (int i = 0; i < Patients.size(); i++) {
			Patient = Patients.get(i);
			if (Patient.getPhone() == Integer.valueOf(phone)) {
				Patients.remove(i);
				return Patient;
			}
		}
		return null;
	}
	
	@Override
	public Patient update(Patient Patient_) {
		Patient Patient;
		for (int i = 0; i < Patients.size(); i++) {
			Patient = Patients.get(i);
			if (Patient.getPhone() == Patient_.getPhone()) {
				Patients.remove(i);
				Patients.add(Patient_);
				return Patient;
			}
		}
		return null;
	}
}