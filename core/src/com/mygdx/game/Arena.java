package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Arena {
    SpriteBatch batch;
    Texture img;
    Sprite arenaSprite;

    OrthographicCamera cam;


    public void create(){
        batch = new SpriteBatch();
        img = new Texture("Arenas/Default_bg.png");
        arenaSprite = new Sprite(img);

        cam = new OrthographicCamera();
        cam.setToOrtho(false,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

    }

    public void render(){


        batch.begin();
        batch.draw(arenaSprite, 0, 0, cam.viewportWidth, cam.viewportHeight);
        batch.end();
    }

    public void dispose(){
        batch.dispose();
        img.dispose();
    }

}
