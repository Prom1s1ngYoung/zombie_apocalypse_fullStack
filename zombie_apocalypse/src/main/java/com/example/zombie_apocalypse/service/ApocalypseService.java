package com.example.zombie_apocalypse.service;

import com.example.zombie_apocalypse.pojo.World;
import com.example.zombie_apocalypse.vo.Result;

public interface ApocalypseService {
    Result infection(World world);
}
