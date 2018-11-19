package com.parity.paritysync.utils.parity.result;

public class ResultGetBlock {

    private Integer id;

    private String jsonrpc;

    private ResultBlock result;

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

    public ResultBlock getResult() {
        return result;
    }

    public void setResult(ResultBlock result) {
        this.result = result;
    }

}
