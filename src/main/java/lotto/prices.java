package lotto;

public enum prices {
    FIRST(2_000_000_000),
    SECOND(30_000_000),
    THIRD(1_500_00),
    FOURTH(50_000),
    FIFTH(5_000);

    private final int price;

    prices(int price) {
        this.price = price;
    }
}
