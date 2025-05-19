package view;

import model.Animal;
import model.Plant;

/**
 * Класс для вывода текстовой информации.
 */
public class ForestView {
    public void printCreate(){
        System.out.println("Введите данные для создания леса");
    }
    public void printName(){
        System.out.println("Название: ");
    }
    public void printGroupAnimal(){
        System.out.println("Введите цифру 1, если животное является хищником. Введите " +
                "цифру 2, если животное является травоядным.");
    }
    public void printGroupPlant(){
        System.out.println("Введите цифру 1, если растение является травой. Введите" +
                " цифру 2, если растение является деревом.");
    }
    public void printEatPlant() {
        System.out.println("Введите цифру 1, если данное животное питается травой. Введите " +
                "цифру 2, если данное животное питается деревьями.");
    }
    public void printFind(){
        System.out.println("Введите название животного, для которого будет происходить " +
                "поиск пропитания.");
    }
    public void printSize(){
        System.out.println("Размер животного: ");
    }
    public void printAnimal(Animal animal) {
        System.out.println("Название: " + animal.getName());
        System.out.println("Группа: " + animal.getGroup());
        System.out.println("Размер: " + animal.getSize());
    }
    public void printPlant(Plant plant){
        System.out.println("Название: " + plant.getName());
        System.out.println("Группа: " + plant.getGroup());
    }
    public void printLunch(String name){
        System.out.println("Один из вариантов обеда для животного под названием " + name + " :");
    }
    public void printEnd(){
        System.out.println("Вы вышли из Леса. До свидания!");
    }
    public void printHello(){
        System.out.println("\t\t\tМеню:\n1. Вывести всех животных, живущих в Лесу\n2. " +
                "Вывести все растения, растущие в Лесу. \n3. Добавить новое животное.\n4. " +
                "Добавить новое растение.\n5. Ввести " +
                "животное, для которого будет происходить поиск пропитания\n6. Эксперимент с лог-файлом.\n7. Выход из Леса.");
    }
    public void StartProgram(){
        System.out.println("Программа запущена! Ждите завершения.");
    }
    public void printErr(){
        System.out.println("Ошибка. Попробуйте снова.");
    }
}
