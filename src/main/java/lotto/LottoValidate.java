package lotto;

import java.util.List;

public class LottoValidate{

    static final int SIZE = 6;
    static final int MAX_RANGE = 45;
    static final int MIN_RANGE = 1;


    public static void validate(List<Integer> numbers , int bounsNumber){
        validateSize(numbers);
        validateDuplication(numbers);
        validateRange(numbers);
        validateDupBounsNumber(numbers , bounsNumber);
        validateRangeBounsNumber(bounsNumber);
    }

    public static void validateSize(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 " + SIZE + "개의 숫자로  합니다.\n");
        }
    }

    public static void validateDuplication(List<Integer> numbers) {
        if(numbers.stream().distinct().count() != SIZE){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복이 없어야 합니다. \n");
        }
    }
    public static void validateRange(List<Integer> numbers) {
        if(numbers.stream()
                .anyMatch(number -> number < MIN_RANGE || number > MAX_RANGE)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 "+MIN_RANGE+"부터 "+MAX_RANGE+" 사이의 숫자여야 합니다.\n");
        }
    }
    public static void validateDupBounsNumber(List<Integer> numbers , int bonusNumber) {
        if(numbers.stream().anyMatch(number -> number == bonusNumber )){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 달라야 합니다");
        }
    }
    public static void validateRangeBounsNumber(int bonusNumber) {
        if(bonusNumber < MIN_RANGE || bonusNumber > MAX_RANGE){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 "+MIN_RANGE+"부터 "+MAX_RANGE+" 사이의 숫자여야 합니다.\n");
        }
    }


    }
