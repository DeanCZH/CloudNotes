package com.mjl.controller;

import com.mjl.model.vo.ResultResponse;
import com.mjl.service.NoteServiceI;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by Alvin on 15/11/4.
 */
@Controller
@RequestMapping(value = "/note")
public class NoteController {

    @Resource
    NoteServiceI noteServiceI;

//    @RequestMapping(value = "")
//    public ResultResponse ListAllNotes()
}
