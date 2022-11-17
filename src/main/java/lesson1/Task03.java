package lesson1;

import java.util.ArrayList;

/*
Реализуйте метод checkArray(Integer[] arr), принимающий в качестве аргумента целочисленный одномерный массив.
Метод должен пройтись по каждому элементу и проверить что он не равен null.
А теперь реализуйте следующую логику:
Если в какой-то ячейке встретился null, то необходимо “оповестить” об этом пользователя
Если null’ы встретились в нескольких ячейках, то идеально было бы все их “подсветить”
*/
public class Task03 {

    public static void main(String[] args) {

        Integer[] arr = {3, 4, 5, null, 5, null, 8, 2};
        System.out.println("Indexes with null values" + checkArray(arr));
    }

    public static ArrayList<Integer> checkArray(Integer[] arr){
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == null){
                indexes.add(i);
            }
        }
        return indexes;
    }
}
