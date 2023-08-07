package dev.glauter.graphqltest.controller;

import dev.glauter.graphqltest.model.User;
import dev.glauter.graphqltest.model.Role;
import dev.glauter.graphqltest.service.PersonService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @QueryMapping
    public List<User> findAll() {
        return personService.findAll();
    }

    @QueryMapping
    public Optional<User> findOne(@Argument Integer id) {
        return personService.findOne(id);
    }

    @MutationMapping
    public User create(@Argument String name, @Argument Role role) {
        return personService.create(name, role);
    }

    @MutationMapping
    public User update(@Argument Integer id, @Argument String name, @Argument Role role) {
        return personService.update(id,name, role);
    }

    @MutationMapping
    public User delete(@Argument Integer id) {
        return personService.delete(id);
    }
}