package service;

import repository.TransactionDB;

import java.util.HashMap;

public class TransactionService {
    TransactionDB transactionDB;
    public TransactionService(){
        this.transactionDB = new TransactionDB();
    }

}