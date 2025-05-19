package repository;

import model.Animal;
import model.Plant;

import java.util.ArrayList;
import java.util.List;

/**
 * Репозиторий. Основа действий с Animal и Plant.
 */
public class ForestRepository {
    private final List<Animal> animalList = new ArrayList<>(); //список животных
    private final List<Plant> plantList = new ArrayList<>(); //список растений

    /**
     * Добавляет животное в список.
     * @param animal добавляемое животное
     */
    public void addAnimal(Animal animal){
        animalList.add(animal);
    }

    /**
     * Добавляет растение в список.
     * @param plant добавляемое растение
     */
    public void addPlant(Plant plant){
        plantList.add(plant);
    }

    /**
     * Возвращает список животных.
     * @return список животных
     */
    public List<Animal> findAllAnimals() {
        return animalList;
    }

    /**
     * Возвращает список растений.
     * @return список растений.
     */
    public List<Plant> findAllPlants() {
        return plantList;
    }
}
