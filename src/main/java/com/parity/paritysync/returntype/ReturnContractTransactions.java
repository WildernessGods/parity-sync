package com.parity.paritysync.returntype;

public class ReturnContractTransactions {

    private Long id;

    private String hash;

    private Integer status;

    private Long blocknumber;

    private String timestamp;

    private String blockfrom;

    private String creates;

    private Double transactionvalue;

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
}
