package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import people.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Application {
    public static void main(String[] args) {
        Person person;
        Lotto lotto;
        List<List<Integer>> lottos = new ArrayList<>();
        List<Prices> prices;
        person = setPerson();
        int[] hitlist = new int[LottoValidate.SIZE];

        for (int i = 0; i < person.getLottoTickets(); i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            System.out.println(numbers.toString());
            lottos.add(numbers);
        }
        lotto = enterNumbers();

        prices = lotto.lottoPrices(lottos);

        for (Prices price : prices) {
            hitlist[price.ordinal()]++;
            person.addReward(price.getPrice());
        }
        printHit(hitlist);
        System.out.println("총 수익률은 "+ person.rateOfReturn()+"%입니다.");

    }

    private static void printHit(int[] hitlist) {
        System.out.println("당첨 통계 \n ---");
        System.out.println(Prices.FIFTH.toString() + hitlist[1] +"개");
        System.out.println(Prices.FOURTH.toString()+ hitlist[2] +"개");
        System.out.println(Prices.THIRD.toString()+ hitlist[3] +"개");
        System.out.println(Prices.SECOND.toString()+ hitlist[4] +"개");
        System.out.println(Prices.FIRST.toString()+ hitlist[5] +"개");
    }

    private static Person setPerson() {
        Person person;
        while (true) {
            try {
                person = new Person(readInt("구입금액을 입력해 주세요."));
                break;
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        return person;
    }

    private static Lotto enterNumbers() {
        Lotto lotto;
        while(true){
            try{
                List<Integer> winningNumber = readList("당첨 번호를 입력해주세요.");
                int bounsNumber = readInt("보너스 번호를 입력해주세요");
                lotto = new Lotto( winningNumber , bounsNumber);
                break;
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        return lotto;
    }

    private static int readInt(String notify) {
        System.out.println(notify);
        int x = 0;
        while (true) {
            try {
                x = Integer.parseInt(camp.nextstep.edu.missionutils.Console.readLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 넣어주세요");
            }
        }
        return x;
    }

    private static List<Integer> readList(String notify){
        List<Integer> list;
        while (true) {
            try {
                System.out.println(notify);
                String str = camp.nextstep.edu.missionutils.Console.readLine();
                list = new ArrayList<>();
                StringTokenizer tokenInt = new StringTokenizer(str, ",");
                while(tokenInt.hasMoreElements()){
                    list.add(Integer.parseInt(tokenInt.nextToken()));
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 쉼표를 기준으로 올바른 범위 6개 입력해주세요");
            }
        }
        return list;
    }
}
