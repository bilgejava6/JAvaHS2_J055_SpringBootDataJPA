package com.muhammet.jpa.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaseResponse<T> {
    /**
     * Yapılan isteğe dönülen cevabın türünü belirtir. Genellikle firmaya göre değişir.
     */
    Integer code;
    /**
     * Yapılan işlemle ilgili olumlu ya da olumsuz cevapları buraya yazıyoruz.
     */
    String message;
    Boolean isSuccess;
    T data;
}
