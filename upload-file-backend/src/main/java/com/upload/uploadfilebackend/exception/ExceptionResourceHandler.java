package com.upload.uploadfilebackend.exception;

import com.upload.uploadfilebackend.enumerator.ErrorMessages;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

    @Slf4j
    @ControllerAdvice
    @SuppressWarnings({"checkstyle:AbbreviationAsWordInName", "PMD.TooManyMethods"})
    public class ExceptionResourceHandler extends ResponseEntityExceptionHandler {

        @ExceptionHandler(Exception.class)
        public final ResponseEntity<ExceptionResponse> handleAllExceptions(final Exception exception, final WebRequest request) {
            log.error("Unexpected error", exception);
            final ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ErrorMessages.UNEXPECTED_ERROR.name(),
                    request.getDescription(false));
            return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }

/*        @ExceptionHandler(CreateHealthCareInstitutionException.class)
        public final ResponseEntity<ExceptionResponse> handleCreateHealthCareInstitutionException(final WebRequest request) {
            final ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ErrorMessages.CREATE_INSTITUTION.getMessage(),
                    request.getDescription(false));
            return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
        }*/

}
