package com.parity.paritysync.utils.parity;

import java.util.ArrayList;
import java.util.List;

public class ParityParams {

    private Integer id;

    private String jsonrpc;

    private String method;

    private List<Object> params = new ArrayList<>();

    public ParityParams() {
    }

    public ParityParams(Integer id, String jsonrpc, String method) {
        this.id = id;
        this.jsonrpc = jsonrpc;
        this.method = method;
    }

    public ParityParams(Integer id, String jsonrpc, String method, List<Object> params) {
        this.id = id;
        this.jsonrpc = jsonrpc;
        this.method = method;
        this.params = params;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJsonrpc() {
        return jsonrpc;
    }

    public void setJsonrpc(String jsonrpc) {
        this.jsonrpc = jsonrpc;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public List<Object> getParams() {
        return params;
    }

    public void setParams(List<Object> params) {
        this.params = params;
    }
}
