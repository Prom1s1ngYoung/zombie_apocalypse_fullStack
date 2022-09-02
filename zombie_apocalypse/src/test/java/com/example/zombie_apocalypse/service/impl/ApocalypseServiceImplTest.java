package com.example.zombie_apocalypse.service.impl;

import com.example.zombie_apocalypse.pojo.Position;
import com.example.zombie_apocalypse.pojo.World;
import com.example.zombie_apocalypse.service.ApocalypseService;
import com.example.zombie_apocalypse.vo.Result;
import com.example.zombie_apocalypse.vo.ZombiesAndCreatures;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApocalypseServiceImplTest {

    @Autowired
    private ApocalypseService apocalypseService;

    @Test
    public void test() {
        World world = new World();
        world.setDimensions(10);
        Position zombie = new Position(2, 1);
        world.setZombie(zombie);
        List<Position> creatures = new ArrayList<>();
        creatures.add(new Position(3, 1));
        creatures.add(new Position(4, 1));
        creatures.add(new Position(5, 1));
        creatures.add(new Position(6, 1));
        creatures.add(new Position(7, 1));
        creatures.add(new Position(8, 1));
        creatures.add(new Position(9, 1));
        creatures.add(new Position(0, 1));
        creatures.add(new Position(9, 9));
        world.setCreatures(creatures);
        world.setCommands("RD");
        Result result = apocalypseService.infection(world);
        ZombiesAndCreatures data = (ZombiesAndCreatures) result.getData();
        System.out.println(data.getZombies());
        System.out.println(data.getCreatures());
    }
}