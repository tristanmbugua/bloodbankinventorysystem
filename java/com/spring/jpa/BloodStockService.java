package com.spring.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;


public interface BloodStockService {
	Object findAll();
	Object find(String phone);
	Object create(BloodStock bloodStock);
	Object delete(String phone);
	Object update(BloodStock bloodStock);
}

@Service
class InMemoryBloodStockService implements BloodStockService{
	private final List<BloodStock> bloodStocks = new ArrayList<BloodStock>();
	
	@Override
	public Iterable<BloodStock> findAll() {
		return bloodStocks;
	}
	
	@Override
	public Optional<BloodStock> find(String bloodGroup) {
		BloodStock bloodStock;
		for (int i = 0; i < bloodStocks.size(); i++) {
			bloodStock = bloodStocks.get(i);
			if (bloodStock.getBloodGroup() == Integer.valueOf(bloodGroup)) {
				return Optional.ofNullable(bloodStock);
			}
		}
		return null; 
	}
	
	@Override
	public BloodStock create(BloodStock bloodStock) {
		bloodStocks.add(bloodStock);
		return bloodStock;
	}
	
	@Override
	public BloodStock delete(String bloodGroup) {
		BloodStock bloodStock;
		for (int i = 0; i < bloodStocks.size(); i++) {
			bloodStock = bloodStocks.get(i);
			if (bloodStock.getBloodGroup() == Integer.valueOf(bloodGroup)) {
				bloodStocks.remove(i);
				return bloodStock;
			}
		}
		return null;
	}
	
	@Override
	public BloodStock update(BloodStock bloodStock_) {
		BloodStock bloodStock;
		for (int i = 0; i < bloodStocks.size(); i++) {
			bloodStock = bloodStocks.get(i);
			if (bloodStock.getBloodGroup() == bloodStock_.getBloodGroup()) {
				bloodStocks.remove(i);
				bloodStocks.add(bloodStock_);
				return bloodStock;
			}
		}
		return null;
	}
}