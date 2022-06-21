package com.nttdata.client;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.nttdata.client.dto.AccountRequest;

import java.io.IOException;

public class ProductResultDeserializer extends JsonDeserializer<AccountRequest> {
    @Override
    public AccountRequest deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        ObjectCodec oc= p.getCodec();
        JsonNode node=oc.readTree(p);

        return new AccountRequest(node.get("accountType").asText(),
                node.get("cardNumber").asText(),
                node.get("amount").decimalValue());
    }
}
