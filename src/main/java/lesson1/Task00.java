package lesson1;

//Реализуйте метод, принимающий в качестве аргумента целочисленный массив.
//Если длина массива меньше некоторого заданного минимума, метод возвращает -1,
// в качестве кода ошибки, иначе - длину массива.

public class Task00 {

    public static final int MIN_LENGTH = 3;

    public static void main(String[] args) {

        int[] array = {1, 3, 4, 4, 5, 6};
        System.out.println(checkArrayLength(array));

    }

    public static int checkArrayLength(int[] array){
        if(array != null){
            if(array.length >= MIN_LENGTH){
                return array.length;
            }
            return -1;
        }
        return -2;

    }
}
