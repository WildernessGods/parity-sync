package com.parity.paritysync.returntype;

import java.io.Serializable;
import java.util.Objects;

public class ReturnTransactionsRelationShip implements Serializable {

    private String blockfrom;

    private String blockto;

    private String creates;

    private Double transactionvalue;

    public ReturnTransactionsRelationShip() {
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

    public ReturnTransactionsRelationShip self() {
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ReturnTransactionsRelationShip that = (ReturnTransactionsRelationShip) o;
        return Objects.equals(blockfrom, that.blockfrom) &&
                Objects.equals(blockto, that.blockto) &&
                Objects.equals(creates, that.creates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blockfrom, blockto, creates);
    }
}
