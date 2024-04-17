package com.mygdx.game;

import com.mygdx.game.Data.Move;
import com.mygdx.game.Data.Pokemon;
import com.mygdx.game.Data.Type;


public class OpponentAI {
    Pokemon opponent;

    public Move chooseMove(Pokemon ai, Pokemon opponent) {

        Move bestMove = null;
        double highestEffectiveness = 0.0;

        for (Move move : ai.getMovesSet()) {
            Type moveType = move.getType();
            double effectiveness = Type.getEffectiveness(moveType, opponent.getType());

            if (move.isUsable()) {
                if (effectiveness > highestEffectiveness) {
                    highestEffectiveness = effectiveness;

                    bestMove = move;
                } else if (effectiveness == highestEffectiveness) {

                    assert bestMove != null;
                    bestMove = move.getDamage() > bestMove.getDamage() ? move : bestMove;
                }
            }
        }

        assert bestMove != null;
        bestMove.useMove();
        return bestMove;

    }
}