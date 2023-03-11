/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverapp.operation.dog;

import commonlib.domain.Breed;
import commonlib.domain.Dog;
import commonlib.domain.GenericEntity;
import commonlib.domain.Person;
import java.util.List;
import serverapp.operation.GenericOperation;

/**
 *
 * @author Lenovo
 */
public class GetAllDogs extends GenericOperation {

    private List<GenericEntity> list;

    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Dog)) {
            throw new Exception("Invalid object");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        list = repository.getAll((GenericEntity)new Dog());

        for (GenericEntity dogEntity : list) {
            Dog dog = (Dog) dogEntity;

            GenericEntity entityPerson = (GenericEntity) repository.getOne(dog.getPerson());
            dog.setPerson((Person) entityPerson);
            
            GenericEntity entityBreed = (GenericEntity) repository.getOne(dog.getBreed());
            dog.setBreed((Breed) entityBreed);
            
        }
    }

    public List<GenericEntity> getList() {
        return list;
    }
}
