package com.parity.paritysync.bean;

public class ReceiptLogs {

    private Long blocknumber;

    private String blockhash;

    private String transactionhash;

    private Integer transactionindex;

    private Integer transactionlogindex;

    private String address;

    private String data;

    private Integer logindex;

    private Boolean removed;

    private String type;

    public Long getBlocknumber() {
        return blocknumber;
    }

    public void setBlocknumber(Long blocknumber) {
        this.blocknumber = blocknumber;
    }

    public String getBlockhash() {
        return blockhash;
    }

    public void setBlockhash(String blockhash) {
        this.blockhash = blockhash == null ? null : blockhash.trim();
    }

    public String getTransactionhash() {
        return transactionhash;
    }

    public void setTransactionhash(String transactionhash) {
        this.transactionhash = transactionhash == null ? null : transactionhash.trim();
    }

    public Integer getTransactionindex() {
        return transactionindex;
    }

    public void setTransactionindex(Integer transactionindex) {
        this.transactionindex = transactionindex;
    }

    public Integer getTransactionlogindex() {
        return transactionlogindex;
    }

    public void setTransactionlogindex(Integer transactionlogindex) {
        this.transactionlogindex = transactionlogindex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data == null ? null : data.trim();
    }

    public Integer getLogindex() {
        return logindex;
    }

    public void setLogindex(Integer logindex) {
        this.logindex = logindex;
    }

    public Boolean getRemoved() {
        return removed;
    }

    public void setRemoved(Boolean removed) {
        this.removed = removed;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}