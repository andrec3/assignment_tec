package com.cruzandre.assignment.service.impl;

import com.cruzandre.assignment.model.Juke;
import com.cruzandre.assignment.service.JukeService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JukeServiceImpl implements JukeService {
    @Override
    public Juke[] getJuke() {
        String url = "https://my-json-server.typicode.com/touchtunes/tech-assignment/jukes";
        return new RestTemplate().getForEntity(url, Juke[].class).getBody();
    }
}
