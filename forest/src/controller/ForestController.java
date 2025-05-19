package controller;

import view.ForestView;
import service.ForestService;
import LogTest.Logger;
import LogTest.CollectionsTester;

import java.util.Scanner;
import java.io.IOException;

/**
 * Класс для взаимодействия с пользователем.
 */
public class ForestController{
    private final ForestView view = new ForestView(); //текстовое взаимодействие с пользователем
    private final ForestService service = new ForestService(); //основные действия с Animal и Plant
    String filename = "log.txt"; //имя лог-файла
    Logger logger = new Logger(filename); //логгер для записи сообщений
    CollectionsTester tester = new CollectionsTester(logger); //тест, использующий логгер

    /**
     * Конструктор класса ForestController
     * @throws IOException исключение при работе с файлами
     */
    public ForestController() throws IOException {
    }

    /**
     * Добавление нового животного.
     */
    public void addAnimal() {
        var scanner = new Scanner(System.in);
        boolean flagGroup = false; //флаг для проверки правильности ввода группы
        boolean flagSize = false; //флаг для проверки правильности ввода размера

        view.printCreate();
        view.printName();
        var name = scanner.next();
        view.printGroupAnimal();
        var group = 0;
        var size = 0;
        /**
         * Цикл для проверки правильности ввода группы
         */
        while (!flagGroup){
            try{
                group = scanner.nextInt();
                if (group == 1 || group == 2){
                    flagGroup = true;
                }
                else{view.printErr();}
            }catch (java.util.InputMismatchException e) {
                view.printErr();
                scanner.nextLine();
        }}
        view.printSize();
        /**
         * Цикл для проверки правильности ввода размера
         */
        while (!flagSize){
            try{
                size = scanner.nextInt();
                flagSize = true;
            }catch (java.util.InputMismatchException e){
                view.printErr();
                scanner.nextLine();
            }
        }

        service.createNewAnimal(name, group, size);
    }

    /**
     * Добавление нового растения.
     */
    public void addPlant() {
        var scanner = new Scanner(System.in);
        boolean flagGroup = false;

        view.printCreate();
        view.printName();
        var name = scanner.next();
        view.printGroupPlant();
        var group = 0;
        /**
         * Цикл для проверки правильности ввода группы
         */
        while (!flagGroup){
            try{
                group = scanner.nextInt();
                if (group == 1 || group == 2){
                    flagGroup = true;
                }
                else{view.printErr();}
            }catch (java.util.InputMismatchException e){
                view.printErr();
                scanner.nextLine();
            }
        }

        service.createNewPlant(name, group);
    }

    /**
     * Вывод списка животных.
     */
    public void getAllAnimals() {
        service.getAllAnimal().forEach(view::printAnimal);
    }

    /**
     * Вывод списка растений.
     */
    public void getAllPlants(){
        service.getAllPlant().forEach(view::printPlant);
    }

    /**
     * Взаимодействие с пользователем, поиск пропитания для животного.
     */
    public void getEat(){
        var scanner = new Scanner(System.in);
        boolean flagGroup = false; //флаг для проверки правильности ввода группы

        view.printFind();
        var name = scanner.next();
        view.printGroupAnimal();
        var group = 0;
        /**
         * Цикл для проверки правильности ввода группы животного
         */
        while (!flagGroup){
            try{
                group = scanner.nextInt();
                if (group == 1 || group == 2){
                    flagGroup = true;
                }
                else{view.printErr();}
            }catch (java.util.InputMismatchException e) {
                view.printErr();
                scanner.nextLine();
            }}

        if (group == 2){ //если группа - травоядные
            boolean flagNum = false; //флаг для проверки правильности ввода группы растения
            view.printEatPlant();
            var num = 0;
            /**
             * Цикл для проверки правильности ввода группы растения
             */
            while (!flagNum){
                try{
                    num = scanner.nextInt();
                    if (num == 0 || num == 1){
                        flagNum = true;
                    }
                    else{view.printErr();}
                }catch (java.util.InputMismatchException e) {
                    view.printErr();
                    scanner.nextLine();
            }}

            view.printLunch(name);
            view.printPlant(service.getPlant(num));
        }
        if (group == 1){ //если группа - хищники
            boolean flagSize = false; //флаг для проверки правильности ввода размера
            view.printSize();
            var size = 0;
            /**
             * Цикл для проверки правильности ввода растения
             */
            while (!flagSize){
                try{
                    size = scanner.nextInt();
                    flagSize = true;
                }catch (java.util.InputMismatchException e){
                    view.printErr();
                    scanner.nextLine();
                }
            }

            view.printLunch(name);
            view.printAnimal(service.getAnimal(size));
        }
    }

    /**
     * Завершение программы. Выход из Леса.
     */
    public void ForestEnd(){
        view.printEnd();
        System.exit(0);
    }

    /**
     * Вывод меню.
     */
    public void ForestHello(){
        view.printHello();
    }

    /**
     * Тестирование коллекций ArrayList и LinkedList. Записывает результаты в лог-файл.
     */
    public void ForestLogTest(){
        int[] sizes = {10, 100, 1000, 10000, 100000}; //размеры массивов для тестирования
        view.StartProgram();
        try{
            for (int size: sizes){
                if (size == 0){
                    throw new java.io.IOException("Длина массива должна быть больше нуля");
                }
                logger.log("Размер массива: " + size);
                tester.testArrayList(size);
                logger.log("Размер массива: " + size);
                tester.testLinkedList(size);
            }
        }
        catch (java.io.IOException e){
            logger.logError(e);
        }

        logger.close();
        System.out.println("Программа завершена! Откройте файл " + filename);
    }

    /**
     * Вывод сообщения об ошибке.
     */
    public void ForestErr(){
        view.printErr();
    }
}
