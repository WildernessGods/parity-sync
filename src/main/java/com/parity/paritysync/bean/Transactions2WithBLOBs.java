package com.parity.paritysync.bean;

public class Transactions2WithBLOBs extends Transactions2 {
    private String raw;

    private String blockinput;

    public Transactions2WithBLOBs() {
    }

    public Transactions2WithBLOBs(TransactionsWithBLOBs transactionsWithBLOBs, Long blockFromId, Long blockToId, Long blockCreatesId) {
        this.setId(transactionsWithBLOBs.getId());
        this.setBlockhash(transactionsWithBLOBs.getBlockhash());
        this.setBlocknumber(transactionsWithBLOBs.getBlocknumber());
        this.setBlockfrom(blockFromId);
        this.setHash(transactionsWithBLOBs.getHash());
        this.setGas(transactionsWithBLOBs.getGas());
        this.setGasprice(transactionsWithBLOBs.getGasprice());
        this.setGasused(transactionsWithBLOBs.getGasused());
        this.setFee(transactionsWithBLOBs.getFee());
        this.blockinput = transactionsWithBLOBs.getBlockinput();
        this.setNonce(transactionsWithBLOBs.getNonce());
        this.setBlockto(blockToId);
        this.setTransactionindex(transactionsWithBLOBs.getTransactionindex());
        this.setTransactionvalue(transactionsWithBLOBs.getTransactionvalue());
        this.setStatus(transactionsWithBLOBs.getStatus());
        this.setV(transactionsWithBLOBs.getV());
        this.setR(transactionsWithBLOBs.getR());
        this.setS(transactionsWithBLOBs.getS());
        this.setChainid(transactionsWithBLOBs.getChainid());
        this.setBlockcondition(transactionsWithBLOBs.getBlockcondition());
        this.setCreates(blockCreatesId);
        this.setPublickey(transactionsWithBLOBs.getPublickey());
        this.raw = transactionsWithBLOBs.getRaw();
        this.setStandardv(transactionsWithBLOBs.getStandardv());
        this.setTimestamp(transactionsWithBLOBs.getTimestamp());
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw == null ? null : raw.trim();
    }

    public String getBlockinput() {
        return blockinput;
    }

    public void setBlockinput(String blockinput) {
        this.blockinput = blockinput == null ? null : blockinput.trim();
    }
}