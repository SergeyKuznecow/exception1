package src;

import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Трай с ресурсами
 * Для примера и упрощения, вам уже даны 2 класса имплементирующие интерфейс AutoCloseable
 * Любой класс, который имплементит данный интерфейс или интерфейс Closeable, является ресурсом.
 * Так же ресурсами в JAVA являются практически всё IO/NIO и классы требующие закрытия (напр. при работе с БД)
 *
 * Задача:
 * 1. Используя конструкцию "Трай с ресурсами", ОДНОВРЕМЕННО вызвать оба этих класса и посмотреть на то, каким образом
 * ресурсы будут сначала открыты, отработаны, а затем закрыты.
 * 2. Заменить вывод сообщений в консоль, на логирование уровня INFO
 */
public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        try (AutoCloseableResourcesFirst resource1 = new AutoCloseableResourcesFirst();
             AutoCloseableResourcesSecond resource2 = new AutoCloseableResourcesSecond()) {
            resource1.doSomething();
            resource2.doSomething();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Произошла ошибка", e);
        }
    }



static class AutoCloseableResourcesFirst implements AutoCloseable {

    public AutoCloseableResourcesFirst() {

                // заменил   System.out.println("Вызов конструктора -> AutoCloseableResources_First");
                logger.info("Вызов конструктора -> AutoCloseableResources_First");
    }

    public void doSomething() {

        // заменил System.out.println("Какой то метод -> AutoCloseableResources_First");
        logger.info("Какой то метод -> AutoCloseableResources_First");
    }

    @Override
    public void close() throws Exception {
        // заменил    System.out.println("ЗАКРЫВАЕМ ресурс -> AutoCloseableResources_First");
        logger.info("ЗАКРЫВАЕМ ресурс -> AutoCloseableResources_First");
    }
}


static class AutoCloseableResourcesSecond implements AutoCloseable {

    public AutoCloseableResourcesSecond() {
        // заменил     System.out.println("Вызов конструктора -> AutoCloseableResources_Second");
        logger.info("Вызов конструктора -> AutoCloseableResources_Second");
    }

    public void doSomething() {
      // заменил   System.out.println("Какой то метод -> AutoCloseableResources_Second");
        logger.info("Какой то метод -> AutoCloseableResources_Second");  }

    @Override
    public void close() throws Exception {
  //заменил      System.out.println("ЗАКРЫВАЕМ ресурс -> AutoCloseableResources_Second");
        logger.info("ЗАКРЫВАЕМ ресурс -> AutoCloseableResources_Second");
    }
}
}