package com.nablarch.example.app.redisstore;

import nablarch.fw.ExecutionContext;
import nablarch.fw.Handler;
import nablarch.fw.web.HttpErrorResponse;

import java.util.concurrent.CancellationException;

public class MyRedisStoreHandler implements Handler<Object, Object> {
    @Override
    public Object handle(Object data, ExecutionContext context) {
        try {
            return context.handleNext(data);
        } catch (CancellationException e) {
            throw new HttpErrorResponse(503, "/WEB-INF/view/common/errorPage/serviceUnavailableError.jsp", e);
        }
    }
}
