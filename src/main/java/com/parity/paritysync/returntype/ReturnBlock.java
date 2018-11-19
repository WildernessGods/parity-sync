package com.parity.paritysync.returntype;

import java.io.Serializable;

public class ReturnBlock implements Serializable {

    private Long number;

    private String timestamp;

    private Integer transactionscount;

    private Integer contracttransactionscount;

    private String hash;

    private String parenthash;

    private String sha3uncles;

    private String author;

    private String miner;

    private Double difficulty;

    private Double totaldifficulty;

    private Integer size;

    private Long gasused;

    private Long gaslimit;

    private String nonce;

    private Double avggasprice;

    private Double blockReward;

    private Double unclesReward;

    private String extradata;

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getTransactionscount() {
        return transactionscount;
    }

    public void setTransactionscount(Integer transactionscount) {
        this.transactionscount = transactionscount;
    }

    public Integer getContracttransactionscount() {
        return contracttransactionscount;
    }

    public void setContracttransactionscount(Integer contracttransactionscount) {
        this.contracttransactionscount = contracttransactionscount;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getParenthash() {
        return parenthash;
    }

    public void setParenthash(String parenthash) {
        this.parenthash = parenthash;
    }

    public String getSha3uncles() {
        return sha3uncles;
    }

    public void setSha3uncles(String sha3uncles) {
        this.sha3uncles = sha3uncles;
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

    public Double getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Double difficulty) {
        this.difficulty = difficulty;
    }

    public Double getTotaldifficulty() {
        return totaldifficulty;
    }

    public void setTotaldifficulty(Double totaldifficulty) {
        this.totaldifficulty = totaldifficulty;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Long getGasused() {
        return gasused;
    }

    public void setGasused(Long gasused) {
        this.gasused = gasused;
    }

    public Long getGaslimit() {
        return gaslimit;
    }

    public void setGaslimit(Long gaslimit) {
        this.gaslimit = gaslimit;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public Double getAvggasprice() {
        return avggasprice;
    }

    public void setAvggasprice(Double avggasprice) {
        this.avggasprice = avggasprice;
    }

    public Double getBlockReward() {
        return blockReward;
    }

    public void setBlockReward(Double blockReward) {
        this.blockReward = blockReward;
    }

    public Double getUnclesReward() {
        return unclesReward;
    }

    public void setUnclesReward(Double unclesReward) {
        this.unclesReward = unclesReward;
    }

    public String getExtradata() {
        return extradata;
    }

    public void setExtradata(String extradata) {
        this.extradata = extradata;
    }
}
