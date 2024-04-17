package com.mygdx.game.Data;

import java.util.*;

public enum Type {
    GRASS,
    NORMAL,
    FIRE,
    WATER,
    ELECTRIC,
    ICE,
    FIGHTING,
    POISON,
    GROUND,
    FLYING,
    PSYCHIC,
    BUG,
    ROCK,
    GHOST,
    DRAGON,
    STEEL,
    FAIRY,
    DARK;
    private static final Map<Type, Map<Type, Double>>effectiveness;

    static {
        EffectivenessBuilder builder = new EffectivenessBuilder();

        builder.forType(NORMAL)
                .against(NORMAL,ROCK,0.5)
                .against(NORMAL,GHOST, 0)
                .against(NORMAL,STEEL, 0.5);

        builder.forType(FIRE)
                .against(FIRE, FIRE,0.5)
                .against(FIRE, WATER, 0.5)
                .against(FIRE, GRASS, 2)
                .against(FIRE, ICE, 2)
                .against(FIRE, BUG, 2)
                .against(FIRE, ROCK, 0.5)
                .against(FIRE, DRAGON, 0.5)
                .against(FIRE, STEEL, 2);



        builder.forType(WATER)
                .against(WATER, FIRE,2)
                .against(WATER, WATER, 0.5)
                .against(WATER, GRASS, 0.5)
                .against(WATER, GROUND,2)
                .against(WATER, ROCK, 2)
                .against(WATER, DRAGON, 0.5);

        builder.forType(ELECTRIC)
                .against(ELECTRIC, WATER, 2)
                .against(ELECTRIC, ELECTRIC, 0.5)
                .against(ELECTRIC, GRASS, 0.5)
                .against(ELECTRIC, GROUND, 0)
                .against(ELECTRIC, FLYING,2)
                .against(ELECTRIC, DRAGON,0.5);

        builder.forType(GRASS)
                .against(GRASS, FIRE, 0.5)
                .against(GRASS, WATER,2)
                .against(GRASS, GHOST,0.5)
                .against(GRASS, POISON,0.5)
                .against(GRASS, GRASS,0.5)
                .against(GRASS, FLYING, 0.5)
                .against(GRASS, BUG, 0.5)
                .against(GRASS, ROCK,2)
                .against(GRASS, DRAGON,0.5)
                .against(GRASS, STEEL, 0.5);


        builder.forType(ICE)
                .against(ICE, FIRE, 0.5)
                .against(ICE, WATER, 0.5)
                .against(ICE, GRASS, 2)
                .against(ICE, ICE, 0.5)
                .against(ICE, GROUND, 2)
                .against(ICE, FLYING, 2)
                .against(ICE, DRAGON, 2)
                .against(ICE, STEEL, 0.5);

        builder.forType(FIGHTING)
                .against(FIGHTING, NORMAL, 2)
                .against(FIGHTING, ICE, 2)
                .against(FIGHTING, POISON, 0.5)
                .against(FIGHTING, FLYING, 0.5)
                .against(FIGHTING, PSYCHIC, 0.5)
                .against(FIGHTING, BUG, 0.5)
                .against(FIGHTING, ROCK, 0.5)
                .against(FIGHTING, GHOST, 0)
                .against(FIGHTING, DARK, 2)
                .against(FIGHTING, STEEL, 2)
                .against(FIGHTING, FAIRY, 0.5);

        builder.forType(POISON)
                .against(POISON, GRASS, 2)
                .against(POISON, POISON, 0.5)
                .against(POISON, GROUND, 0.5)
                .against(POISON, ROCK, 0.5)
                .against(POISON, GHOST, 0.5)
                .against(POISON, STEEL, 0)
                .against(POISON, FAIRY, 2);

        builder.forType(GROUND)
                .against(GROUND, FIRE, 2)
                .against(GROUND, ELECTRIC, 2)
                .against(GROUND, GRASS, 0.5)
                .against(GROUND, POISON, 2)
                .against(GROUND, FLYING, 0)
                .against(GROUND, BUG, 0.5)
                .against(GROUND, ROCK, 2)
                .against(GROUND, STEEL, 2);

        builder.forType(FLYING)
                .against(FLYING, ELECTRIC, 0.5)
                .against(FLYING, GRASS, 2)
                .against(FLYING, FIGHTING, 2)
                .against(FLYING, BUG, 2)
                .against(FLYING, ROCK, 0.5)
                .against(FLYING, STEEL, 0.5);

        builder.forType(PSYCHIC)
                .against(PSYCHIC, FIGHTING, 2)
                .against(PSYCHIC, POISON, 2)
                .against(PSYCHIC, FLYING, 0.5)
                .against(PSYCHIC, DRAGON, 0)
                .against(PSYCHIC, STEEL, 0.5);

        builder.forType(BUG)
                .against(BUG, FIRE, 0.5)
                .against(BUG, GRASS, 2)
                .against(BUG, FIGHTING, 0.5)
                .against(BUG, POISON, 0.5)
                .against(BUG, GROUND, 0.5)
                .against(BUG, PSYCHIC, 2)
                .against(BUG, GHOST, 0.5)
                .against(BUG, DARK, 2)
                .against(BUG, STEEL, 0.5)
                .against(BUG, FAIRY, 0.5);

        builder.forType(ROCK)
                .against(ROCK, FIRE, 2)
                .against(ROCK, ICE, 2)
                .against(ROCK, FIGHTING, 0.5)
                .against(ROCK, GROUND, 0.5)
                .against(ROCK, FLYING, 2)
                .against(ROCK, BUG, 2)
                .against(ROCK, STEEL, 0.5);

        builder.forType(GHOST)
                .against(GHOST, NORMAL, 0)
                .against(GHOST, PSYCHIC, 2)
                .against(GHOST, GHOST, 2)
                .against(GHOST, DARK, 0.5);

        builder.forType(DRAGON)
                .against(DRAGON, DRAGON, 2)
                .against(DRAGON, STEEL, 0.5)
                .against(DRAGON, FAIRY, 0);

        builder.forType(DARK)
                .against(DARK, FIGHTING, 0.5)
                .against(DARK, PSYCHIC, 2)
                .against(DARK, GHOST, 2)
                .against(DARK, DRAGON, 0.5)
                .against(DARK, FAIRY, 0.5);

        builder.forType(STEEL)
                .against(STEEL, FIRE, 0.5)
                .against(STEEL, WATER,0.5)
                .against(STEEL, ELECTRIC, 0.5)
                .against(STEEL, ICE, 2)
                .against(STEEL, ROCK, 2)
                .against(STEEL, STEEL, 0.5)
                .against(STEEL, FAIRY,2);

        builder.forType(FAIRY)
                .against(FAIRY, FIRE, 0.5)
                .against(FAIRY, FIGHTING, 2)
                .against(FAIRY, POISON, 0.5)
                .against(FAIRY, DRAGON, 2)
                .against(FAIRY, DARK, 2)
                .against(FAIRY, STEEL, 0.5);

       effectiveness = builder.build();


    }

    public static double  getEffectiveness(Type attackingType, List<Type> defendingType){
        return effectiveness.getOrDefault(attackingType, Collections.emptyMap()).getOrDefault(defendingType, 1.0);
    }
    private static class EffectivenessBuilder {
        private final Map<Type, Map<Type, Double>> effectivenessMap = new HashMap<>();
        public EffectivenessBuilder forType(Type attackingType){
            effectivenessMap.putIfAbsent(attackingType, new HashMap<>());
            return this;
        }

        public EffectivenessBuilder against(Type attackingType, Type defendingType, double multiplier) {
            Map<Type, Double> typeMap = effectivenessMap.get(attackingType);
            typeMap.put(defendingType, multiplier);
            return this;
        }

        public Map<Type, Map<Type, Double>> build(){
            return effectivenessMap;
        }

    }

}


