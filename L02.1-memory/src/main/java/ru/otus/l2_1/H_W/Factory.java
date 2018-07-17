package ru.otus.l2_1.H_W;

import java.util.ArrayList;

@SuppressWarnings({"RedundantStringConstructorCall")
public class Factory {
    public Object createNewTestObject(String objectTypeName) {
        if(objectTypeName.equals("Object"))
            return new Object();
        else if(objectTypeName.equals("EmptyString"))
            return new String("");
        else if(objectTypeName.equals("EmptyArrayList"))
            return new ArrayList();
        else
          return null;
    }

    public static void main(String[] args) {

        Factory newFactory = new Factory();

        System.out.println("Object type object:"
                + newFactory.createNewTestObject("Object").toString());

        System.out.println("String type empty object:"
                + newFactory.createNewTestObject("EmptySting").toString());

        System.out.println("ArrayList empty container object:"
                + newFactory.createNewTestObject("EmptyArrayList").toString());
    }
}
