package com.theironyard.invoicify.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.theironyard.invoicify.models.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
