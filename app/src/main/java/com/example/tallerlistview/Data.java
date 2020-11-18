package com.example.tallerlistview;

import java.util.ArrayList;

public class Data {

    private static ArrayList<Operations> ops_list = new ArrayList();

    public static void saveData(Operations o){
        ops_list.add(o);
    }
    public static ArrayList<Operations> getOperationsList(){
        return ops_list;
    }
}
