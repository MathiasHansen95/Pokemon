package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Data.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameManager extends ApplicationAdapter {
	OpponentAI opponentAI;

	//MOCK

	List<WildPokemon> wildPokemons;

	SpriteBatch batch;
	Arena arena = new Arena();


	@Override
	public void create () {

		batch = new SpriteBatch();

		arena.create();

		opponentAI = new OpponentAI();

		BattleManager  battleManager;

		wildPokemons = new ArrayList<>();

		//mock for testing


	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 1, 1, 1);
		batch.begin();
		arena.render();
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		arena.dispose();
	}

	public void drawPokemon(Pokemon pokemon, float x, float y){
		batch.draw(pokemon.getRegion()[0],x,y);
	}
}
