package com.parity.paritysync.bean;

public class TransactionReceipt {

    private Long blocknumber;

    private String blockhash;

    private String transactionhash;

    private Integer transactionindex;

    private String contractaddress;

    private String cumulativegasused;

    private String blockfrom;

    private String gasused;

    private String root;

    private String status;

    private String logsbloom;

    private String blockto;

    public Long getBlocknumber() {
        return blocknumber;
    }

    public void setBlocknumber(Long blocknumber) {
        this.blocknumber = blocknumber;
    }

    public String getBlockhash() {
        return blockhash;
    }

    public void setBlockhash(String blockhash) {
        this.blockhash = blockhash == null ? null : blockhash.trim();
    }

    public String getTransactionhash() {
        return transactionhash;
    }

    public void setTransactionhash(String transactionhash) {
        this.transactionhash = transactionhash == null ? null : transactionhash.trim();
    }

    public Integer getTransactionindex() {
        return transactionindex;
    }

    public void setTransactionindex(Integer transactionindex) {
        this.transactionindex = transactionindex;
    }

    public String getContractaddress() {
        return contractaddress;
    }

    public void setContractaddress(String contractaddress) {
        this.contractaddress = contractaddress == null ? null : contractaddress.trim();
    }

    public String getCumulativegasused() {
        return cumulativegasused;
    }

    public void setCumulativegasused(String cumulativegasused) {
        this.cumulativegasused = cumulativegasused == null ? null : cumulativegasused.trim();
    }

    public String getBlockfrom() {
        return blockfrom;
    }

    public void setBlockfrom(String blockfrom) {
        this.blockfrom = blockfrom == null ? null : blockfrom.trim();
    }

    public String getGasused() {
        return gasused;
    }

    public void setGasused(String gasused) {
        this.gasused = gasused == null ? null : gasused.trim();
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root == null ? null : root.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getLogsbloom() {
        return logsbloom;
    }

    public void setLogsbloom(String logsbloom) {
        this.logsbloom = logsbloom == null ? null : logsbloom.trim();
    }

    public String getBlockto() {
        return blockto;
    }

    public void setBlockto(String blockto) {
        this.blockto = blockto == null ? null : blockto.trim();
    }
}