package com.parity.paritysync.bean;

import com.parity.paritysync.utils.Utils;
import com.parity.paritysync.utils.parity.result.ResultGetBlock;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Block {
    private Long number;

    private String hash;

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

    private String difficulty;

    private String totaldifficulty;

    private String extradata;

    private Integer size;

    private Long gaslimit;

    private Long gasused;

    private String timestamp;

    private Integer transactionscount;

    private Integer contracttransactionscount;

    private Integer totaltransactionscount;

    private Integer unclecount;

    private Double avggasprice;

    private Double blockreward;

    private Double unclesreward;

    public Block() {
    }

    public Block(Long blockNumber, Double blockReward, Integer uncleCount, Double avgGasPrice) {
        this.number = blockNumber;

        if (blockNumber <= 4369999) {
            this.blockreward = 5 + blockReward + uncleCount * ((double) 5 / 32);
        } else {
            this.blockreward = 3 + blockReward + uncleCount * ((double) 3 / 32);
        }
        DecimalFormat decimalFormat = new DecimalFormat("0000000.000");
//        this.avggasprice = Double.valueOf(decimalFormat.format(avgGasPrice));
    }

    public Block(Long blockNumber, Double unclesReward) {
        this.number = blockNumber;
        this.unclesreward = unclesReward;
    }

    public Block(ResultGetBlock resultGetBlock, Utils utils) {
        this.number = Long.valueOf(resultGetBlock.getResult().getNumber().substring(2), 16);
        this.hash = resultGetBlock.getResult().getHash();
        this.parenthash = resultGetBlock.getResult().getParentHash();
        this.nonce = resultGetBlock.getResult().getNonce();
        this.mixhash = resultGetBlock.getResult().getMixHash();
        this.sha3uncles = resultGetBlock.getResult().getSha3Uncles();
        this.logsbloom = resultGetBlock.getResult().getLogsBloom();
        this.transactionsroot = resultGetBlock.getResult().getTransactionsRoot();
        this.stateroot = resultGetBlock.getResult().getStateRoot();
        this.receiptsroot = resultGetBlock.getResult().getReceiptsRoot();
        this.author = resultGetBlock.getResult().getAuthor();
        this.miner = resultGetBlock.getResult().getMiner();
        this.difficulty = utils.toString(resultGetBlock.getResult().getDifficulty());
        this.totaldifficulty = utils.toString(resultGetBlock.getResult().getTotalDifficulty());
        this.extradata = resultGetBlock.getResult().getExtraData();
        this.size = Integer.valueOf(resultGetBlock.getResult().getSize().substring(2), 16);
        this.gaslimit = Long.valueOf(resultGetBlock.getResult().getGasLimit().substring(2), 16);
        this.gasused = Long.valueOf(resultGetBlock.getResult().getGasUsed().substring(2), 16);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+0"));
        long ltimestamp = Long.valueOf(resultGetBlock.getResult().getTimestamp().substring(2), 16) * 1000L;
        Date date = new Date(ltimestamp);
        this.timestamp = simpleDateFormat.format(date);

        this.totaltransactionscount = resultGetBlock.getResult().getTransactions().size();
        this.unclecount = resultGetBlock.getResult().getUncles().size();
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash == null ? null : hash.trim();
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

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getTotaldifficulty() {
        return totaldifficulty;
    }

    public void setTotaldifficulty(String totaldifficulty) {
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

    public Integer getTotaltransactionscount() {
        return totaltransactionscount;
    }

    public void setTotaltransactionscount(Integer totaltransactionscount) {
        this.totaltransactionscount = totaltransactionscount;
    }

    public Integer getUnclecount() {
        return unclecount;
    }

    public void setUnclecount(Integer unclecount) {
        this.unclecount = unclecount;
    }

    public Double getAvggasprice() {
        return avggasprice;
    }

    public void setAvggasprice(Double avggasprice) {
        this.avggasprice = avggasprice;
    }

    public Double getBlockreward() {
        return blockreward;
    }

    public void setBlockreward(Double blockreward) {
        this.blockreward = blockreward;
    }

    public Double getUnclesreward() {
        return unclesreward;
    }

    public void setUnclesreward(Double unclesreward) {
        this.unclesreward = unclesreward;
    }
}