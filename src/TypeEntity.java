public enum TypeEntity {
    GUERRIER (5,10,5,10),
    MAGICIEN (3,6,8,15);

    TypeEntity(int minH,int maxH,int minS,int maxS) {
        this.minHealth   = minH;
        this.maxHealth   = maxH;
        this.minStrength = minS;
        this.maxStrength = maxS;
    }
    protected final int minHealth;
    protected final int maxHealth;
    protected final int minStrength;
    protected final int maxStrength;
}
