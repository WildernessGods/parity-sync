package com.parity.paritysync.bean;

import com.parity.paritysync.utils.Utils;
import com.parity.paritysync.utils.parity.result.ResultBlock;
import com.parity.paritysync.utils.parity.result.ResultGetBlock;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class BlockUncle {
    private String hash;

    private Long number;

    private String parenthash;

    private Integer position;

    private String nonce;

    private String mixhash;

    private String sha3uncles;

    private String logsbloom;

    private String transactionsroot;

    private String stateroot;

    private String receiptsroot;

    private String author;

    private String miner;

    private String difficulty;

    private String totaldifficulty;

    private String extradata;

    private Integer size;

    private Long gaslimit;

    private Long gasused;

    private String timestamp;

    private Long unclebynumber;

    private String unclebyhash;

    private Double unclereward;

    public BlockUncle() {
    }

    public BlockUncle(ResultBlock resultBlock, Integer position, String blockHash, Long blockNumber, Utils utils) {

        this.number = Long.valueOf(resultBlock.getNumber().substring(2), 16);
        this.hash = resultBlock.getHash();
        this.parenthash = resultBlock.getParentHash();
        this.position = position;
        this.nonce = resultBlock.getNonce();
        this.mixhash = resultBlock.getMixHash();
        this.sha3uncles = resultBlock.getSha3Uncles();
        this.logsbloom = resultBlock.getLogsBloom();
        this.transactionsroot = resultBlock.getTransactionsRoot();
        this.stateroot = resultBlock.getStateRoot();
        this.receiptsroot = resultBlock.getReceiptsRoot();
        this.author = resultBlock.getAuthor();
        this.miner = resultBlock.getMiner();
        this.difficulty = utils.toString(resultBlock.getDifficulty());
        this.totaldifficulty = utils.toString(resultBlock.getTotalDifficulty());
        this.extradata = resultBlock.getExtraData();
        this.size = resultBlock.getSize() != null ?
                Integer.valueOf(resultBlock.getSize().substring(2), 16) : 0;
        this.gaslimit = Long.valueOf(resultBlock.getGasLimit().substring(2), 16);
        this.gasused = Long.valueOf(resultBlock.getGasUsed().substring(2), 16);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+0"));
        long ltimestamp = Long.valueOf(resultBlock.getTimestamp().substring(2), 16) * 1000L;
        Date date = new Date(ltimestamp);
        this.timestamp = simpleDateFormat.format(date);
        this.unclebynumber = blockNumber;
        this.unclebyhash = blockHash;
        this.unclereward = getSingleUncleReward(blockNumber);
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

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
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

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty == null ? null : difficulty.trim();
    }

    public String getTotaldifficulty() {
        return totaldifficulty;
    }

    public void setTotaldifficulty(String totaldifficulty) {
        this.totaldifficulty = totaldifficulty == null ? null : totaldifficulty.trim();
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

    public Long getUnclebynumber() {
        return unclebynumber;
    }

    public void setUnclebynumber(Long unclebynumber) {
        this.unclebynumber = unclebynumber;
    }

    public String getUnclebyhash() {
        return unclebyhash;
    }

    public void setUnclebyhash(String unclebyhash) {
        this.unclebyhash = unclebyhash == null ? null : unclebyhash.trim();
    }

    public Double getUnclereward() {
        return unclereward;
    }

    public void setUnclereward(Double unclereward) {
        this.unclereward = unclereward;
    }

    public Double getSingleUncleReward(Long blockNumber) {

        if (blockNumber <= 4369999) {
            return (double) (this.number + 8 - blockNumber) * 5 / 8;
        } else {
            return (double) (this.number + 8 - blockNumber) * 3 / 8;
        }
    }
}