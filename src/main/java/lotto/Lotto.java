package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private final int bonusNumber;


    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBounsNumber() {
        return bonusNumber;
    }

    public Lotto(List<Integer> numbers , int bonusNumber) {
        LottoValidate.validate(numbers , bonusNumber);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }


}
