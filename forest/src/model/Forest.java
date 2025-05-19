package model;

/**
 * Основа леса с названием и группой
 */
public class Forest {
    protected String name; //название элемента
    protected int group;//группа элемента

    /**
     * Конструктор класса Forest с заданными названием и группой.
     * @param name название элемента
     * @param group группа элемента
     */
    public Forest(String name, int group) {
        this.name = name;
        this.group = group;
    }

    /**
     * Возвращает название элемента Forest.
     * @return название элемента
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает группа элемента.
     * @return группа элемента
     */
    public int getGroup(){
        return group;
    }
}
