package com.parity.paritysync.utils.parity.result;

public class ResultGetTransactions {

    private Integer id;

    private String jsonrpc;

    private ResultTransactions result;

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

    public ResultTransactions getResult() {
        return result;
    }

    public void setResult(ResultTransactions result) {
        this.result = result;
    }
}
