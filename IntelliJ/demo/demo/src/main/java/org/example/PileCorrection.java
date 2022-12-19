package org.example;

import java.lang.reflect.Array;

public class PileCorrection<Type> {
    private Type[] elements;
    private int compteur;
    public PileCorrection(Class<Type[]> clazz, int taille){
        elements = clazz.cast(Array.newInstance(clazz.getComponentType(), taille));
        compteur = 0;
    }

    public boolean Empiler(Type element) {
        if (compteur < elements.length){
            elements[++compteur] = element;
            return true;
        }
        return false;
    }

    public boolean Depiler(){
        if (compteur >0){
            elements[--compteur] = null;
            return true;
        }
        return false;
    }

    public Type GetElement(int id) throws Exception {
        if (id > 0 && id<elements.length && elements[id] != null){
            return elements[id];
        }
        throw new Exception("Not found");
    }
}
