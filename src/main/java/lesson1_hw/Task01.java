package lesson1_hw;

//Реализуйте 3 метода, чтобы в каждом из них получить разные исключения.

public class Task01 {
    public static void main(String[] args) {


        divByZero(5);
        outOfArray();
        outOfLength("asdasdasd");
    }

    public static void divByZero(int a){
        int b = 0;
        int res = a / b;
        System.out.println(res);
    }

    public static void outOfArray(){
        int[] arr = new int[10];
        System.out.println(arr[20]);
        }

    private static void outOfLength(String s) {
        String[] strings = new String[5];
        for (int i = 1; i <= strings.length; i++){
            strings[i] = s;
        }
        System.out.println(s);
    }

}






