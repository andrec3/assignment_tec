package com.cruzandre.assignment.service.impl;

import com.cruzandre.assignment.model.SettingList;
import com.cruzandre.assignment.service.SettingService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SettingServiceImpl implements SettingService {
    @Override
    public SettingList getSettingList() {
        String url = "http://my-json-server.typicode.com/touchtunes/tech-assignment/settings";
        return new RestTemplate().getForEntity(url,SettingList.class).getBody();
    }

}
