package com.parity.paritysync.returntype;

import java.io.Serializable;

public class ReturnTransactions implements Serializable {

    private Long id;

    private String hash;

    private Integer status;

    private Long blocknumber;

    private Long blockConfirmationsCount;

    private String timestamp;

    private String blockfrom;

    private String blockto;

    private String creates;

    private Double transactionvalue;

    private Long gas;

    private Long gasused;

    private Double gasprice;

    private Double fee;

    private String nonce;

    private String blockinput;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getBlocknumber() {
        return blocknumber;
    }

    public void setBlocknumber(Long blocknumber) {
        this.blocknumber = blocknumber;
    }

    public Long getBlockConfirmationsCount() {
        return blockConfirmationsCount;
    }

    public void setBlockConfirmationsCount(Long blockConfirmationsCount) {
        this.blockConfirmationsCount = blockConfirmationsCount;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getBlockfrom() {
        return blockfrom;
    }

    public void setBlockfrom(String blockfrom) {
        this.blockfrom = blockfrom;
    }

    public String getBlockto() {
        return blockto;
    }

    public void setBlockto(String blockto) {
        this.blockto = blockto;
    }

    public String getCreates() {
        return creates;
    }

    public void setCreates(String creates) {
        this.creates = creates;
    }

    public Double getTransactionvalue() {
        return transactionvalue;
    }

    public void setTransactionvalue(Double transactionvalue) {
        this.transactionvalue = transactionvalue;
    }

    public Long getGas() {
        return gas;
    }

    public void setGas(Long gas) {
        this.gas = gas;
    }

    public Long getGasused() {
        return gasused;
    }

    public void setGasused(Long gasused) {
        this.gasused = gasused;
    }

    public Double getGasprice() {
        return gasprice;
    }

    public void setGasprice(Double gasprice) {
        this.gasprice = gasprice;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getBlockinput() {
        return blockinput;
    }

    public void setBlockinput(String blockinput) {
        this.blockinput = blockinput;
    }
}
