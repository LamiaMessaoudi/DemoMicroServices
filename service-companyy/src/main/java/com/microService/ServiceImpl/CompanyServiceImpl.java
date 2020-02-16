package com.microService.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microService.Repository.CompanyRepository;
import com.microService.Service.CompanyService;
import com.microService.entities.Company;
@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	CompanyRepository companyRepository;
	
	@Override
	public Company saveCompany(Company company) {
		return companyRepository.save(company);

	}

	@Override
	public List<Company> findAllCompany() {
		// TODO Auto-generated method stub
		return companyRepository.findAll();
	}

}
