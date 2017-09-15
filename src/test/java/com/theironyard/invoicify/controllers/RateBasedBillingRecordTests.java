package com.theironyard.invoicify.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.security.core.Authentication;
import org.springframework.web.servlet.ModelAndView;

import com.theironyard.invoicify.models.BillingRecord;
import com.theironyard.invoicify.models.Company;
import com.theironyard.invoicify.models.RateBasedBillingRecord;
import com.theironyard.invoicify.models.User;
import com.theironyard.invoicify.repositories.BillingRecordRepository;
import com.theironyard.invoicify.repositories.CompanyRepository;

public class RateBasedBillingRecordTests {

	private BillingRecordRepository recordRepo;
	private CompanyRepository companies;
	private RateBasedBillingRecordController controller;
	private Authentication authentication;
	private Company company;
	
	@Before
	public void setup() {
		company = new Company();
		authentication = mock(Authentication.class);
//		when(authentication.getPrincipal()).thenReturn(user);
		recordRepo = mock(BillingRecordRepository.class);
		companies = mock(CompanyRepository.class);
		controller = new RateBasedBillingRecordController(recordRepo, companies);
	}
	
	@Test
	public void test_create() {
		// Arrange
		RateBasedBillingRecord record = new RateBasedBillingRecord();
		when(companies.findOne(3l)).thenReturn(company);
		when(recordRepo.save(record)).thenReturn(record);
		
				// Act
		ModelAndView mv = controller.create(record, 3l, authentication);
		
		// Assert
		assertThat(mv.getViewName()).isEqualTo("billing-records/list");
		verify(companies).findOne(3l);
		verify(recordRepo).save(record);
	}
	

}
