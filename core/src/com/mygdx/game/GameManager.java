package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Data.*;

import java.io.IOException;
import java.util.*;

public class GameManager extends ApplicationAdapter {
	OpponentAI opponentAI;
	Pokemon charPokemon;
	Pokemon oppPokemon;

	SpriteBatch batch;
	Arena arena = new Arena();


	@Override
	public void create () {

		batch = new SpriteBatch();


        try {
            Map<String, Pokemon> pokemonMap = DataReader.readPokemonData("assets/JSON/Pokemons.JSON");
			Set<String> pokemonNames = pokemonMap.keySet();

			Random random = new Random();
			int randomIndex = random.nextInt(pokemonNames.size());

			String randomPokeName = (String) pokemonNames.toArray()[randomIndex];

			charPokemon = pokemonMap.get("Bulbasaur");
			oppPokemon = pokemonMap.get(randomPokeName);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


		arena.create();

		opponentAI = new OpponentAI();
		System.out.println(charPokemon);

		//mock for testing


	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 1, 1, 1);
		batch.begin();
		arena.render();
		drawPokemon(oppPokemon, 400,350);
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
