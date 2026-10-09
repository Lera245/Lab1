import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
void main() {
    Scanner scanner = new Scanner(System.in);
    Process [] processes = new Process[3];
    try{
        System.out.println("\nЗапуск приложений");
        for (int i = 0; i < 3; i++) {
            System.out.println("Введите имя приложения " + (i + 1) + " (например, notepad.exe)");
            String name = scanner.nextLine().trim().toLowerCase();
            processes[i] = new ProcessBuilder(name).start();
            System.out.println("Приложение запущенно");
        }

        System.out.println("\nСписок запущенных приложений");
        for (int i = 0; i < 3; i++) {
            System.out.println("Процесс "+ (i + 1) + " работает "+ processes[i].isAlive());
        }

        System.out.println("\nЗавершение процессов ");
        for (int i = 0; i < 3; i++) {
            System.out.println("Закрыть процесс " + (i + 1) + "? (да/нет)");
            String close = scanner.nextLine().trim().toLowerCase();

            if(close.equals("да")){
                processes[i].destroy();
                System.out.println("Процесс закрыт.");
            }
            else{
                System.out.println("Процесс оставлен работать");
            }
        }
    }
    catch (IOException e) {
        System.out.println("Ошибка: " + e.getMessage());
    }
    scanner.close();
}
