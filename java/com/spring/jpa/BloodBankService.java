package com.spring.jpa;

import java.util.*;
import org.springframework.stereotype.*;

public interface BloodBankService {
	Object findAll();
	Object find(String phone);
	Object create(BloodBank bloodBank);
	Object delete(String phone);
	Object update(BloodBank bloodBank);
}

@Service
class InMemoryBloodBankService implements BloodBankService{
	private final List<BloodBank> bloodBanks = new ArrayList<BloodBank>();
	
	@Override
	public Iterable<BloodBank> findAll() {
		return bloodBanks;
	}
	
	@Override
	public Optional<BloodBank> find(String phone) {
		BloodBank bloodBank;
		for (int i = 0; i < bloodBanks.size(); i++) {
			bloodBank = bloodBanks.get(i);
			if (bloodBank.getPhone() == Long.valueOf(phone)) {
				return Optional.ofNullable(bloodBank);
			}
		}
		return null; 
	}
	
	@Override
	public BloodBank create(BloodBank bloodBank) {
		bloodBanks.add(bloodBank);
		return bloodBank;
	}
	
	@Override
	public BloodBank delete(String phone) {
		BloodBank bloodBank;
		for (int i = 0; i < bloodBanks.size(); i++) {
			bloodBank = bloodBanks.get(i);
			if (bloodBank.getPhone() == Long.valueOf(phone)) {
				bloodBanks.remove(i);
				return bloodBank;
			}
		}
		return null;
	}
	
	@Override
	public BloodBank update(BloodBank bloodBank_) {
		BloodBank bloodBank;
		for (int i = 0; i < bloodBanks.size(); i++) {
			bloodBank = bloodBanks.get(i);
			if (bloodBank.getPhone() == bloodBank_.getPhone()) {
				bloodBanks.remove(i);
				bloodBanks.add(bloodBank_);
				return bloodBank;
			}
		}
		return null;
	}
}