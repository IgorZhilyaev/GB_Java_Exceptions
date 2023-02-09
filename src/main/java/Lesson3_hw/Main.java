package Lesson3_hw;
/*
Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные пробелом:
Фамилия Имя Отчество датарождения номертелефона пол
Форматы данных:
фамилия, имя, отчество - строки
датарождения - строка формата dd.mm.yyyy
номертелефона - целое беззнаковое число без форматирования
пол - символ латиницей f или m.

Приложение должно проверить введенные данные по количеству. 
Если количество не совпадает с требуемым, вернуть код ошибки, обработать его и показать пользователю сообщение, 
что он ввел меньше и больше данных, чем требуется.

Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры. 
Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. 
Можно использовать встроенные типы java и создать свои. 
Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.

Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, 
в него в одну строку должны записаться полученные данные, вида: 
<Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>

Однофамильцы должны записаться в один и тот же файл, в отдельные строки.

Не забудьте закрыть соединение с файлом.

При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, 
пользователь должен увидеть стектрейс ошибки.
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner iScanner = new Scanner(System.in);
        System.out.print("\n Введите данные пользователя: Фамилия Имя Отчество ДатаРождения(dd.mm.yyyy) НомерТелефона Пол(f или m) \n");
        String s = iScanner.nextLine();
        iScanner.close();

        String[] inputString = s.replaceAll("\\s+", " ").split(" ");

        Human human = new Human();

        human = checkData(inputString);
        String file = human.surname + ".txt";
        writeFile(file, human);

    }

    public static Human checkData(String[] inputString) throws Exception {
        Human human1 = new Human();

        if (inputString.length > 6) {
            throw new RuntimeException("Данных больше, чем ожидалось.");
        } else if (inputString.length < 6) {
            throw new RuntimeException("Данных меньше, чем ожидалось.");
        } else {
            human1.surname = inputString[0];
            if (!human1.surname.chars().allMatch(Character::isLetter)) {
                System.out.println("Фамилия должен содержать только буквенные символы." + '\n');
            }

            human1.name = inputString[1];
            if (!human1.name.matches("[a-zA-Zа-яА-Я]*$")) {
                System.out.println("Имя должен содержать только буквенные символы." + '\n');
            }

            human1.patronymic = inputString[2];
            if (!human1.patronymic.matches("[a-zA-Zа-яА-Я]*$")) {
                System.out.println("Отчество должен содержать только буквенные символы." + '\n');
            }

            human1.birthday = inputString[3];
            checkBirthday(human1.birthday);

            checkPhone(inputString[4]);
            human1.phone = Long.valueOf(inputString[4]);

            human1.sex = inputString[5];
            checkSex(human1.sex);
        }

        return human1;
    }

    public static void writeFile(String file, Human h) throws IOException {
        // <Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
        File f = new File(file);

        if (f.exists()) {
            FileWriter writer = new FileWriter(f, true);
            String text = "<" + h.name + "><" + h.surname + "><" + h.patronymic + "><" + h.birthday + "><" + h.phone
                    + "><" + h.sex + ">";
            writer.append(text);
            writer.append('\n');
            writer.close();
        } else {
            try (FileWriter writer = new FileWriter(f, Charset.forName("UTF8"))) {
                String text = "<" + h.name + "><" + h.surname + "><" + h.patronymic + "><" + h.birthday + "><" + h.phone
                        + "><" + h.sex + ">";
                writer.write(text);
                writer.append('\n');

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        }

    }

    public static void checkBirthday(String b) throws Exception {
        try {
            String[] birthday = b.split("\\.");

            if (birthday.length > 3 || birthday.length < 3) {
                throw new Exception("Неверная длина данных. Необходимый формат: dd.mm.yyyy" + '\n');
            }

            if (birthday[0].length() < 2 || birthday[1].length() < 2 || birthday[2].length() < 4 ||
                    birthday[0].length() > 2 || birthday[1].length() > 2 || birthday[2].length() > 4) {
                throw new Exception("Длина данных меньше необходимой. Необходимый формат: dd.mm.yyyy" + '\n');
            }

            int day = Integer.parseInt(birthday[0]);
            int month = Integer.parseInt(birthday[1]);
            int year = Integer.parseInt(birthday[2]);

            if (day > 31 || day < 1) {
                throw new Exception("Неверный день рождения." + '\n');
            }

            if (month > 12 || month < 1) {
                throw new Exception("Неверный месяц рождения." + '\n');
            }

            if (year > 2022) {
                throw new Exception("Неверный год рождения." + '\n');
            }

        } catch (NumberFormatException e) {
            System.out.println("Неверное преобразование символьной строки в числовой формат" + '\n');
        } catch (Exception e) {
            System.out.println("Неверный формат даты рождения. Необходимый формат: dd.mm.yyyy" + '\n' + e.getMessage());
        }

    }

    public static void checkSex(String s) throws Exception {
        if (s.length() > 1) {
            throw new Exception("Длина данных больше необходимой." + '\n');
        } else if (s.length() < 1) {
            throw new Exception("Длина данных меньше необходимой." + '\n');
        } else {
            if (!s.equals("m") && !s.equals("f")) {
                throw new Exception(
                        "Неверный символ указания пола. Ожидается m - для мужчин или f - для женщин." + '\n');
            }
        }
    }

    public static void checkPhone(String phone) throws Exception {

        try {
            long l = Long.valueOf(phone);
        } catch (NumberFormatException e) {
            System.out.println("Неверный формат данных телефона." + '\n');
        }

        if (phone.length() > 11) {
            throw new Exception("Длина данных больше необходимой. Ожидается 11 цифр." + '\n');
        } else if (phone.length() < 11) {
            throw new Exception("Длина данных меньше необходимой. Ожидается 11 цифр." + '\n');
        } else if (phone.toCharArray()[0] != '8') {
            throw new Exception("Неверный формат записи номера телефона. Первый символ должен быть 8" + '\n');
        }

    }
}

class Human {
    // Фамилия Имя Отчество датарождения номертелефона пол
    String name;
    String surname;
    String patronymic;
    String birthday;
    long phone;
    String sex;
}
