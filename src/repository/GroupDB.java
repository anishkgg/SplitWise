package repository;

import model.Group;

import java.util.HashMap;

public class GroupDB {
    HashMap<Integer, Group> groupMap;
    public GroupDB(){
        this.groupMap = new HashMap<>();
    }

    public int tellTotalGroups(){
        return this.groupMap.size();
    }

    public void saveGroup(Group group){
        groupMap.put(group.getId(), group);
    }
}