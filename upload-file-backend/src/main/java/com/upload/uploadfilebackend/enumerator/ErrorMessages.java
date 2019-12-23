package com.upload.uploadfilebackend.enumerator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessages {

    UNEXPECTED_ERROR("Unexpected error"),
    CNPJ_ALREADY_EXIST("CNPJ already exist on database");

    private String message;

}
