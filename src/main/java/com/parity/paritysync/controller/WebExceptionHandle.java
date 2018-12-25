package com.parity.paritysync.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestControllerAdvice
public class WebExceptionHandle {

    private Logger logger = LoggerFactory.getLogger(WebExceptionHandle.class);

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        logger.error("参数解析失败", e);
        return ResponseEntity.badRequest().build();
    }

//    /**
//     * 404 - Not Found
//     */
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    @ExceptionHandler(NoHandlerFoundException.class)
//    public ResponseEntity handleResourceNotFoundException(NoHandlerFoundException e) {
//        logger.error("接口不存在", e);
//        return ResponseEntity.notFound().build();
//    }
//
//    /**
//     * 405 - Method Not Allowed
//     */
//    @ResponseStatus(METHOD_NOT_ALLOWED)
//    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
//    public ResponseEntity handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
//        logger.error("不支持当前请求方法", e);
//        return ResponseEntity.status(METHOD_NOT_ALLOWED).build();
//    }
//
//    /**
//     * 415 - Unsupported Media Type
//     */
//    @ResponseStatus(UNSUPPORTED_MEDIA_TYPE)
//    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
//    public ResponseEntity handleHttpMediaTypeNotSupportedException(Exception e) {
//        logger.error("不支持当前媒体类型", e);
//        return ResponseEntity.status(UNSUPPORTED_MEDIA_TYPE).build();
//    }

    /**
     * 500 - Internal Server Error
     */
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception e) {

        logger.error("服务运行异常", e);
        e.printStackTrace();
        return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
    }
}
