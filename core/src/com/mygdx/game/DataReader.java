package com.mygdx.game;

import com.google.gson.Gson;
import com.mygdx.game.Data.Natures;
import com.mygdx.game.Data.Pokemon;
import com.mygdx.game.Data.Type;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DataReader {


    public static Map<String, Pokemon> readPokemonData(String filePath) throws IOException {
        Map<String, Pokemon> pokemonMap = new HashMap<>();
        Gson gson = new Gson();

        try(FileReader reader = new FileReader(filePath)){
            PokemonData[] pokemons = gson.fromJson(reader, PokemonData[].class);
            for(PokemonData data : pokemons) {
                pokemonMap.put(data.getName(), new Pokemon(data.getName(),
                        data.getMaxHealth(),
                        data.getAttack(),
                        data.getSpAttack(),
                        data.getDefense(),
                        data.getSpDefense(),
                        data.getSpeed(),
                        data.getType(),
                        data.getTexturePath(),
                        data.getRegionPath())
                );
            }
        }

        return pokemonMap;
    }

    private static class MoveData{
        String name;
        int power;
        int accuracy;
        Type type;


    }
    private static class PokemonData {
        int maxHealth;
        int defense;
        int attack;
        int spDefense;
        int spAttack;
        int speed;
        String name;
        List<Type> type;
        Natures nature;

        String texturePath;
        String regionPath;

        public String getTexturePath() {
            return texturePath;
        }

        public void setTexturePath(String texturePath) {
            this.texturePath = texturePath;
        }

        public String getRegionPath() {
            return regionPath;
        }

        public void setRegionPath(String regionPath) {
            this.regionPath = regionPath;
        }

        public int getMaxHealth() {
            return maxHealth;
        }

        public void setMaxHealth(int maxHealth) {
            this.maxHealth = maxHealth;
        }

        public int getDefense() {
            return defense;
        }

        public void setDefense(int defense) {
            this.defense = defense;
        }

        public int getAttack() {
            return attack;
        }

        public void setAttack(int attack) {
            this.attack = attack;
        }

        public int getSpDefense() {
            return spDefense;
        }

        public void setSpDefense(int spDefense) {
            this.spDefense = spDefense;
        }

        public int getSpAttack() {
            return spAttack;
        }

        public void setSpAttack(int spAttack) {
            this.spAttack = spAttack;
        }

        public int getSpeed() {
            return speed;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Type> getType() {
            return type;
        }

        public void setType(List<Type> type) {
            this.type = type;
        }

        public Natures getNature() {
            return nature;
        }

        public void setNature(Natures nature) {
            this.nature = nature;
        }
    }
}
