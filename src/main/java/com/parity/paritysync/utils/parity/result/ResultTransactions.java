package com.parity.paritysync.utils.parity.result;

import com.parity.paritysync.bean.TransactionsWithBLOBs;
import com.parity.paritysync.utils.Utils;
import com.parity.paritysync.utils.parity.ParityRequest;

import java.io.IOException;
import java.util.Optional;

public class ResultTransactions {

    private String blockHash;

    private String blockNumber;

    private String from;

    private String gas;

    private String gasPrice;

    private String hash;

    private String input;

    private String nonce;

    private String to;

    private String transactionIndex;

    private String value;

    private String v;

    private String r;

    private String s;

    private String chainid;

    private String condition;

    private String creates;

    private String publicKey;

    private String raw;

    private String standardV;

    private String chainId;

    public String getBlockHash() {
        return blockHash;
    }

    public void setBlockHash(String blockHash) {
        this.blockHash = blockHash;
    }

    public String getBlockNumber() {
        return blockNumber;
    }

    public void setBlockNumber(String blockNumber) {
        this.blockNumber = blockNumber;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getGas() {
        return gas;
    }

    public void setGas(String gas) {
        this.gas = gas;
    }

    public String getGasPrice() {
        return gasPrice;
    }

    public void setGasPrice(String gasPrice) {
        this.gasPrice = gasPrice;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public Optional<String> getTo() {
        return Optional.ofNullable(to);
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTransactionIndex() {
        return transactionIndex;
    }

    public void setTransactionIndex(String transactionIndex) {
        this.transactionIndex = transactionIndex;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String getChainid() {
        return chainid;
    }

    public void setChainid(String chainid) {
        this.chainid = chainid;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Optional<String> getCreates() {
        return Optional.ofNullable(creates);
    }

    public void setCreates(String creates) {
        this.creates = creates;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public String getStandardV() {
        return standardV;
    }

    public void setStandardV(String standardV) {
        this.standardV = standardV;
    }

    public String getChainId() {
        return chainId;
    }

    public void setChainId(String chainId) {
        this.chainId = chainId;
    }

    public TransactionsWithBLOBs getTransactionsWithBLOBs(Utils utils, String timestamp) {
        try {
            ResultGetTransactionReceipt resultGetTransactionReceipt = ParityRequest.eth_getTransactionReceipt(this.getHash());
            return resultGetTransactionReceipt.getResult().map(result -> new TransactionsWithBLOBs(this, utils, result, timestamp)).orElse(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
