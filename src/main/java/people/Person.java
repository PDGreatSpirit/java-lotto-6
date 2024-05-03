package people;

public class Person {
    private final int money;
    private final int lottoTickets;
    private int reward = 0;

    public Person(int money) {
        if(money % 1000 != 0) throw new IllegalArgumentException("[ERROR] 숫자의 단위는 1000단위로 입력해주세요.");
        this.money = money;
        this.lottoTickets = money/1000;
    }

    public int getLottoTickets() {
        return lottoTickets;
    }

    public void addReward(int reward) {
        this.reward += reward;
    }

    public String rateOfReturn(){
        if(lottoTickets == 0) return "0.00";
        double rate = (double) reward / money;
        return String.format("%.2f",rate);
    }
}
