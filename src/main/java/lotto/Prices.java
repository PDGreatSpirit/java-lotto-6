package lotto;

public enum Prices {
    NONE(0, 0),
    FIFTH(5_000 , 3 ),
    FOURTH(50_000 , 4),
    THIRD(1_500_00 , 5),
    SECOND(30_000_000 , 5),
    FIRST(2_000_000_000 , 6);

    private final int price;
    private final int hit;

    Prices(int price,int hit) {
        this.price = price;
        this.hit = hit;
    }

    public int getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        if (this.price == SECOND.price)
            return hit +"개 일치, 보너스 볼 일치("
                +price+ "원) - ";
        return hit +"개 일치 ("
                +price+ "원) - ";
    }

    public static Prices valueOf(int matchCount, boolean matchBonus) {
        if (matchCount == 6)  return FIRST;
        if (matchCount == 5 && matchBonus) return SECOND;
        if (matchCount == 5) return THIRD;
        if (matchCount == 4) return FOURTH;
        if (matchCount == 3) return FIFTH;
        return NONE;
    }
}
