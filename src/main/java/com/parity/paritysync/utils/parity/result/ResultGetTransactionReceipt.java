package com.parity.paritysync.utils.parity.result;

public class ResultGetTransactionReceipt {

    private Integer id;

    private String jsonrpc;

    private ResultTransactionReceipt result;

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

    public ResultTransactionReceipt getResult() {
        return result;
    }

    public void setResult(ResultTransactionReceipt result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ResultGetTransactionReceipt{" +
                "id=" + id +
                ", jsonrpc='" + jsonrpc + '\'' +
                ", result=" + result +
                '}';
    }
}
