package com.parity.paritysync.bean;

public class DailyTradingVolume {

    private Integer id;

    private String transactiondate;

    private Integer count;

    public DailyTradingVolume() {
    }

    public DailyTradingVolume(String transactiondate, Integer count) {
        this.transactiondate = transactiondate;
        this.count = count;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTransactiondate() {
        return transactiondate;
    }

    public void setTransactiondate(String transactiondate) {
        this.transactiondate = transactiondate;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}