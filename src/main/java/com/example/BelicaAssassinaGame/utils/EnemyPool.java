package com.example.BelicaAssassinaGame.utils;

import org.academiadecodigo.maindalorians.sprites.Enemy;

import static org.academiadecodigo.maindalorians.utils.Configs.*;

import java.util.LinkedList;
import java.util.Queue;

public class EnemyPool {
    private final Queue<Enemy> pool;

    public EnemyPool(){
        pool = new LinkedList<>();
        initEnemies();
    }

    private void initEnemies(){
        for (int i = 0; i < ENEMY_POOL_STARTING_SIZE; i++) {
            pool.add(new Enemy());
        }
    }

    public Enemy poll(){
        Enemy toReturn = pool.poll();
        if(toReturn == null){
            toReturn = new Enemy();
        }
        toReturn.show();
        return toReturn;
    }

    public void offer(Enemy enemy){
        enemy.hide();
        enemy.resetPos();
        pool.offer(enemy);
    }
}
