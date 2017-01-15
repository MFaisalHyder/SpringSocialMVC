package com.test.springSocial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Faisal on 01/13/17.
 */

@Controller
public class AppController {

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public String indexPage() { return "index"; }

}
