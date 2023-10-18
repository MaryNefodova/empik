package com.demo.empik.service;

import com.demo.empik.model.User;
import com.demo.empik.repository.CountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class UserService {

    @Autowired
    private CountRepository repository;

    @Transactional
    public User getUserData(String name)  {
        String url = "https://api.github.com/users/"+name;
        RestTemplate restTemplate = new RestTemplate();
        String resp = restTemplate.getForObject(url, String.class);
        JsonParser springParser = JsonParserFactory.getJsonParser();
        Map< String, Object > map = springParser.parseMap(resp);
        User user = createUser(map);
        addCount(user);
        return user;
    }

    public User createUser(Map< String, Object > map)  {
        Integer calculations = 0;
        Long div = Long.parseLong(map.get("followers").toString()) * (2 +
                Long.parseLong(map.get("public_repos").toString()));
        if (div==0) calculations = 1;
        else calculations = Math.toIntExact(6 / div);
        return new User(
                Long.parseLong(valueToStringOrEmpty(map, "id")),
                valueToStringOrEmpty(map, "login"),
                valueToStringOrEmpty(map, "name"),
                valueToStringOrEmpty(map, "type"),
                valueToStringOrEmpty(map, "avatar_url"),
                valueToStringOrEmpty(map, "created_at"),
                calculations);
    }

    private void addCount(User user)  {
        if(repository.findAllActiveUsersNative(user.getLogin())==null){
            repository.insertNewLogin(user.getLogin());
        }else{
            repository.updateRequestCountIfExist(user.getLogin());
        }
    }

    private String valueToStringOrEmpty(Map<String, ?> map, String key) {
        Object value = map.get(key);
        return value == null ? "" : value.toString();
    }


}
