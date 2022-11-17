package lesson1;
/*
Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный массив.
Необходимо посчитать и вернуть сумму элементов этого массива.
При этом накладываем на метод 2 ограничения: метод может работать только с квадратными
массивами (кол-во строк = кол-ву столбцов), и в каждой ячейке может лежать только значение 0 или 1.
Если нарушается одно из условий, метод должен бросить RuntimeException с сообщением об ошибке.
*/

public class Task02 {

    public static void main(String[] args) {
    int [][] twoDimArray = {{1, 0, 1}, {0, 0, 1}, {1, 1, 1}};
        System.out.println(result(twoDimArray));


    }
    public static int result(int [][] twoDimArray){
        if(twoDimArray.length != twoDimArray[0].length){
            throw new RuntimeException("Not square array");
        }
        int result = 0;
        for (int i = 0; i < twoDimArray.length; i++) {
            for (int j = 0; j < twoDimArray[i].length; j++) {
                if (twoDimArray[i][j] == 0 || twoDimArray[i][j] == 1) {
                    result += twoDimArray[i][j];
                }
                else {
                    throw new RuntimeException("Wrong value in the array");
                }

            }

        }
        return result;
    }
}
