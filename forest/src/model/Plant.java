package model;

/**
 * Растение, наследник Леса.
 */
public class Plant extends Forest{

    /**
     * Конструктор класса Plant с указанными названием и группой растения.
     * @param name название растения
     * @param group группа растения
     */
    public Plant(String name, int group){
        super(name, group);
    }
}
