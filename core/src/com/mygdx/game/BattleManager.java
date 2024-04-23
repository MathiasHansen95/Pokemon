package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.Data.Move;
import com.mygdx.game.Data.Pokemon;
import com.mygdx.game.Data.WildPokemon;

import java.util.List;

public class BattleManager {


 Pokemon characterPokemon;
 Pokemon enemyPokemon;



 OpponentAI ai;

 public BattleManager(Pokemon characterPokemon, Pokemon enemyPokemon) {
     this.characterPokemon = characterPokemon;
     this.enemyPokemon = enemyPokemon;
     this.ai = new OpponentAI();
     }

    public void startBattle(){

        System.out.println("A wild " + enemyPokemon.getName() + " Appeared!");

        //mocked character pokemon just uses tackle
        Move moveChoice = characterPokemon.getMovesSet().get(0);
        //opponent chooses move based on AI
        Move chosenMoveEnemy = ai.chooseMove(enemyPokemon, characterPokemon);

        //determine first attacker
        Pokemon firstAttacker = (characterPokemon.getActualSpeed()>enemyPokemon.getActualSpeed()) ? characterPokemon :enemyPokemon;
        Pokemon secondAttacker = (firstAttacker == characterPokemon) ? enemyPokemon : characterPokemon;

        performAttack(firstAttacker, secondAttacker,(firstAttacker==characterPokemon) ? moveChoice : chosenMoveEnemy);

        if (!isBattleOver()) {
            performAttack(secondAttacker, firstAttacker, (secondAttacker == characterPokemon) ? moveChoice : chosenMoveEnemy);
        }

        if (isBattleOver()) {
            declareWinner();
        }

    }

    private void performAttack(Pokemon attacker,Pokemon defender, Move move ){
     int damage =  calculateDamage(attacker, defender, move.getDamage());
     defender.setHealth(defender.getHealth() - damage);
     System.out.println(attacker.getName() + " Used " + move.getName() + " !");
     System.out.println(defender.getName() + " Took " + damage + " damage!");


     isBattleOver();

     }

    private int calculateDamage(Pokemon attacker, Pokemon defender, int power){
     int level = attacker.getLevel();
     int damage = attacker.getActualAttack();
     int defence = defender.getActualDefence();

     //TODO there is much more to take into consideration when things get implemented CHECK LINK IN NOTE: https://bulbapedia.bulbagarden.net/wiki/Damage

     return (((100 + damage + (15 * level))*power/(defence+50))/5);

    }


    public boolean isBattleOver(){
     if(characterPokemon.getHealth() <= 0 )
         return true;

     if(enemyPokemon.getHealth() <=0)
         return true;

     else
         return false;
    }

    public Pokemon declareWinner(){
     Pokemon winner;

     if(characterPokemon.getHealth() <= 0){
         winner = enemyPokemon;
     } else
         winner = characterPokemon;

     return  winner;
    }

    public Pokemon getCharacterPokemon() {
        return characterPokemon;
    }

    public void setCharacterPokemon(Pokemon characterPokemon) {
        this.characterPokemon = characterPokemon;
    }

    public Pokemon getEnemyPokemon() {
        return enemyPokemon;
    }

    public void setEnemyPokemon(Pokemon enemyPokemon) {
        this.enemyPokemon = enemyPokemon;
    }

}
