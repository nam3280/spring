package com.ssg.springtodoservice.controller;

import com.ssg.springtodoservice.dto.TodoDTO;
import com.ssg.springtodoservice.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Log4j2
@Controller
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;
    @RequestMapping("/list")
    public void list(Model model){
       log.info("todo list");
    }

    @GetMapping("/register")
    public void registerGet(){
        log.info("registerGet");
    }
    @PostMapping("/register")
    public String registerPost(@Valid TodoDTO todoDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        log.info("registerPost");
        log.info("todoDTO" + todoDTO);
        if(bindingResult.hasErrors()){
            log.info("hasError");
            redirectAttributes.addFlashAttribute("error",bindingResult.getAllErrors());
            return "redirect:/todo/register";
        }

        log.info("todoDTO" + todoDTO);
        todoService.register(todoDTO);
        return "redirect:/todo/list";
    }
}
