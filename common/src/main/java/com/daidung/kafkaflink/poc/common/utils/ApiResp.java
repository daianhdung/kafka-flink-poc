package com.daidung.kafkaflink.poc.common.utils;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

@Getter
@Setter
@Builder
public class ApiResp<T> {
    private boolean success;
    private T data;
    private String errorCode;

    public static <T> ResponseEntity<ApiResp<T>> success(T data) {
        return ResponseEntity.ok(ApiResp.<T>builder().success(true).data(data).build());
    }

    public static <T> ResponseEntity<ApiResp<T>> error(T data) {
        return ResponseEntity.ok(ApiResp.<T>builder().success(false).data(data).build());
    }
}
