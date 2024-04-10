import org.example.Humans.*;
import org.example.Pets.Dog;
import org.example.Pets.DomesticCat;
import org.example.Pets.Pet;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test {


    // Создаем экземпляр CollectionFamilyDao
    CollectionFamilyDao collectionFamilyDao = new CollectionFamilyDao();

    // Создаем экземпляр FamilyService, передавая ему CollectionFamilyDao
    FamilyService familyService = new FamilyService(collectionFamilyDao);
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

    List<Human> children2 = new ArrayList<>();
    Family family1 = new Family(mother1,father1);
    Family family2 = new Family(mother2,father2);


    @org.junit.Test
    public void getFamiliesBiggerThan(){
        collectionFamilyDao.saveFamily(family2);
        collectionFamilyDao.saveFamily(family1);
        collectionFamilyDao.addPet(0,pet1);
        assertEquals(1, familyService.getFamiliesBiggerThan(2).size());
    }
    @org.junit.Test
    public void getFamiliesLessThan(){
        collectionFamilyDao.saveFamily(family2);
        collectionFamilyDao.saveFamily(family1);
        collectionFamilyDao.addPet(0,pet1);
        assertEquals(1, familyService.getFamiliesLessThan(3).size());
    }
    @org.junit.Test
    public void countFamiliesWithMemberNumber(){
        collectionFamilyDao.saveFamily(family2);
        collectionFamilyDao.saveFamily(family1);
        collectionFamilyDao.createNewFamily(mother,father);
        collectionFamilyDao.addPet(0,pet1);
        collectionFamilyDao.addPet(1,pet2);
        assertEquals(2, familyService.countFamiliesWithMemberNumber(3));
    }
    @org.junit.Test
    public void deleteAllChildrenOlderThen (){
        collectionFamilyDao.saveFamily(family2);
        collectionFamilyDao.saveFamily(family1);
        collectionFamilyDao.createNewFamily(mother,father);
        collectionFamilyDao.addPet(0,pet1);
        familyService.adoptChild(familyService.getFamilyById(0),child);
        familyService.adoptChild(familyService.getFamilyById(1),child1);
        familyService.adoptChild(familyService.getFamilyById(2),child2);
        familyService.deleteAllChildrenOlderThen(11);
        int countMemberInFamily = 0 ;
        for(Family family : familyService.getAllFamilies()){
            countMemberInFamily += family.countFamily();
        }
        assertEquals(9 , countMemberInFamily);
    }
}
