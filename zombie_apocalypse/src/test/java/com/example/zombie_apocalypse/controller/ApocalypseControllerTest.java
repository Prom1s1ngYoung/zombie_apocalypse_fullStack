package com.example.zombie_apocalypse.controller;

import com.alibaba.fastjson.JSON;
import com.example.zombie_apocalypse.pojo.Position;
import com.example.zombie_apocalypse.pojo.World;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class ApocalypseControllerTest {
    @Resource
    private MockMvc mock;

    @Autowired
    private WebApplicationContext wac;

    Logger logger = LoggerFactory.getLogger(ApocalypseControllerTest.class);
    @Test
    void infection() throws Exception {
        mock = MockMvcBuilders.webAppContextSetup(wac).build();
        World param = new World();
        param.setDimensions(10);
        Position zombie = new Position(2, 1);
        param.setZombie(zombie);
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
        param.setCreatures(creatures);
        param.setCommands("RD");
        RequestBuilder request = MockMvcRequestBuilders.post("/zombie/infection")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSON.toJSONString(param));
        MvcResult mvcResult = mock.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        logger.info(mvcResult.getResponse().getContentAsString());
    }
}