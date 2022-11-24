package lesson2;

import java.util.Scanner;

public class Task01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[10];
        System.out.println("Уажите индекс элемента массива, в который хотите записать значение 1: ");
        int index = scanner.nextInt();
        if(index >= 0 && index < arr.length){
            arr[index] = 1;
        }
        else {
            System.out.println("Введён не верный индекс");
        }
    }
}
