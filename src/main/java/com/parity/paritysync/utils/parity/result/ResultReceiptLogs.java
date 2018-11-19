package com.parity.paritysync.utils.parity.result;

import java.util.ArrayList;
import java.util.List;

public class ResultReceiptLogs {

    private String blockNumber;

    private String blockHash;

    private String transactionHash;

    private String transactionIndex;

    private String transactionLogIndex;

    private String address;

    private String data;

    private String logIndex;

    private Boolean removed;

    private String type;

    private List<String> topics = new ArrayList<>();

    public String getBlockNumber() {
        return blockNumber;
    }

    public void setBlockNumber(String blockNumber) {
        this.blockNumber = blockNumber;
    }

    public String getBlockHash() {
        return blockHash;
    }

    public void setBlockHash(String blockHash) {
        this.blockHash = blockHash;
    }

    public String getTransactionHash() {
        return transactionHash;
    }

    public void setTransactionHash(String transactionHash) {
        this.transactionHash = transactionHash;
    }

    public String getTransactionIndex() {
        return transactionIndex;
    }

    public void setTransactionIndex(String transactionIndex) {
        this.transactionIndex = transactionIndex;
    }

    public String getTransactionLogIndex() {
        return transactionLogIndex;
    }

    public void setTransactionLogIndex(String transactionLogIndex) {
        this.transactionLogIndex = transactionLogIndex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getLogIndex() {
        return logIndex;
    }

    public void setLogIndex(String logIndex) {
        this.logIndex = logIndex;
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
        this.type = type;
    }

    public List<String> getTopics() {
        return topics;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }

    @Override
    public String toString() {
        return "ResultReceiptLogs{" +
                "blockNumber='" + blockNumber + '\'' +
                ", blockHash='" + blockHash + '\'' +
                ", transactionHash='" + transactionHash + '\'' +
                ", transactionIndex='" + transactionIndex + '\'' +
                ", transactionLogIndex='" + transactionLogIndex + '\'' +
                ", address='" + address + '\'' +
                ", data='" + data + '\'' +
                ", logIndex='" + logIndex + '\'' +
                ", removed=" + removed +
                ", type='" + type + '\'' +
                ", topics=" + topics +
                '}';
    }
}
