package com.fetchrewards.domain.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayerDetail {

    private String payer;
    private int points;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PayerDetail)) return false;
        PayerDetail that = (PayerDetail) o;
        return points == that.points && Objects.equals(payer, that.payer);
    }
}
