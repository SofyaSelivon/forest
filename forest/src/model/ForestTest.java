package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для тестирования лог-файла, содержит списки растений и животных.
 */
public class ForestTest {
    private List<Plant> plants; //список растений
    private List<Animal> animals; //список животных

    /**
     * Конструктор класса ForestTest. Создает списки растений и животных.
     */
    public ForestTest() {
        plants = new ArrayList<>();
        animals = new ArrayList<>();
    }

    /**
     * Добавляет растение в список.
     * @param plant добавляемое растение
     */
    public void addPlant(Plant plant){
        plants.add(plant);
    }

    /**
     * Добавляет животное в список.
     * @param animal добавляемое животное
     */
    public void addAnimal(Animal animal){
        animals.add(animal);
    }
    /*public List<Plant> getPlants(){
        return plants;
    }

    public List<Animal> getAnimals(){
        return animals;
    }*/
}
