package org.example;


import org.example.Humans.*;
import org.example.Pets.Dog;
import org.example.Pets.DomesticCat;
import org.example.Pets.Pet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Woman mother = new Woman("Anya","Tereshenko",33 );
        Man father = new Man("Vlad","Tereshenko",31);
        Woman mother1 = new Woman("Ylia","Rytchenko",22 );
        Man father1 = new Man("Anton","Rytchenko",21);
        Woman mother2 = new Woman("Lena","Lykash",23 );
        Man father2 = new Man("Maks","Lykash",26);

        Woman child = new Woman("Anya","Tereshenko",10 );
        Man child1 = new Man("Timur","Rytchenko",11);
        Man child2 = new Man("Timur","Rytchenko",12);
        Man child3 = new Man("Timur","Rytchenko",13);

        Pet pet1 = new Dog("sharik");
        Pet pet2 = new Dog("Gav");
        Pet pet3 = new DomesticCat("Meow");
        Set<Pet> pet11 = new HashSet<>();
        pet11.add(pet1);
        Set<Pet> pet12 = new HashSet<>();
        pet12.add(pet2);
        pet12.add(pet3);
        List<Human> children = new ArrayList<>();
        children.add(child1);

        List<Human> children2 = new ArrayList<>();
        children.add(child2);
        children.add(child3);
        Family family1 = new Family(mother1,father1 );
        Family family2 = new Family(mother2,father,pet12,children2);
        // Создаем экземпляр CollectionFamilyDao
        CollectionFamilyDao collectionFamilyDao = new CollectionFamilyDao();

        // Создаем экземпляр FamilyService, передавая ему CollectionFamilyDao
        FamilyService familyService = new FamilyService(collectionFamilyDao);

        // Создаем экземпляр FamilyController, которому передаем FamilyService

        FamilyController familyController = new FamilyController(familyService);
        collectionFamilyDao.saveFamily(family1);
        collectionFamilyDao.saveFamily(family2);
//
//        familyController.createNewFamily(mother,father);
//        familyController.getFamilyByIndex(0);
//        familyController.getAllFamilies();
//        familyController.displayAllFamilies();
//        familyController.getFamiliesBiggerThan(2);
//        familyController.getFamiliesLessThan(3);
//        familyController.countFamiliesWithMemberNumber(2);
//        familyController.getFamilyByIndex(0);
//        familyController.bornChild(family1,"Yaroslav","Olya");
//        Man child4 = new Man("Vadim","Rytchenko",15);
//        familyController.adoptChild(family2,child4);
//        familyController.deleteAllChildrenOlderThan(14);
//        familyController.count();
//        familyController.getFamilyById(1);
//        familyController.getPets(2);
//        Pet pet4 = new DomesticCat("Myra");
//        familyController.addPet(2,pet4);
//        familyController.deleteFamilyByIndex(1);
//
//        Human adoptchild = new Human("Egor" , "Rythenko" , "20/03/2016" , 12);
//        System.out.println(adoptchild);
//
        familyService.displayAllFamilies();

        System.out.println(familyService.getFamiliesBiggerThan(2));
    }
}