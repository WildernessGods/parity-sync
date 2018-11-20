package com.parity.paritysync.bean;

import com.parity.paritysync.utils.Utils;
import com.parity.paritysync.utils.parity.result.ResultTransactionReceipt;
import com.parity.paritysync.utils.parity.result.ResultTransactions;

public class TransactionsWithBLOBs extends Transactions {

    private String raw;

    private String blockinput;

    public TransactionsWithBLOBs() {
    }

    public TransactionsWithBLOBs(ResultTransactions resultTransactions, Utils utils, ResultTransactionReceipt receipt, String timestamp) {
        this.setBlockhash(resultTransactions.getBlockHash());
        this.setBlocknumber(Long.valueOf(resultTransactions.getBlockNumber().substring(2), 16));
        this.setBlockfrom(resultTransactions.getFrom());
        this.setHash(resultTransactions.getHash());
        this.setGas(Long.valueOf(resultTransactions.getGas().substring(2), 16));
        this.setGasprice(utils.toDouble(resultTransactions.getGasPrice()) / 1_000_000_000_000_000_000L);
        this.setGasused(Long.valueOf(receipt.getGasUsed().substring(2), 16));
        this.setFee(this.getGasprice() * this.getGasused());
        this.blockinput = resultTransactions.getInput();
        this.setNonce(resultTransactions.getNonce());
        this.setBlockto(resultTransactions.getTo().orElse("null"));
        this.setTransactionindex(resultTransactions.getTransactionIndex());
        this.setTransactionvalue(utils.toDouble(resultTransactions.getValue()) / 1_000_000_000_000_000_000L);
        this.setStatus(receipt.getStatus() != null ? Integer.valueOf(receipt.getStatus().substring(2), 16) : -1);
        this.setV(resultTransactions.getV());
        this.setR(resultTransactions.getR());
        this.setS(resultTransactions.getS());
        this.setChainid(resultTransactions.getChainid());
        this.setBlockcondition(resultTransactions.getCondition());
        this.setCreates(resultTransactions.getCreates().orElse("null"));
        this.setPublickey(resultTransactions.getPublicKey());
        this.raw = resultTransactions.getRaw();
        this.setStandardv(resultTransactions.getStandardV());
        this.setTimestamp(timestamp);
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

    public Author getAuthor() {
        if (this.getBlockto() != null) {
            return new Author(this.getBlockto(), 0);
        } else if (this.getCreates() != null) {
            return new Author(this.getCreates(), 1);
        }
        return null;
    }
}