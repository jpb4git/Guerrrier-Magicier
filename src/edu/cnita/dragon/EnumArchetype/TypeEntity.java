package edu.cnita.dragon.EnumArchetype;

public enum TypeEntity {
    GUERRIER (5,10,5,10),
    MAGICIEN (3,6,8,15);

    TypeEntity(int minH,int maxH,int minS,int maxS) {
        this.minHealth   = minH;
        this.maxHealth   = maxH;
        this.minStrength = minS;
        this.maxStrength = maxS;
    }
    public final int minHealth;
    public final int maxHealth;
    public final int minStrength;
    public final int maxStrength;
}
