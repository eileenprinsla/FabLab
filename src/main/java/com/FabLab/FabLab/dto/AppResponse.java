package com.FabLab.FabLab.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AppResponse<T> {
    private int statusCode;
    private T data;

    public AppResponse(int statusCode, T data) {
        this.statusCode = statusCode;
        this.data = data;
    }

}
