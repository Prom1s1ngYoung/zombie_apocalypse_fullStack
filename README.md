# Zombie Apocalypse

This project can simulate how zombies infect humans in a proposed area.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### For Frontend - zombie_apocalypse_frontend

> cd "the dir home of zombie_apocalypse_frontend"
>
> npm install
>
> npm start



### For Backend - zombie_apocalypse

**Configuration**

- You can change the server port in resources' application.yml
- You can also find the cross damain cofig in config.WebMVCConfig

**Start**

> Run ZombieApocalypseApplication.class to start



After start the frontend server and backend server. You can access "localhost:3000".



## Input and output

### Input

You need to define:

1. The dimensions of the world - ==Size==
2. The first zombie's position - ==Zombie==
3. A list of creatures' position - ==Creatureslist==
   1. The standard is like: x1,y1;x2,y2    Each Postion spilted by a ';'

4. A string of commands - ==Movement==

![image-20220902151617755](https://raw.githubusercontent.com/Prom1s1ngYoung/Typora/main/img/image-20220902151617755.png)



### Output

After the apocalypse, you will get:

1. A list of zombies' final position
2. A list of creatures' final position

They will be displayed in a grid format.