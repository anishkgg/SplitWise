package repository;

import model.User;

import java.util.HashMap;

public class UserDB {
    HashMap<Integer, User> userMap;
    public UserDB(){
        this.userMap = new HashMap<>();
    }
}