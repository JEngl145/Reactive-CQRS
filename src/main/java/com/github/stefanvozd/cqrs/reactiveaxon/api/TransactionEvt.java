package com.github.stefanvozd.cqrs.reactiveaxon.api;

import java.math.BigDecimal;
import java.util.UUID;

public interface TransactionEvt {

    UUID getAccountId();
    BigDecimal getAmount();
    BigDecimal getNewBalance();
    String getDescription();

}
