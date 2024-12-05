package com.example.lab_3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CollectionAddressBook implements AddressBook {

    private ObservableList<Person> personList = FXCollections.observableArrayList();

    @Override
    public void add(Person person) {
        personList.add(person);
    }

    @Override
    public void update(Person person) {

    }

    @Override
    public void delete(Person person) {
        personList.remove(person);
    }

//    public void print(){
//        int number = 0;
//        System.out.println();
//        for(Person person: personList){
//            number++;
//            System.out.println(number+") ПІП: "+person.getPIP()+"; Телефон: "+person.getPHONE());
//        }
//
//    }

//    public void fillTestData(){
//        personList.add(new Person("Alan", "0991132332"));
//        personList.add(new Person("Alan", "09911323"));
//        personList.add(new Person("Alan", "0991132"));
//        personList.add(new Person("Alan", "0991"));
//    }

    // GET ta SET
    public ObservableList<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(ObservableList<Person> personList) {
        this.personList = personList;
    }
}
