package com.example.spock.Controller;


import com.example.spock.Component.SpockComponent1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class SpockController {

    private final SpockComponent1 spockComponent1;

    @GetMapping
    public ModelAndView method(final ModelAndView mav) {


        return mav;
    }
}
