package com.mygdx.game.Data;

import java.util.List;

public class WildPokemon  extends Pokemon{

    private int encounterRate;
    private int catchRate;
    public WildPokemon(String name, int maxHealth, int attack, int spAttack,
                        int def, int spDef, int speed, List<Type> type, String texturePath, String regionName,
                        int encounterRate, int catchRate) {
        super(name, maxHealth, attack, spAttack, def, spDef, speed,type, texturePath, regionName);
        this.encounterRate = encounterRate;
        this.catchRate = catchRate;
    }

    public boolean isEncountered(){
        return Math.random() < (double) encounterRate / 100;
    }

}
