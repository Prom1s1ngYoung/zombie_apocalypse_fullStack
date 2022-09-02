package com.example.zombie_apocalypse.controller;

import com.example.zombie_apocalypse.pojo.World;
import com.example.zombie_apocalypse.service.ApocalypseService;
import com.example.zombie_apocalypse.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/zombie")
public class ApocalypseController {
    @Autowired
    private ApocalypseService apocalypseService;

    @PostMapping("/infection")
    public Result infection(@RequestBody World world) {
        return apocalypseService.infection(world);
    }

    @GetMapping
    public String test() {
        return "good";
    }
}
