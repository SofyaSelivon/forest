package LogTest;

import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

import model.ForestTest;

/**
 * Класс для тестирования коллекция ArrayList и LinkedList
 */
public class CollectionsTester {
    private Logger logger; //логгер для записи результатов

    /**
     * Конструктор класса CollectionsTester
     * @param logger логгер для записи результатов
     */
    public CollectionsTester(Logger logger){
        this.logger = logger;
    }

    /**
     * Тестирование производительности (добавление и удаление элементов) ArrayList
     * @param size размер коллекции
     */
    public void testArrayList(int size){
        logger.log("Array List"); //начало тестирования
        LocalDate today = LocalDate.now(); //текущая дата
        LocalTime timeStart = LocalTime.now(); //текущее время
        logger.log("Start program:"+(today)+" "+timeStart.format(DateTimeFormatter.ofPattern("HH:mm:ss"))); //старт программы

        List<ForestTest> list = new ArrayList<>(); //создание ArrayList
        RandomGen generator = new RandomGen(); //генератор леса
        long startTime = System.nanoTime(); //начало добавления элементов
        long startTimeTotal = System.nanoTime(); //начало тестирования
        //Цикл для добавления объектов в коллекцию
        for (int i = 0; i < size; i++){
            ForestTest forest = generator.generateForest(); //генерация Леса
            startTime = System.nanoTime(); //запись времени перед добавлением
            list.add(forest);
            logger.log("add, ID = " + (i+1) + ", " + (System.nanoTime() - startTime));
        }
        //Результаты добавления в ArrayList
        logger.log("addTotalCount = " + size);
        logger.log("addTotalTime = " + (System.nanoTime() - startTimeTotal));
        logger.log("addMedianTime = " + (System.nanoTime() - startTimeTotal)/size);
        logger.log("ErrorCount = " + logger.getErrorCount());

        //Удаление 10% элементов
        int removeCount = size/10; //количество удаляемых элементов
        startTimeTotal = System.nanoTime(); //время начала удаления
        //Цикл для удаления элементов из коллекции ArrayList
        for(int i = 0; i < removeCount; i++){
            Random rand = new Random();
            int index = rand.nextInt(size); //генерация случайного индекса для удаления
            startTime = System.nanoTime();
            list.remove(index);
            logger.log("remove, ID = " + (index + 1) + ", " + (System.nanoTime() - startTime));
            size--;
        }
        //Результаты удаления в ArrayList
        logger.log("removeTotalCount = " + removeCount);
        logger.log("removeTotalTime = " + (System.nanoTime() - startTimeTotal));
        logger.log("removeMedianTime = " + (System.nanoTime() - startTimeTotal)/removeCount);
        logger.log("ErrorCount = " + logger.getErrorCount());

        LocalTime timeEnd = LocalTime.now();
        logger.log("Finish program:"+(today) + " " + timeEnd.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }

    /**
     * Тестирование производительности (добавление и удаление элементов) LinkedList
     * @param size размер коллекции
     */
    public void testLinkedList(int size){
        logger.log("Linked List"); //начало тестирования
        LocalDate today = LocalDate.now(); //текущая дата
        LocalTime timestart = LocalTime.now(); //текущее время
        logger.log("Start program:"+(today)+" "+timestart.format(DateTimeFormatter.ofPattern("HH:mm:ss"))); //старт программы

        List<ForestTest> list = new LinkedList<>(); //создание коллекции LinkedList
        RandomGen generator = new RandomGen(); //генератор для создания Леса
        long startTime = System.nanoTime(); //время начала добавления
        long startTimeTotal = System.nanoTime(); //время начала тестирования
        //Цикл для добавления элементов в LinkedList
        for (int i = 0; i < size; i++){
            ForestTest forest = generator.generateForest(); //генерация Леса
            startTime = System.nanoTime(); //время перед добавлением
            list.add(forest);
            logger.log("add, ID = " + (i+1) + ", " + (System.nanoTime() - startTime));
        }
        //Результаты добавления в LinkedList
        logger.log("addTotalCount = " + size);
        logger.log("addTotalTime = " + (System.nanoTime() - startTimeTotal));
        logger.log("addMedianTime = " + (System.nanoTime() - startTimeTotal)/size);
        logger.log("ErrorCount = " + logger.getErrorCount());

        //Удаление 10 % элементов
        int removeCount = size/10; //количество удаляемых элементов
        startTimeTotal = System.nanoTime(); //время начала удаления
        //Цикл для удаления элементов из коллекции LinkedList
        for (int i = 0; i < removeCount; i++){
            Random rand = new Random();
            int index = rand.nextInt(size); //генерация случайного индекса для удаления
            startTime = System.nanoTime();
            list.remove(index);
            logger.log("remove, ID = " + (index + 1) + ", " + (System.nanoTime() - startTime));
            size--;
        }
        //Результаты удаления в LinkedList
        logger.log("removeTotalCount = " + removeCount);
        logger.log("removeTotalTime = " + (System.nanoTime() - startTimeTotal));
        logger.log("removeMedianTime = " + (System.nanoTime() - startTimeTotal)/removeCount);
        logger.log("ErrorCount = " + logger.getErrorCount());

        LocalTime timeEnd = LocalTime.now(); //время окончания тестирования
        logger.log("Finish program:" + (today) + " " + timeEnd.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }
}
