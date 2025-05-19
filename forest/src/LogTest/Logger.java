package LogTest;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Класс для логирования сообщений и ошибок.
 */
public class Logger {
    private PrintWriter writer; //для записи логов в файл
    private int errorCount; //количество ошибок

    /**
     * Конструктор класса Logger.
     * @param filename название файла, в который будут записываться логи
     * @throws IOException исключение при работе с файлом
     */
    public Logger(String filename) throws IOException{
        writer = new PrintWriter(filename); //создание PrintWriter для записи в файл
    }

    /**
     * Запись сообщения в лог.
     * @param report сообщение, которое будет записано в лог
     */
    public void log(String report){
        writer.println(report);
    }

    /**
     * Запись информации об ошибке в лог.
     * @param e ошибка, которая произошла
     */
    public void logError(java.io.IOException e){
        errorCount++;
        log("Error: " + e.getMessage());
    }

    /**
     * Закрывает PrintWriter и завершает запись в файл.
     */
    public void close() {
        writer.close();
    }

    /**
     * Возвращает количество записанных ошибок.
     * @return количество ошибок
     */
    public int getErrorCount(){
        return errorCount;
    }
}
