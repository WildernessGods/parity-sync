package com.parity.paritysync.bean;

import com.parity.paritysync.utils.Utils;
import com.parity.paritysync.utils.parity.result.ResultGetBlock;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class BlockUncle {
    private String hash;

    private Long number;

    private String parenthash;

    private String nonce;

    private String mixhash;

    private String sha3uncles;

    private String logsbloom;

    private String transactionsroot;

    private String stateroot;

    private String receiptsroot;

    private String author;

    private String miner;

    private Double difficulty;

    private Double totaldifficulty;

    private String extradata;

    private Integer size;

    private Long gaslimit;

    private Long gasused;

    private String timestamp;

    private String unclebyhash;

    public BlockUncle() {
    }

    public BlockUncle(ResultGetBlock resultGetUncleBlock, String hash, Utils utils) {

        this.number = Long.valueOf(resultGetUncleBlock.getResult().getNumber().substring(2), 16);
        this.hash = resultGetUncleBlock.getResult().getHash();
        this.parenthash = resultGetUncleBlock.getResult().getParentHash();
        this.nonce = resultGetUncleBlock.getResult().getNonce();
        this.mixhash = resultGetUncleBlock.getResult().getMixHash();
        this.sha3uncles = resultGetUncleBlock.getResult().getSha3Uncles();
        this.logsbloom = resultGetUncleBlock.getResult().getLogsBloom();
        this.transactionsroot = resultGetUncleBlock.getResult().getTransactionsRoot();
        this.stateroot = resultGetUncleBlock.getResult().getStateRoot();
        this.receiptsroot = resultGetUncleBlock.getResult().getReceiptsRoot();
        this.author = resultGetUncleBlock.getResult().getAuthor();
        this.miner = resultGetUncleBlock.getResult().getMiner();
        this.difficulty = utils.toDouble(resultGetUncleBlock.getResult().getDifficulty());
        this.totaldifficulty = utils.toDouble(resultGetUncleBlock.getResult().getTotalDifficulty());
        this.extradata = resultGetUncleBlock.getResult().getExtraData();
        this.size = resultGetUncleBlock.getResult().getSize() != null ?
                Integer.valueOf(resultGetUncleBlock.getResult().getSize().substring(2), 16) : 0;
        this.gaslimit = Long.valueOf(resultGetUncleBlock.getResult().getGasLimit().substring(2), 16);
        this.gasused = Long.valueOf(resultGetUncleBlock.getResult().getGasUsed().substring(2), 16);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+0"));
        long ltimestamp = Long.valueOf(resultGetUncleBlock.getResult().getTimestamp().substring(2), 16) * 1000L;
        Date date = new Date(ltimestamp);
        this.timestamp = simpleDateFormat.format(date);
        this.unclebyhash = hash;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash == null ? null : hash.trim();
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
        this.parenthash = parenthash == null ? null : parenthash.trim();
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce == null ? null : nonce.trim();
    }

    public String getMixhash() {
        return mixhash;
    }

    public void setMixhash(String mixhash) {
        this.mixhash = mixhash == null ? null : mixhash.trim();
    }

    public String getSha3uncles() {
        return sha3uncles;
    }

    public void setSha3uncles(String sha3uncles) {
        this.sha3uncles = sha3uncles == null ? null : sha3uncles.trim();
    }

    public String getLogsbloom() {
        return logsbloom;
    }

    public void setLogsbloom(String logsbloom) {
        this.logsbloom = logsbloom == null ? null : logsbloom.trim();
    }

    public String getTransactionsroot() {
        return transactionsroot;
    }

    public void setTransactionsroot(String transactionsroot) {
        this.transactionsroot = transactionsroot == null ? null : transactionsroot.trim();
    }

    public String getStateroot() {
        return stateroot;
    }

    public void setStateroot(String stateroot) {
        this.stateroot = stateroot == null ? null : stateroot.trim();
    }

    public String getReceiptsroot() {
        return receiptsroot;
    }

    public void setReceiptsroot(String receiptsroot) {
        this.receiptsroot = receiptsroot == null ? null : receiptsroot.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getMiner() {
        return miner;
    }

    public void setMiner(String miner) {
        this.miner = miner == null ? null : miner.trim();
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

    public String getExtradata() {
        return extradata;
    }

    public void setExtradata(String extradata) {
        this.extradata = extradata == null ? null : extradata.trim();
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
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
        this.unclebyhash = unclebyhash == null ? null : unclebyhash.trim();
    }

    public Double getSingleUncleReward(Long blockNumber) {

        if (blockNumber <= 4369999) {
            return (double) (this.number + 8 - blockNumber) * 5 / 8;
        } else {
            return (double) (this.number + 8 - blockNumber) * 3 / 8;
        }
    }
}