package lesson1_hw;

//Посмотрите на код, и подумайте сколько разных типов исключений вы тут сможете получить?

public class Task02 {
    public static void main(String[] args) {
        String [][] twoDimArray = {{"3", "1", "5"}, {"12", "4", "1"}, {"6", "1", "7"}};
        System.out.println(sum2d(twoDimArray));
    }
    public static int sum2d(String[][] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 5; j++) { // ошибка в этой строчке, выход за пределы длинны массива
                int val = Integer.parseInt(arr[i][j]);
                sum += val;
            }
        }
        return sum;
    }


}
