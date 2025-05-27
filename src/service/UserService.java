package service;

import repository.UserDB;

public class UserService {
    UserDB userDB;

    public UserService(){
        this.userDB = new UserDB();
    }
}