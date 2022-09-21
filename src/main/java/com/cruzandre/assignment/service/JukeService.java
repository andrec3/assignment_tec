package com.cruzandre.assignment.service;

import com.cruzandre.assignment.model.Juke;
import org.springframework.stereotype.Service;

@Service
public interface JukeService {
    Juke[] getJuke();

}
