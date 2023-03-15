/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.*;
import entities.Address;
import entities.Person;
import entities.Phone;
import entities.RenameMe;
import javax.persistence.EntityManagerFactory;
import utils.EMF_Creator;

public class Populator {
    public static void populate(){
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        PersonFacade pf = PersonFacade.getPersonFacade(emf);
        HobbyFacade hf = HobbyFacade.getHobbyFacade(emf);

        /*AddressDTO addressDTO_1 = new AddressDTO("Lyngbyvej", "46", 2800L);
        PhoneDTO phoneDTO_1 = new PhoneDTO(42752212L, "Home");
        PersonDTO personDTO_1 = new PersonDTO("Malene", "Christensen", "malene@gmail.com", addressDTO_1, phoneDTO_1);
        pf.addPerson(personDTO_1);

        AddressDTO addressDTO_2 = new AddressDTO("Vejen", "10", 2000L);
        PhoneDTO phoneDTO_2 = new PhoneDTO(22668833L, "Work");
        PersonDTO personDTO_2 = new PersonDTO("Karl", "Steen", "Karl@gmail.com", addressDTO_2, phoneDTO_2);
        pf.addPerson(personDTO_2);

        AddressDTO addressDTO_3 = new AddressDTO("Valbygade", "19 1.tv", 2500L);
        PhoneDTO phoneDTO_3 = new PhoneDTO(12345678L, "Mobile");
        PersonDTO personDTO_3 = new PersonDTO("Henriette", "Jensen", "henje@gmail.com", addressDTO_3, phoneDTO_3);
        pf.addPerson(personDTO_3);*/

    }
    
    public static void main(String[] args) {
        /*populate();*/
        PersonFacade pf = PersonFacade.getPersonFacade(EMF_Creator.createEntityManagerFactory());
        pf.addHobbyToPerson(412L,3L);
        HobbyFacade hf = HobbyFacade.getHobbyFacade(EMF_Creator.createEntityManagerFactory());
        System.out.println(hf.getHobbyById(412L).getHobbyName());
    }
}