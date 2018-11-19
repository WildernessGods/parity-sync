package com.parity.paritysync.bean;

public class ReceiptLogsKey {
    private String transactionhash;

    private Integer transactionlogindex;

    public ReceiptLogsKey() {
    }

    public ReceiptLogsKey(String transactionhash, Integer transactionlogindex) {
        this.transactionhash = transactionhash;
        this.transactionlogindex = transactionlogindex;
    }

    public String getTransactionhash() {
        return transactionhash;
    }

    public void setTransactionhash(String transactionhash) {
        this.transactionhash = transactionhash == null ? null : transactionhash.trim();
    }

    public Integer getTransactionlogindex() {
        return transactionlogindex;
    }

    public void setTransactionlogindex(Integer transactionlogindex) {
        this.transactionlogindex = transactionlogindex;
    }
}