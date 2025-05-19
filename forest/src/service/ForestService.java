package service;

import repository.ForestRepository;
import model.Animal;
import model.Plant;

import java.util.List;

/**
 * Класс с действиями, производимыми с Animal и Plant.
 */
public class ForestService {
    private final ForestRepository animalRepository = new ForestRepository();
    private final ForestRepository plantRepository = new ForestRepository();

    /**
     * Создание нового животного и добавление в список.
     * @param name название животного
     * @param group группа животного
     * @param size размер животного
     */
    public void createNewAnimal(String name, int group, int size) {
        Animal animal = new Animal(name, group, size);

        animalRepository.addAnimal(animal);
    }

    /**
     * Создание нового растения и добавление в список.
     * @param name название растения.
     * @param group группа растения.
     */
    public void createNewPlant(String name, int group) {
        Plant plant = new Plant(name, group);

        plantRepository.addPlant(plant);
    }

    /**
     * Возвращает список всех животных.
     * @return список животных
     */
    public List<Animal> getAllAnimal() {
        return animalRepository.findAllAnimals();
    }

    /**
     * Возвращает список всех растений.
     * @return список растений
     */
    public List<Plant> getAllPlant() {
        return plantRepository.findAllPlants();
    }

    /**
     * Находит растение с нужной группой и возвращает его.
     * @param group группа искомого растения
     * @return растение с указанной группой или null, если ничего не найдено
     */
    public Plant getPlant(int group){
        return plantRepository.findAllPlants().stream()
                .filter(plant -> plant.getGroup() == group)
                .findAny().orElse(null);
    }

    /**
     * Находит животное с размером, меньше указанного, и возвращает его.
     * @param size размер, меньше которого должно быть искомое животное
     * @return животное размером меньше указанного или null, если ничего не найдено.
     */
    public Animal getAnimal(int size){
        return animalRepository.findAllAnimals().stream()
                .filter(animal -> animal.getSize() < size)
                .findAny().orElse(null);
    }
}
