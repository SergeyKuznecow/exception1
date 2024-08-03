import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *  Логирование состояний и ошибок в работе программы.
 *  Напишите метод, который выбрасывает проверяемое исключение и поймайте его в методе main
 *  Отловите и залогируйте начало вызова метода с ошибкой и саму ошибку уровнем INFO и WARNING соответственно
 */

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        System.out.println("Hello world!");
        logger.info("Начало вызова метода с ошибкой");
        try {
            throwCheckedException();
        } catch (MyCheckedException e) {//В блоке catch перехватывается исключение типа MyCheckedException, и
            // логируется сообщение об ошибке с уровнем WARNING.
            logger.log(Level.WARNING, "Произошла ошибка", e);
        }
    }

    public static void throwCheckedException() throws MyCheckedException {
        throw new MyCheckedException("Это проверяемое исключение");
    }//Внутри метода создается и выбрасывается новое исключение с сообщением "Это проверяемое исключение".
}

class MyCheckedException extends Exception {
    public MyCheckedException(String message) {
        super(message);//конструктор, который принимает строку message и передает ее в конструктор суперкласса Exception
    }
}//прога выводит "Hello world!" в консоль, логирует начало вызова метода с ошибкой, вызывает метод, который выбрасывает
// исключение, перехватывает это исключение и логирует сообщение об ошибке с уровнем WARNING
