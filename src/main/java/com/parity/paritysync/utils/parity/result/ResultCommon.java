package com.parity.paritysync.utils.parity.result;

import java.util.Optional;

public class ResultCommon {

    private Integer id;

    private String jsonrpc;

    private String result;

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

    public Optional<String> getResult() {
        return Optional.ofNullable(result);
    }

    public void setResult(String result) {
        this.result = result;
    }
}
