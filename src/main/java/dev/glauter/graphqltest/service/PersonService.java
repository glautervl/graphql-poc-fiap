package dev.glauter.graphqltest.service;

import dev.glauter.graphqltest.model.Role;
import dev.glauter.graphqltest.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PersonService {

    private List<User> Users = new ArrayList<>();
    AtomicInteger id = new AtomicInteger(0);

    public List<User> findAll() {
        return Users;
    }

    public Optional<User> findOne(Integer id) {
        return Users.stream().filter(User -> User.id() == id).findFirst();
    }

    public User create(String name, Role role) {
        User USer = new User(id.incrementAndGet(), name, role);
        Users.add(USer);
        return USer;
    }

    public User update(Integer id, String name, Role role) {
        User updatedUser = new User(id, name, role);
        Optional<User> optional = Users.stream().filter(c -> c.id() == id).findFirst();
        if (optional.isPresent()) {
            User USer = optional.get();
            int index = Users.indexOf(USer);
            Users.set(index, updatedUser);
        } else {
            throw new IllegalArgumentException("Invalid coffee");
        }
        return updatedUser;
    }

    public User delete(Integer id) {
        User USer = Users.stream().filter(c -> c.id() == id)
                .findFirst().orElseThrow(() -> new IllegalArgumentException());
        Users.remove(USer);
        return USer;
    }

    @PostConstruct
    private void init() {
        Users.add(new User(id.incrementAndGet(), "Glauter Lemos", Role.GUEST));
        Users.add(new User(id.incrementAndGet(), "Jean Roberto", Role.MANAGER));
        Users.add(new User(id.incrementAndGet(), "Rafael Lima", Role.OPERATOR));
        Users.add(new User(id.incrementAndGet(), "Rodney Sostras", Role.OPERATOR));
    }
}