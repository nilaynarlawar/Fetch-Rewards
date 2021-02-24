package com.fetchrewards.utils;

import com.fetchrewards.domain.model.PayerDetail;

import java.time.Instant;
import java.util.*;

public class FetchRewardUtils {
    public static long convertStringToTimeStmp(String input){
        long ts = Instant.parse(input).toEpochMilli();
        return ts;
    }

    public static List<PayerDetail> mapToListPayerDetails(Map<String, Integer> payers){
        List<PayerDetail> result = new ArrayList<>();
        for(String key: payers.keySet()){
            PayerDetail pd = new PayerDetail(key,payers.get(key));
            result.add(pd);
        }
        return result;
    }
}
