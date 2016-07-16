package com.example.web;

import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.NoSuchElementException;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class WebHandler {

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseBody
    @ResponseStatus(NOT_FOUND)
    public String serviceNoValuePresent() {
        return "Error. 404 not found";
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String serviceAnyException() {
        return "Error. Contact support";
    }

    @ExceptionHandler(BindException.class)
    @ResponseBody
    @ResponseStatus(BAD_REQUEST)
    public List<String> serviceBindingError(BindException ex) {
      return ex.getAllErrors().stream()
              .map(e->e.getCode())
              .collect(toList());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(BAD_REQUEST)
    public List<String> serviceBindingError(MethodArgumentNotValidException ex) {
      return ex.getBindingResult().getAllErrors()
              .stream()
              .map(e->e.getCode())
              .collect(toList());
    }
}
