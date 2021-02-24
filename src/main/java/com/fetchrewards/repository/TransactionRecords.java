package com.fetchrewards.repository;

import com.fetchrewards.domain.model.PayerDetail;
import com.fetchrewards.domain.model.TransactionRecord;
import com.fetchrewards.utils.FetchRewardUtils;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.*;
import java.util.TreeSet;

class TimeStampComp implements Comparator<TransactionRecord>{

    @Override
    public int compare(TransactionRecord r1, TransactionRecord r2) {
        Long t1 = FetchRewardUtils.convertStringToTimeStmp(r1.getTimestamp());
        Long t2 = FetchRewardUtils.convertStringToTimeStmp(r2.getTimestamp());
        return t1.compareTo(t2);
    }
}

public class TransactionRecords {

    public static Set<TransactionRecord> getDataSet() {
        return dataSet;
    }

    public static void setDataSet(Set<TransactionRecord> dataSet) {
        TransactionRecords.dataSet = dataSet;
    }

    public static Map<String, Integer> getBalanceMap() {
        return balanceMap;
    }

    public static void setBalanceMap(Map<String, Integer> balanceMap) {
        TransactionRecords.balanceMap = balanceMap;
    }

    private static Set<TransactionRecord> dataSet = new TreeSet<>(new TimeStampComp());
    private static Map<String, Integer> balanceMap = new HashMap<>();
}
