package org.example.Humans;

import org.example.Pets.Pet;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionFamilyDao implements FamilyDao{
    private final List<Family> dataBase = new ArrayList<>();

    @Override
    public List<Family> getAllFamilies() {
        return dataBase;
    }

    @Override
    public Family getFamilyByIndex(int familyIndex) {
        if(dataBase.get(familyIndex) != null){
            dataBase.remove(dataBase.get(familyIndex));
            return dataBase.get(familyIndex);
        }
        return null;
    }

    @Override
    public boolean deleteFamily(int familyIndex) {
        if (familyIndex >= 0 && familyIndex < dataBase.size()) {
            dataBase.remove(familyIndex);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteFamily(Family family) {
        return dataBase.remove(family);
    }

    @Override
    public void saveFamily(Family family) {
        if(dataBase.contains(family)){
            dataBase.set(dataBase.indexOf(family) ,family);
        }
        else {
            dataBase.add(family);
        }

    }

    @Override
    public void displayAllFamilies() {
        System.out.println(dataBase.stream()
                .map(Object::toString)
                .collect(Collectors.joining("\n")));
    }

    @Override
    public List<Family> getFamiliesBiggerThan(int numberOfMember) {
       return dataBase.stream()
                .filter(x -> x.countFamily() > numberOfMember)
                .collect(Collectors.toList());
    }

    @Override
    public List<Family> getFamiliesLessThan(int numberOfMember) {
        return dataBase.stream()
                .filter(x -> x.countFamily() < numberOfMember)
                .collect(Collectors.toList());
    }

    @Override
    public int countFamiliesWithMemberNumber(int numberOfMember) {
        return dataBase.stream()
                .filter(x -> x.countFamily() == numberOfMember)
                .mapToInt(x -> 1)
                .sum();
    }

    @Override
    public void createNewFamily(Woman mother, Man father) {
        Family familyResult = new Family(mother,father);
        saveFamily(familyResult);
    }

    @Override
    public Family bornChild(Family family, String maleName, String femaleName) {
        Random random = new Random();
        Human children ;
        if( random.nextDouble() > 0.5){
            children = new Man(maleName , family.getFather().getSurname() , 0 );
        }
        else {
            children = new Woman(femaleName , family.getFather().getSurname() , 0 );
        }
        family.setChildren(children);
        saveFamily(family);
        return family;
    }

    @Override
    public Family adoptChild(Family family, Human child) {
        family.setChildren(child);
        saveFamily(family);
        return family;
    }

        @Override
        public void deleteAllChildrenOlderThen(int olderThenAge) {
            getAllFamilies().forEach(family -> {
                 List<Human> childrenToRemove = family.getChildren()
                        .stream()
                        .filter(child -> child.getYear() > olderThenAge)
                        .toList();

                childrenToRemove.forEach(family::deleteChild);
                saveFamily(family);
            });
        };
    @Override
    public int count() {
        return dataBase.size();
    }

    @Override
    public Family getFamilyById(int familyIndex) {
        return dataBase.get(familyIndex);
    }

    @Override
    public Set<Pet> getPets(int familyIndex) {

        if ( dataBase.get(familyIndex).getPet().isEmpty()){
            return null;
        }
        else {
               return dataBase.get(familyIndex).getPet();
        }
    }

    @Override
    public void addPet(int familyIndex, Pet pet) {
        dataBase.get(familyIndex).setPet(pet);
    }
}
