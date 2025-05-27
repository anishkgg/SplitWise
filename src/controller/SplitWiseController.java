package controller;

import repository.GroupDB;
import service.GroupService;
import service.TransactionService;
import service.UserService;

import java.util.Scanner;

public class SplitWiseController {

    Scanner scn;
    UserService userService;
    TransactionService transactionService;
    GroupService groupService;
    public SplitWiseController(){
        this.scn = new Scanner(System.in);
        this.groupService = new GroupService();
        this.transactionService = new TransactionService();
        this.userService = new UserService();
    }


    public void startProgram(){
        while(true){
            System.out.println("Hey What you want to do ? Select below options");
            System.out.println(
                    "1. create-group\n" +
                            "2. Do transaction in a group\n" +
                            "3. create user\n" +
                            "4. Show which users owes how much amount in the group and whom he owes");
            int opt = scn.nextInt();
            if(opt == 1){
                System.out.println("User selected opt 1 i.e. group");
                groupService.createGroup(scn);
                System.out.println("Group created successfully");
            }else if(opt == 2){

            }else if(opt == 3){

            }else if(opt == 4){

            }else{
                System.out.println("Wrong option entered. Enter value again");
                continue;
            }

            System.out.println("Are you satisfied?(Yes/No)");
        }
    }
}