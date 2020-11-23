package com.example.tallerlistview;

import java.util.ArrayList;

public class Data {

    private static ArrayList<Operations> ops_list = new ArrayList();
    private static ArrayList<Operation> operations = new ArrayList();

    public static void saveData(Operation o){

        operations.add(o);
    }
    public static void saveData(Operations o){
        ops_list.add(o);
    }
    public static ArrayList<Operations> getOperationsList(){
        return ops_list;

    }
    public static ArrayList<Operation> getOperationList(){
        return operations;
    }
}
