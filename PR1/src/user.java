import java.text.SimpleDateFormat;
import java.util.Date;

class PeopleQueue extends Thread    {
    private String[] names;
    public int passes = 0;
    public int rPass(){
        final int passes1 = passes;
        return passes1;
    }
    PeopleQueue(String... names) {
        this.names = names;
    }

    @Override
    public void run() {
        for (int i = 0; i < names.length; i++) {
            passes++;
            SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            Date date = new Date();
            System.out.println("Сотрудник: " + names[i] +" || Время входа -- "+ formater.format(date));
            try {
                sleep(1000); // Задержка в 1 сек для наглядности многопоточности
            } catch (Exception e) {}
        }
        t = rPass();
        System.out.println("Сотрудников вошло: " + passes);
    }
}

public class user    {

    public static void main(String[] args) {
        public int t;
        // Создаем две очереди
        PeopleQueue entrance1 = new PeopleQueue("Карина","Сергей","Николай","Фердинанд","Василий","Карина","Сергей","Николай","Фердинанд","Василий");
        PeopleQueue entrance2 = new PeopleQueue("Ирина","Людмила","Алиса","Иван","Ольга","Ирина","Людмила","Алиса","Иван");

        modelPasses pass = new modelPasses();
        pass.passesCount(0);

        System.out.println("Начало работы!");
        entrance1.start(); //1 поток
        entrance2.start(); //2 поток

        System.out.println("t! ----- "+t);
    }
}