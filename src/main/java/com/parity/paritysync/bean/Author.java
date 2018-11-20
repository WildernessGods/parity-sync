package com.parity.paritysync.bean;

public class Author {

    private Long id;

    private String address;

    private Integer type;

    private String balance;

    private Long transactionscount;

    private Long blocks;

    private Long uncles;

    public Author() {
    }

    public Author(String address, Integer type) {
        this.address = address;
        this.type = type;
        this.transactionscount = 0L;
        this.blocks = 0L;
        this.uncles = 0L;
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

    public Long getBlocks() {
        return blocks;
    }

    public void setBlocks(Long blocks) {
        this.blocks = blocks;
    }

    public Long getUncles() {
        return uncles;
    }

    public void setUncles(Long uncles) {
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