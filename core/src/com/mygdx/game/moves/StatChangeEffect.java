package com.mygdx.game.moves;

import com.mygdx.game.Data.Pokemon;

public class StatChangeEffect implements MoveEffect{

    private final String statName;
    private final int changeAmount;

    public StatChangeEffect(String statName, int changeAmount){
        this.statName = statName;
        this.changeAmount = changeAmount;
    }

    @Override
    public void applyAffect(Pokemon targetPokemon) {
        targetPokemon.modifyStat(statName, changeAmount);
    }
}
