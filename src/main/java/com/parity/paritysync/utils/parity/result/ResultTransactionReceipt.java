package com.parity.paritysync.utils.parity.result;

import java.util.ArrayList;
import java.util.List;

public class ResultTransactionReceipt {

    private String blockNumber;

    private String blockHash;

    private String transactionHash;

    private String transactionIndex;

    private String contractAddress;

    private String cumulativeGasUsed;

    private String from;

    private String gasUsed;

    private String logsBloom;

    private String root;

    private String status;

    private String to;

    private List<ResultReceiptLogs> logs = new ArrayList<>();

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

    public String getContractAddress() {
        return contractAddress;
    }

    public void setContractAddress(String contractAddress) {
        this.contractAddress = contractAddress;
    }

    public String getCumulativeGasUsed() {
        return cumulativeGasUsed;
    }

    public void setCumulativeGasUsed(String cumulativeGasUsed) {
        this.cumulativeGasUsed = cumulativeGasUsed;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getGasUsed() {
        return gasUsed;
    }

    public void setGasUsed(String gasUsed) {
        this.gasUsed = gasUsed;
    }

    public String getLogsBloom() {
        return logsBloom;
    }

    public void setLogsBloom(String logsBloom) {
        this.logsBloom = logsBloom;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public List<ResultReceiptLogs> getLogs() {
        return logs;
    }

    public void setLogs(List<ResultReceiptLogs> logs) {
        this.logs = logs;
    }

    @Override
    public String toString() {
        return "ResultTransactionReceipt{" +
                "blockNumber=" + blockNumber +
                ", blockHash='" + blockHash + '\'' +
                ", transactionHash='" + transactionHash + '\'' +
                ", transactionIndex=" + transactionIndex +
                ", contractAddress='" + contractAddress + '\'' +
                ", cumulativeGasUsed='" + cumulativeGasUsed + '\'' +
                ", from='" + from + '\'' +
                ", gasUsed='" + gasUsed + '\'' +
                ", logsBloom='" + logsBloom + '\'' +
                ", root='" + root + '\'' +
                ", status='" + status + '\'' +
                ", to='" + to + '\'' +
                ", logs=" + logs +
                '}';
    }
}
