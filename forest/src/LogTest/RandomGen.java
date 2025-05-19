package LogTest;

import model.ForestTest;
import service.ForestService;
import model.Plant;
import model.Animal;

import java.util.Random;

/**
 * Класс для генерации случайных животных и растений в Лесу. Для тестирования лог-файла.
 */
public class RandomGen {

    private Random rand = new Random(); //генератор случайных чисел
    private String[] animalsPred = {"волк", "лиса", "медведь", "ласка"}; //массив хищников
    private String[] animalsHerb = {"лось", "олень", "заяц", "косуля", "мышь", "полевка"}; //массив травоядных
    private String[] plantsTree = {"дуб", "ива", "береза", "рябина"}; //массив деревьев
    private String[] plantsGrass = {"злаки", "кипрей", "щавель", "клевер"}; //массив трав

    /**
     * Генерация Леса ForestTest со случайными животными и растениями.
     * @return Лес со случайными животными и растениями
     */
    public ForestTest generateForest() {

        ForestTest forest = new ForestTest(); //создание Леса ForestTest для лог-файла
        int randPred = rand.nextInt(4); //случайный индекс хищника
        int randHerb = rand.nextInt(6); //случайный индекс травоядного

        int randTree = rand.nextInt(4); //случайный индекс дерева
        int randGrass = rand.nextInt(4); //случайный индекс травы

        int randSize1 = rand.nextInt(200); //случайный размер хищника
        int randSize2 = rand.nextInt(100); //случайный размер травоядного

        //Добавление случайных животных и растений
        forest.addPlant(new Plant(plantsTree[randTree], 1));
        forest.addPlant(new Plant(plantsGrass[randGrass], 2));
        forest.addAnimal(new Animal(animalsPred[randPred],1, randSize1));
        forest.addAnimal(new Animal(animalsHerb[randHerb], 2, randSize2));

        return forest;
    }
}
