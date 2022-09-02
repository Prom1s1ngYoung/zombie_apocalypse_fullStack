package com.example.zombie_apocalypse.vo;

import com.example.zombie_apocalypse.pojo.Position;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ZombiesAndCreatures {
    private List<Position> zombies;

    private List<Position> creatures;
}
