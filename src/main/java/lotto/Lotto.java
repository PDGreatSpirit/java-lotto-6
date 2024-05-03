package lotto;

import java.util.ArrayList;
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

    public int compareNumbers(List<Integer> list){
        return (int)list
                .stream()
                .filter(numbers::contains)
                .count();
    }

    public boolean compareBonusNumber(List<Integer> list){
        return list.contains(bonusNumber);
    }

    public List<Prices> lottoPrices(List<List<Integer>> list){
        List<Prices> prices = new ArrayList<>();
        for(List<Integer> numbers : list){
            prices.add(lottoPrice(numbers));
        }
        return prices;
    }


    public Prices lottoPrice(List<Integer> numbers ){
        return Prices.valueOf(compareNumbers(numbers) , compareBonusNumber(numbers));
    }

}
