package com.bootcamp.handler.json;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JsonError {
    private String url;
    private String message;

}
