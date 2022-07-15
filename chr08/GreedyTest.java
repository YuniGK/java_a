package chr08;

public class GreedyTest {
    public static void main(String[] args) {
        //탐욕 알고리즘
        int[] coins = {500, 100, 50, 10};
        int price = 8370;
        int count;

        for (int i = 0; i < coins.length; i++) {
            count = 0;
            count += price / coins[i];
            price = price % coins[i];

            System.out.println(coins[i]+" 동전, "+count+"개가 필요합니다.");
        }
    }
}
