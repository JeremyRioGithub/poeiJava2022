package org.example;

import java.util.ArrayList;

public class Pile<Type> {
    public void empiler(ArrayList<Type> tableau, Type object){
        tableau.add(object);
    }
    public void depiler(ArrayList<Type> tableau){
        tableau.remove(tableau.size());
    }
    public Type recuperer(ArrayList<Type> tableau, int id){
        return tableau.get(id);
    }
    public void main(String[] args) {
        ArrayList<Type> tableau = new ArrayList<Type>();
    }
}
