package lesson1_hw;

import java.util.Arrays;

public class Task04 {
/*
    Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
 и возвращающий новый массив, каждый элемент которого равен частному элементов
 двух входящих массивов в той же ячейке. Если длины массивов не равны,
 необходимо как-то оповестить пользователя.
 Важно: При выполнении метода единственное исключение,
 которое пользователь может увидеть - RuntimeException, т.е. ваше
 */

    public static void main(String[] args) {

        float [] firstArray = {4, 5, 6, 7, 5, 3};
        float [] secondArray = {1, 3, 4, 5, 3, 7};
        System.out.println(Arrays.toString(difElements(firstArray, secondArray)));
    }
    public static float[] difElements (float[] arr1, float [] arr2){
        float [] newArray = new float[arr1.length];
        if(arr1.length == arr2.length){
            for (int i = 0; i < arr1.length; i++) {
                if(arr2[i] != 0) {
                    newArray[i] = arr1[i] / arr2[i];
                }
                else {
                    throw new RuntimeException("the divisor is zero");
                }
            }
            return newArray;
        }
        else {
            throw new RuntimeException("Arrays of different lengths");
        }
    }
}

