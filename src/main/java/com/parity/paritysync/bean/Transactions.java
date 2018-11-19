package com.parity.paritysync.bean;

public class Transactions {

    private Long id;

    private String blockhash;

    private Long blocknumber;

    private String blockfrom;

    private String hash;

    private Long gas;

    private Long gasused;

    private Double gasprice;

    private Double fee;

    private Double transactionvalue;

    private Integer status;

    private String blockto;

    private String transactionindex;

    private String nonce;

    private String v;

    private String r;

    private String s;

    private String chainid;

    private String blockcondition;

    private String creates;

    private String publickey;

    private String standardv;

    private String timestamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBlockhash() {
        return blockhash;
    }

    public void setBlockhash(String blockhash) {
        this.blockhash = blockhash == null ? null : blockhash.trim();
    }

    public Long getBlocknumber() {
        return blocknumber;
    }

    public void setBlocknumber(Long blocknumber) {
        this.blocknumber = blocknumber;
    }

    public String getBlockfrom() {
        return blockfrom;
    }

    public void setBlockfrom(String blockfrom) {
        this.blockfrom = blockfrom == null ? null : blockfrom.trim();
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash == null ? null : hash.trim();
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

    public Double getTransactionvalue() {
        return transactionvalue;
    }

    public void setTransactionvalue(Double transactionvalue) {
        this.transactionvalue = transactionvalue;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getBlockto() {
        return blockto;
    }

    public void setBlockto(String blockto) {
        this.blockto = blockto == null ? null : blockto.trim();
    }

    public String getTransactionindex() {
        return transactionindex;
    }

    public void setTransactionindex(String transactionindex) {
        this.transactionindex = transactionindex == null ? null : transactionindex.trim();
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce == null ? null : nonce.trim();
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v == null ? null : v.trim();
    }

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r == null ? null : r.trim();
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s == null ? null : s.trim();
    }

    public String getChainid() {
        return chainid;
    }

    public void setChainid(String chainid) {
        this.chainid = chainid == null ? null : chainid.trim();
    }

    public String getBlockcondition() {
        return blockcondition;
    }

    public void setBlockcondition(String blockcondition) {
        this.blockcondition = blockcondition == null ? null : blockcondition.trim();
    }

    public String getCreates() {
        return creates;
    }

    public void setCreates(String creates) {
        this.creates = creates == null ? null : creates.trim();
    }

    public String getPublickey() {
        return publickey;
    }

    public void setPublickey(String publickey) {
        this.publickey = publickey == null ? null : publickey.trim();
    }

    public String getStandardv() {
        return standardv;
    }

    public void setStandardv(String standardv) {
        this.standardv = standardv == null ? null : standardv.trim();
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}