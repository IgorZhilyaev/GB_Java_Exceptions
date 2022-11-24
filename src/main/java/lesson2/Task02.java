package lesson2;

public class Task02 {

    public static void main(String[] args) {
        String [][] arr = {{"hkj", "1", "4"}, {"5", "hh", "5"}, {"2", "3", "4"}};
        System.out.println(sum2d(arr));
    }
    public static int sum2d(String[][] arr) {
        if(arr == null){
            throw new RuntimeException("Array is null");
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                int val = 0;
                try {
                    val = Integer.parseInt(arr[i][j]);
                }
                catch (NumberFormatException e){
                    val = 0;
                }
                sum += val;
            }
        }
        return sum;
    }
}
