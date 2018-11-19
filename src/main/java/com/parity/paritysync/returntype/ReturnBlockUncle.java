package com.parity.paritysync.returntype;

import java.io.Serializable;

public class ReturnBlockUncle implements Serializable {

    private String hash;

    private Long number;

    private String parenthash;

    private Integer position;

    private String sha3uncles;

    private String author;

    private String miner;

    private String difficulty;

    private Long gaslimit;

    private Long gasused;

    private String timestamp;

    private String unclebyhash;

    private Double unclereward;

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getParenthash() {
        return parenthash;
    }

    public void setParenthash(String parenthash) {
        this.parenthash = parenthash;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
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

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public Long getGaslimit() {
        return gaslimit;
    }

    public void setGaslimit(Long gaslimit) {
        this.gaslimit = gaslimit;
    }

    public Long getGasused() {
        return gasused;
    }

    public void setGasused(Long gasused) {
        this.gasused = gasused;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getUnclebyhash() {
        return unclebyhash;
    }

    public void setUnclebyhash(String unclebyhash) {
        this.unclebyhash = unclebyhash;
    }

    public Double getUnclereward() {
        return unclereward;
    }

    public void setUnclereward(Double unclereward) {
        this.unclereward = unclereward;
    }
}
