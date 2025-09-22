package com.neueda.dependencyinjection;

// typically the place where we have the endpoints
// endpoints are URLs of the API that can be triggered from outside
// controller should only contain mappings
// Logic could for example be in a service
public class PersonController {
    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    
}
