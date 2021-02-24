package com.fetchrewards.controller;

import com.fetchrewards.domain.model.PayerDetail;
import com.fetchrewards.domain.model.TransactionRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.fetchrewards.service.TransactionService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rewards")
@Validated
@Slf4j
public class TransactionController {

	@Autowired
    private TransactionService transactionService;

	@PostMapping("/transaction")
	public String addTransaction(@RequestBody TransactionRecord transactionRecord) {
		System.out.println(
				"Transaction Record: " + transactionRecord.getPayerDetail().getPayer() + " " + transactionRecord.getTimestamp() + " "
        + transactionRecord.getPayerDetail().getPoints()
		);

        transactionService.addTransaction(transactionRecord);
		//transactionWrapper.addTransaction(transactionRecord);
		return "Transaction added successfully!";
	}

	@GetMapping("/balance")
	public List<PayerDetail> pointBalance(){

		return transactionService.getPayerDetails();
	}

	@PostMapping("/spend")
	public List<PayerDetail> spendPoints(@RequestBody Map<String, String> payload){
		int points = Integer.parseInt(payload.get("points"));
		if(points <= 0)
			return new ArrayList<PayerDetail>();
		return transactionService.spendPoints(points);
	}
}
