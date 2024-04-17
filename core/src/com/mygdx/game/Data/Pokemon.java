package com.mygdx.game.Data;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Pokemon {

    TextureAtlas atlas;
    String texturePath;

    TextureRegion[] region;
    TextureRegion sprite;

    // Pokemon stats

    int health;

    int maxHealth;
    int def;
    int attack;
    int spDef;
    int spAttack;
    int speed;
    String name;
    List<Type> type;
    Natures nature;


    // Experience

    int currentEXP;
    int level;
    int expToNextLvl;

    //Moves
    ArrayList<Move> movesSet;

    HashMap<Integer, Move> learnableMoves;
    Status status;

    boolean isDead;

    int healthIv;
    int attackIv;
    int spAttackIv;
    int defIv;
    int spDefIv;
    int speedIv;

    int actualHealth;
    int actualAttack;
    int actualSPAttack;

    int actualDefence;

    int actualSPDefence;

    int actualSpeed;

    public Pokemon(String name, int maxHealth, int attack, int spAttack, int def, int spDef, int speed,
                    List<Type> type) {



        this.name = name;
        this.health = maxHealth;
        this.level = 1;
        this.currentEXP = 0;
        this.type = type;
        this.nature = Natures.values()[(int) (Math.random()*Natures.values().length)];
        this.movesSet = new ArrayList<>();
        this.learnableMoves = new HashMap<>();
        this.isDead = false;

        //base stats

        this.maxHealth = maxHealth;
        this.attack = attack;
        this.spAttack = spAttack;
        this.def = def;
        this.spDef = spDef;
        this.speed = speed;


        //IV's

        healthIv = calculateIV();
        attackIv = calculateIV();
        spAttackIv = calculateIV();
        defIv = calculateIV();
        spDefIv = calculateIV();
        speedIv = calculateIV();

        //actual stats

        actualAttack = 0;
        actualSPAttack = 0;
        actualHealth = 0;
        actualDefence = 0;
        actualSPDefence = 0;
        actualSpeed = 0;

        calculateActualStat();

    }

    public void initialize(String texturePath, String regionName) {
        this.texturePath = texturePath;
        atlas = new TextureAtlas(texturePath);


        sprite = atlas.findRegion(regionName);
        this.region = new TextureRegion[1];
        this.region[0] = sprite;

        }

    public void calculateActualStat(){
        //TODO make a map

        double attackModifier = 1.0;
        double spAttackModifier = 1.0;
        double defenceModifier = 1.0;
        double speedModifier = 1.0;
        double spDefenceModifier =1.0;

        switch (nature){
            case ADAMANT:
                attackModifier = 1.1;
                spAttackModifier = 0.9;
                break;
            case BASHFUL:
            case DOCILE:
            case HARDY:
            case QUIRKY:
            case SERIOUS:
                break;
            case BOLD:
                defenceModifier = 1.1;
                attackModifier = 0.9;
                break;
            case BRAVE:
                attackModifier = 1.1;
                speedModifier = 0.9;
                break;
            case CALM:
                spDefenceModifier = 1.1;
                attackModifier = 0.9;
                break;
            case CAREFUL:
                spDefenceModifier = 1.1;
                spAttackModifier = 0.9;
                break;
            case GENTLE:
                spDefenceModifier = 1.1;
                defenceModifier = 0.9;
                break;
            case HASTY:
                speedModifier = 1.1;
                defenceModifier = 0.9;
                break;
            case IMPISH:
                defenceModifier = 1.1;
                spAttackModifier = 0.9;
                break;
            case JOLLY:
                speedModifier = 1.1;
                spAttackModifier = 0.9;
                break;
            case LAX:
                defenceModifier = 1.1;
                spDefenceModifier = 0.9;
                break;
            case LONELY:
                attackModifier = 1.1;
                defenceModifier = 0.9;
                break;
            case MILD:
                spAttackModifier = 1.1;
                defenceModifier = 0.9;
                break;
            case MODEST:
                spAttackModifier = 1.1;
                attackModifier = 0.9;
                break;
            case NAIVE:
                speedModifier = 1.1;
                spDefenceModifier = 0.9;
                break;
            case NAUGHTY:
                attackModifier =1.1;
                spDefenceModifier = 0.9;
                break;
            case QUIET:
                spAttackModifier = 1.1;
                speedModifier = 0.9;
                break;
            case RASH:
                spAttackModifier = 1.1;
                spDefenceModifier = 0.9;
                break;
            case RELAXED:
                defenceModifier = 1.1;
                speedModifier = 0.9;
                break;
            case SASSY:
                speedModifier = 1.1;
                speedModifier = 0.9;
                break;
            case TIMID:
                speedModifier = 1.1;
                attackModifier = 0.9;
                break;
        }

        actualHealth = ((getHealth() * 2 + getHealthIv()) * getLevel() / 100 + 5);
        actualAttack = (int) (((getAttack() * 2 + getAttackIv()) * getLevel() / 100 + 5) * attackModifier);
        actualSpeed = (int) (((getSpeed() * 2 + getSpeedIv()) * getLevel() / 100 + 5) * speedModifier);
        actualSPAttack = (int) (((getSpAttack() * 2 + getSpAttackIv()) * getLevel() / 100 + 5) * spAttackModifier);
        actualDefence = (int) (((getDef() * 2 + getDefIv()) * getLevel() / 100 + 5) * defenceModifier);
        actualSPDefence = (int) (((getSpDef() * 2 + getSpDefIv()) * getLevel() / 100 + 5) * spDefenceModifier);

    }

    // Move set Logic
    public int calculateIV(){
        //

        return (int) Math.floor(Math.random()*32);
    }
    public void addMove(Move move) {
        movesSet.add(move);
    }

    public void removeMove(Move move){
        movesSet.remove(move);
    }

    public void getMove(int index){
        movesSet.get(index);
    }

    public ArrayList<Move> getMovesSet() {
        return movesSet;
    }

    // combat logic
    public void lvlUp(int expReceived){
        int totalEXP = getCurrentEXP() + expReceived;

        int levelUps = totalEXP / getExpToNextLvl();
        int remainingEXP = totalEXP % getExpToNextLvl();

        setLevel(getLevel() + levelUps);
        setCurrentEXP(remainingEXP);
    }

    public boolean isFaint(){
        if(getHealth()==0) {
            isDead = true;
            return  true;
            //TODO set animation for fainting pokemon
        } else
            isDead = false;
        return false;
    }

    public void heal(int healAmount){
        if(getHealth()!=0){
            //TODO make sure that you cant heal a pokemon with 0 health for now it just sout
            System.out.println("Pokemon is dead");
        } else
            setHealth(Math.min(getHealth()+healAmount,getMaxHealth()));
    }

    public int getHealthIv() {
        return healthIv;
    }

    public void setHealthIv(int healthIv) {
        this.healthIv = healthIv;
    }

    public int getAttackIv() {
        return attackIv;
    }

    public void setAttackIv(int attackIv) {
        this.attackIv = attackIv;
    }

    public int getSpAttackIv() {
        return spAttackIv;
    }

    public void setSpAttackIv(int spAttackIv) {
        this.spAttackIv = spAttackIv;
    }

    public int getDefIv() {
        return defIv;
    }

    public void setDefIv(int defIv) {
        this.defIv = defIv;
    }

    public int getSpDefIv() {
        return spDefIv;
    }

    public void setSpDefIv(int spDefIv) {
        this.spDefIv = spDefIv;
    }

    public int getSpeedIv() {
        return speedIv;
    }

    public void setSpeedIv(int speedIv) {
        this.speedIv = speedIv;
    }

    public int getActualHealth() {
        return actualHealth;
    }

    public void setActualHealth(int actualHealth) {
        this.actualHealth = actualHealth;
    }

    public int getActualAttack() {
        return actualAttack;
    }

    public void setActualAttack(int actualAttack) {
        this.actualAttack = actualAttack;
    }

    public int getActualSPAttack() {
        return actualSPAttack;
    }

    public void setActualSPAttack(int actualSPAttack) {
        this.actualSPAttack = actualSPAttack;
    }

    public int getActualDefence() {
        return actualDefence;
    }

    public void setActualDefence(int actualDefence) {
        this.actualDefence = actualDefence;
    }

    public int getActualSPDefence() {
        return actualSPDefence;
    }

    public void setActualSPDefence(int actualSPDefence) {
        this.actualSPDefence = actualSPDefence;
    }

    public int getActualSpeed() {
        return actualSpeed;
    }

    public void setActualSpeed(int actualSpeed) {
        this.actualSpeed = actualSpeed;
    }

    public Natures getNature() {
        return nature;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getCurrentEXP() {
        return currentEXP;
    }

    public void setCurrentEXP(int currentEXP) {
        this.currentEXP = currentEXP;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExpToNextLvl() {
        return expToNextLvl;
    }

    public void setExpToNextLvl(int expToNextLvl) {
        this.expToNextLvl = expToNextLvl;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getSpDef() {
        return spDef;
    }

    public void setSpDef(int spDef) {
        this.spDef = spDef;
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

    public TextureRegion[] getRegion() {
        return region;
    }

    public void setRegion(TextureRegion[] region) {
        this.region = region;
    }


    public String toString(){
        return ("Name: " + " " + name + " " +
                "Health: " + " " + health + " " +
                "Attack: " + " " + attack + " " +
                "Special Attack: " + " " + spAttack + " " +
                "Defence: " + " " + def + " " + " " +
                "Special Defence: " + " " + spDef + " " +
                "Speed: " + " " + speed + " " + " " +
                "Level: " + " " + level + " " +
                "Move Set: " + movesSet + "\n" +
                "Actual Stats: \n" +
                "Health: " + " " + actualHealth + " " +
                "Attack: " + " " + actualAttack + " " +
                "Special Attack: " + " " + actualSPAttack + " " +
                "Defence: " + " " + actualDefence + " " + " " +
                "Special Defence: " + " " + actualSPDefence + " " +
                "Speed: " + " " + actualSpeed + " "
        );
    }

}
