package BelicaAssassinaGame.utils;

import BelicaAssassinaGame.sprites.Shot;

import static BelicaAssassinaGame.utils.Configs.*;


import java.util.LinkedList;
import java.util.Queue;

// o Rolo diz que esta classe nao faz sentido, era para ser diferente... cromo.
public class ShotPool {
    private final static Queue<Shot> pool = new LinkedList<>();

    static{
        for (int i = 0; i < SHOT_POOL_STARTING_SIZE; i++) {
            pool.add(new Shot());
        }
    }

    public static Shot pollAtCoordinates(int x, int y){
        Shot shot = pool.poll();
        if (shot == null){
            shot = new Shot();
        }
        shot.moveToCoordinates(x, y);
        shot.show();
        return shot;
    }

    public static void offer(Shot shot){
        shot.hide();
        pool.offer(shot);
    }
}
