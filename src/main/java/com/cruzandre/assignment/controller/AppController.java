package com.cruzandre.assignment.controller;

import com.cruzandre.assignment.model.Juke;
import com.cruzandre.assignment.model.JukeComponent;
import com.cruzandre.assignment.model.Setting;
import com.cruzandre.assignment.service.impl.JukeServiceImpl;
import com.cruzandre.assignment.service.impl.SettingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class AppController {

    private ArrayList<Juke> jukes = new ArrayList<>();

    @Autowired
    SettingServiceImpl settingService;

    @Autowired
    JukeServiceImpl jukeService;

    @ResponseBody
    @GetMapping("/test")
    public String test(){
        return "Test OK!!";
    }

    @ResponseBody
    @GetMapping("/id/{settingId}")
    public Setting getSettingsById(@PathVariable("settingId") String settingId){
        for (int i = 0; i < settingService.getSettingList().settings.size(); i++) {
            if (settingService.getSettingList().getSettings().get(i).getId().contains(settingId)) {
                return settingService.getSettingList().getSettings().get(i);
            }
        }
        return null;
    }

    @ResponseBody
    @GetMapping("/jukes")
    public List<Juke> getJukes() {
        return List.of(jukeService.getJuke());
    }

    @ResponseBody
    @GetMapping("/jukes/{settingId}")
    public List<Juke> getJukesByComponents(@PathVariable("settingId") String settingId){
        List<Juke> jukes = getJukes();
        List<String> requires = getSettingsById(settingId).getRequires();
        List<Juke> jukeList = new ArrayList<>();

        for(Juke juke : jukes){
            List<String> componentName = new ArrayList<>();
            for(JukeComponent component : juke.getComponents()){
                componentName.add(component.getName());
            }
            if(componentName.containsAll(requires)){
                jukeList.add(juke);
            }
        }

        return jukeList;
    }
}