package com.microService.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microService.ServiceImpl.CompanyServiceImpl;
import com.microService.entities.Company;
@RefreshScope
@RestController
public class companyController {
	@Autowired
	CompanyServiceImpl companyServiceImpl;
	@Value("${xParam}")
	private int xParam;
	
	@Value("${yparam}")
	private int yparam;
	
	@Value("${me}")
	private String me;
	
	@GetMapping("myConfig")
	public Map<String,Object>myConfig()
	{
		Map<String,Object>params=new HashMap<>();
		params.put("xParam", xParam);
		params.put("yparam", yparam);
		params.put("me", me);
		params.put("ThreadName", Thread.currentThread().getName());
		return params;
	}
	@GetMapping("/HelloWorld")
	public String   getMessage()
	{
		return "hello world ";
	}
	
	@PostMapping("/saveCompany")
	public void saveCompany(@RequestBody Company company)
	{
		companyServiceImpl.saveCompany(company);
	}

}
