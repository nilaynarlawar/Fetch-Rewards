package com.fetchrewards.domain.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRecord {
   @JsonUnwrapped
   private PayerDetail payerDetail;
   private String timestamp;

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof TransactionRecord)) return false;
      TransactionRecord that = (TransactionRecord) o;
      return Objects.equals(payerDetail, that.payerDetail) && Objects.equals(timestamp, that.timestamp);
   }

}
