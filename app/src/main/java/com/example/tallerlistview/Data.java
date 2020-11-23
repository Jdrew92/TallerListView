package com.example.tallerlistview;

import java.util.ArrayList;

public class Data {

    private static ArrayList<Operation> operations = new ArrayList();

    public static void saveData(Operation o){
        operations.add(o);
    }

    public static ArrayList<Operation> getOperationsList(){
        return operations;
    }
}
