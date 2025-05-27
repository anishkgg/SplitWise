package repository;

import model.Transaction;

import java.util.HashMap;

public class TransactionDB {
    HashMap<Integer, Transaction> transactionMap;
    public TransactionDB(){
        this.transactionMap = new HashMap<>();
    }
}