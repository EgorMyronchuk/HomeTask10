package org.example.Humans;

import org.example.Pets.Pet;

import java.util.Map;

public final class Woman extends Human{
    public Woman(String name, String surname, int year) {
        super(name , surname , year);
    }

    public Woman(String name, String surname, int year, int iq) {
        super(name , surname , year , iq);
    }

    public Woman(String name, String surname, int year, int iq, Map<String,String> schedule) {
        super(name , surname , year , iq , schedule);
    }
    @Override
    public void greetPet() {
        for (Pet pets : getFamily().getPet()) System.out.printf("Іди сюди чудо моє ,як ти  %s \n", pets.getNickname());
    }
    public void makeup (){
        System.out.println("Почекай мені треба зробити makeup");
    }
}
