package model;

/**
 * Животное, наследник Леса.
 */
public class Animal extends Forest{
    private int size; //размер животного

    /**
     * Конструктор класса Animal с указанными названием, группой и размером.
     * @param name название животного
     * @param group группа животного
     * @param size размер животного
     */
    public Animal(String name, int group, int size){
        super(name, group);
        this.size = size;
    }

    /**
     * Возвращает размер животного
     * @return размер животного
     */
    public int getSize(){
        return size;
    }
}
