package com.theironyard.invoicify.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.theironyard.invoicify.models.BillingRecord;
import com.theironyard.invoicify.models.InvoiceLineItem;

public interface BillingRecordRepository extends JpaRepository<BillingRecord, Long> {

	List<BillingRecord> findByClientId(Long clientId);

	List<BillingRecord> findByIdIn(long[] recordIds);

	List<BillingRecord> findByClientIdAndLineItemIsNull(long clientId);

	List<BillingRecord> findByIdInAndIdIsNull(long[] recordIds);

}
