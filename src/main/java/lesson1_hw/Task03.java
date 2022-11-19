package lesson1_hw;

/*Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
и возвращающий новый массив, каждый элемент которого равен
разности элементов двух входящих массивов в той же ячейке.
Если длины массивов не равны, необходимо как-то оповестить пользователя.*/

import java.util.Arrays;

public class Task03 {

    public static void main(String[] args) {

        int [] firstArray = {4, 5, 6, 7, 5, 3};
        int [] secondArray = {1, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(difElements(firstArray, secondArray)));
    }
    public static int [] difElements (int [] arr1, int [] arr2){
        int[] newArray = new int[arr1.length];
        if(arr1.length == arr2.length){
            for (int i = 0; i < arr1.length; i++) {
                newArray[i] = arr1[i] - arr2[i];
            }
            return newArray;
        }
        else {
            throw new RuntimeException("Arrays of different lengths");
        }
    }
}
