package com.github.stefanvozd.cqrs.reactiveaxon.rest.projection;

import com.github.stefanvozd.cqrs.reactiveaxon.common.api.QueryEventType;
import lombok.Value;

import java.util.UUID;

@Value
public class AccountQueryUpdate {

    AccountSummary accountSummary;
    UUID producedByCommandId;
    QueryEventType type;

}