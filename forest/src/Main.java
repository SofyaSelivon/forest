import controller.ForestController;

import java.util.Scanner;
import java.io.IOException;
import java.util.InputMismatchException;

/**
 * Главный класс программы
 */
public class Main{
    /**
     * Начало программы
     * @param args аргументы командной строки
     * @throws IOException исключение при работе с файлами
     */
    public static void main(String[] args) throws IOException{
        ForestController controller = new ForestController();
        Scanner scanner = new Scanner(System.in);
        //Основной цикл программы
        while (true){
            controller.ForestHello();
            try {
                int num = scanner.nextInt(); //выбор действия из меню пользователем
                switch (num) {
                    case (1):
                        controller.getAllAnimals(); //получение списка всех животных
                        break;
                    case (2):
                        controller.getAllPlants(); //получение списка всех растений
                        break;
                    case (3):
                        controller.addAnimal(); //добавление нового животного
                        break;
                    case (4):
                        controller.addPlant(); //добавление нового растения
                        break;
                    case (5):
                        controller.getEat(); //поиск пропитания для животного
                        break;
                    case (6):
                        controller.ForestLogTest(); //тестирование коллекций ArrayList и LinkedList
                        break;
                    case (7):
                        controller.ForestEnd();//выход из программы
                        break;
                    default: //обработка неверного ввода
                        controller.ForestErr();
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка. Попробуйте ввести цифру от 1 до 7.");
                scanner.nextLine();
        }
    }
}}