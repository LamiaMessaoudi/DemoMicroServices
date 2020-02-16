package com.microService.Service;

import java.util.List;


import com.microService.entities.Company;

public interface CompanyService {
	
public Company saveCompany(Company company);
public List<Company> findAllCompany();
}
