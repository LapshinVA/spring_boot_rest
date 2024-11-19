package ru.edu.springauth.repository;

import org.springframework.stereotype.Repository;
import ru.edu.springauth.model.Authorities;

import java.util.*;

@Repository
public class UserRepository {

    private final Map<Map<String, String>, List<Authorities>> map1 = new HashMap<>();

    {
        Map<String, String> mapLoginAndPassword1 = new HashMap<>();
        mapLoginAndPassword1.put("login", "12345");
        map1.put(mapLoginAndPassword1, Arrays.asList(Authorities.WRITE, Authorities.DELETE));

        Map<String, String> mapLoginAndPassword2 = new HashMap<>();
        mapLoginAndPassword2.put("user", "54321");
        map1.put(mapLoginAndPassword2, Arrays.asList(Authorities.READ));
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        List<Authorities> list = new ArrayList<>();
        Map<String, String> mapLoginAndPassword3 = new HashMap<>();
        mapLoginAndPassword3.put(user, password);
        if (map1.containsKey(mapLoginAndPassword3)) {
            list = map1.get(mapLoginAndPassword3);
        }
        return list;
    }
}