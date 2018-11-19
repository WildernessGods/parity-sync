package com.parity.paritysync.bean;

public class Author {

    private Long id;

    private String address;

    private Integer type;

    private String balance;

    private Long transactionscount;

    private Integer blocks;

    private Integer uncles;

    public Author() {
    }

    public Author(String address, Integer type) {
        this.address = address;
        this.type = type;
        this.transactionscount = 0L;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance == null ? null : balance.trim();
    }

    public Long getTransactionscount() {
        return transactionscount;
    }

    public void setTransactionscount(Long transactionscount) {
        this.transactionscount = transactionscount;
    }

    public Integer getBlocks() {
        return blocks;
    }

    public void setBlocks(Integer blocks) {
        this.blocks = blocks;
    }

    public Integer getUncles() {
        return uncles;
    }

    public void setUncles(Integer uncles) {
        this.uncles = uncles;
    }

    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass()) {
            return false;
        }

        Author author = (Author) obj;

        if (this.address != null && author.address != null) {
            return this.address.equals(author.address);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return this.address.hashCode();
    }
}