package service;

import model.Group;
import repository.GroupDB;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class GroupService {
    GroupDB groupDB;

    public GroupService(){
        this.groupDB = new GroupDB();
    }

    public Group createGroup(Scanner scn){
        System.out.println("How many users you want to add in this group !!");
        int totalUser = scn.nextInt();
        HashSet<Integer> userIds = new HashSet<>();
        for(int i  = 0; i < totalUser; i++){
            System.out.println(String.format("Enter id of %d user", i));
            int userId = scn.nextInt();
            userIds.add(userId);
        }

        Group group = new Group();
        int id = groupDB.tellTotalGroups() + 1;
        group.setId(id);
        group.setUsers(userIds);
        group.setTransactions(new ArrayList<>());

        groupDB.saveGroup(group);

        return group;

    }
}