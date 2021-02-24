package com.fetchrewards.service;

import com.fetchrewards.domain.model.PayerDetail;
import com.fetchrewards.domain.model.TransactionRecord;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public interface TransactionService {
    void addTransaction(TransactionRecord record);
    List<PayerDetail> getPayerDetails();
    List<PayerDetail> spendPoints(Integer points);
}
