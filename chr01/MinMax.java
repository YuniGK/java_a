package chr01;
public class MinMax {
    public static void main(String[] args) {
        int[] numbers = {10, 55, 23, 2, 79, 101, 16, 82, 30, 45};

        int min = numbers[0];
        int max = numbers[0];

        int minNum = 0;
        int maxNum = 0;
        
        for(int i = 0; i < numbers.length; i++){
            if(min > numbers[i]){
                min = numbers[i];
                minNum = i+1;
            }

            if(max < numbers[i]){
                max = numbers[i];
                maxNum = i+1;
            }
        }

        System.out.println("작은 수 "+min+"이다. "+minNum);
        System.out.println("큰 수 "+max+"이다. "+maxNum);
    }
}
