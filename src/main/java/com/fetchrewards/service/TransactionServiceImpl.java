package com.fetchrewards.service;

import com.fetchrewards.domain.model.PayerDetail;
import com.fetchrewards.domain.model.TransactionRecord;
import com.fetchrewards.repository.TransactionRecords;
import com.fetchrewards.utils.FetchRewardUtils;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private static final Logger LOGGER = LogManager.getLogger(TransactionServiceImpl.class);

    @Override
    public void addTransaction(TransactionRecord record){
        LOGGER.info("Adding transaction to the dataset.");
        Set<TransactionRecord> transactionRecordsSet = TransactionRecords.getDataSet();
        transactionRecordsSet.add(record);
        updatedPayerBalance(record.getPayerDetail().getPayer(), record.getPayerDetail().getPoints());
        LOGGER.info("Added transaction successfully");
    }

    private void updatedPayerBalance(String payer, Integer points){
        LOGGER.info("Updating Payer balance details.");
        Map<String, Integer> balanceMap = TransactionRecords.getBalanceMap();
        if(balanceMap.containsKey(payer)){
            balanceMap.put(payer,
                    balanceMap.get(payer) + points);
        }else{
            balanceMap.put(payer, points);
        }
        LOGGER.info("Updated Payer balance details successfully.");
    }

    @Override
    public List<PayerDetail> getPayerDetails(){
        LOGGER.info("Updating Payer balance details.");
        List<PayerDetail> payerDetails = new ArrayList<>();
        Map<String, Integer> balanceMap = TransactionRecords.getBalanceMap();
        for (String key: balanceMap.keySet()){
            PayerDetail pd = new PayerDetail(key, balanceMap.get(key));
            payerDetails.add(pd);
        }
        return payerDetails;
    }

    @Override
    public List<PayerDetail> spendPoints(Integer points){
        LOGGER.info("Inside the spending point method");
        Map<String, Integer> payerDetails = new HashMap<>();
        TreeSet<TransactionRecord> transactionRecordsSet = (TreeSet<TransactionRecord>) TransactionRecords.getDataSet();
        while(points != 0) {
            TransactionRecord record = transactionRecordsSet.first();
            if(record.getPayerDetail().getPoints() > points){
                int remainingPt = record.getPayerDetail().getPoints() - points;
                generateResponseData(points, record, payerDetails);
                updatedPayerBalance(record.getPayerDetail().getPayer(), -1 * points);
                points = 0;
                record.getPayerDetail().setPoints(remainingPt);
            }else {
                points -= record.getPayerDetail().getPoints();
                generateResponseData(record.getPayerDetail().getPoints(), record, payerDetails);
                updatedPayerBalance(record.getPayerDetail().getPayer(), -1 * record.getPayerDetail().getPoints());
                transactionRecordsSet.remove(record);
            }
        }
        return FetchRewardUtils.mapToListPayerDetails(payerDetails);
    }

    private void generateResponseData(Integer pointsUsed, TransactionRecord record, Map<String, Integer> payerDetails){
        LOGGER.info("Inside the generate response method");
        pointsUsed = pointsUsed * -1;
        if(payerDetails.containsKey(record.getPayerDetail().getPayer())){
            payerDetails.put(record.getPayerDetail().getPayer(), payerDetails.get(record.getPayerDetail().getPayer())
                    + pointsUsed);
        }else{
            payerDetails.put(record.getPayerDetail().getPayer(), pointsUsed);
        }
    }
}
