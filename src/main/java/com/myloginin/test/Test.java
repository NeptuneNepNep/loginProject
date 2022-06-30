package com.myloginin.test;

import com.myloginin.entity.User;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
       List<User> l = GetUsersList();
       System.out.println(l);


    }
    public static List<User> GetUsersList(){
        List<User>  list= new ArrayList<>();
        list.add(new User(1,"1","1",1));
        return list;
    }
}
