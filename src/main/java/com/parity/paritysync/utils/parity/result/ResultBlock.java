package com.parity.paritysync.utils.parity.result;

import java.util.ArrayList;
import java.util.List;

public class ResultBlock {

    private String number;

    private String hash;

    private String parentHash;

    private String nonce;

    private String sha3Uncles;

    private String logsBloom;

    private String transactionsRoot;

    private String stateRoot;

    private String receiptsRoot;

    private String author;

    private String miner;

    private String difficulty;

    private String totalDifficulty;

    private String extraData;

    private String size;

    private String gasLimit;

    private String gasUsed;

    private String mixHash;

    private List<String> sealFields = new ArrayList<>();

    private List<String> uncles = new ArrayList<>();

    private String timestamp;

    private List<ResultTransactions> transactions = new ArrayList<>();

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getParentHash() {
        return parentHash;
    }

    public void setParentHash(String parentHash) {
        this.parentHash = parentHash;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getSha3Uncles() {
        return sha3Uncles;
    }

    public void setSha3Uncles(String sha3Uncles) {
        this.sha3Uncles = sha3Uncles;
    }

    public String getLogsBloom() {
        return logsBloom;
    }

    public void setLogsBloom(String logsBloom) {
        this.logsBloom = logsBloom;
    }

    public String getTransactionsRoot() {
        return transactionsRoot;
    }

    public void setTransactionsRoot(String transactionsRoot) {
        this.transactionsRoot = transactionsRoot;
    }

    public String getStateRoot() {
        return stateRoot;
    }

    public void setStateRoot(String stateRoot) {
        this.stateRoot = stateRoot;
    }

    public String getReceiptsRoot() {
        return receiptsRoot;
    }

    public void setReceiptsRoot(String receiptsRoot) {
        this.receiptsRoot = receiptsRoot;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMiner() {
        return miner;
    }

    public void setMiner(String miner) {
        this.miner = miner;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getTotalDifficulty() {
        return totalDifficulty;
    }

    public void setTotalDifficulty(String totalDifficulty) {
        this.totalDifficulty = totalDifficulty;
    }

    public String getExtraData() {
        return extraData;
    }

    public void setExtraData(String extraData) {
        this.extraData = extraData;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getGasLimit() {
        return gasLimit;
    }

    public void setGasLimit(String gasLimit) {
        this.gasLimit = gasLimit;
    }

    public String getGasUsed() {
        return gasUsed;
    }

    public void setGasUsed(String gasUsed) {
        this.gasUsed = gasUsed;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public List<ResultTransactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<ResultTransactions> transactions) {
        this.transactions = transactions;
    }

    public String getMixHash() {
        return mixHash;
    }

    public void setMixHash(String mixHash) {
        this.mixHash = mixHash;
    }

    public List<String> getSealFields() {
        return sealFields;
    }

    public void setSealFields(List<String> sealFields) {
        this.sealFields = sealFields;
    }

    public List<String> getUncles() {
        return uncles;
    }

    public void setUncles(List<String> uncles) {
        this.uncles = uncles;
    }
}
