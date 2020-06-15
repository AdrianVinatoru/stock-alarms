package com.adyvan.stockalarms.types;

import com.adyvan.stockalarms.exceptions.ApiError;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenericResponse {

    private Object result;

    private int httpCode;

    private String httpMessage;

    private List<ApiError> error;

    public Object getResult() {
        if (result == null) {
            return Collections.EMPTY_LIST;
        }
        return result;
    }

    public List<ApiError> getError() {
        if (error == null) {
            return Collections.EMPTY_LIST;
        }
        return error;
    }
}
