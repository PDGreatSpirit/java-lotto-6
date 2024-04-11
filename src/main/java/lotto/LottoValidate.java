package lotto;

import java.util.List;

public class LottoValidate{

    static final int SIZE = 6;
    static final int MAX_RANGE = 45;
    static final int MIN_RANGE = 1;


    public static void validate(List<Integer> numbers){
        validateSize(numbers);
        validateDuplication(numbers);
        validateRange(numbers);
    }

    public static void validateSize(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException();
        }
    }
    public static void validateDuplication(List<Integer> numbers) {
        if(numbers.stream().distinct().count() != SIZE){
            throw new IllegalArgumentException();
        }
    }
    public static void validateRange(List<Integer> numbers) {
        if(numbers.stream()
                .anyMatch(number -> number < MIN_RANGE || number > MAX_RANGE)) {
            throw new IllegalArgumentException();
        }
    }


}
