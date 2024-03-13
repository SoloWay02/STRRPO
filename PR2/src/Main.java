import java.net.NetworkInterface;
import java.io.IOException;
import java.net.InetAddress;
public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        InetAddress ipAddress = InetAddress.getLocalHost();
        String hostAddress = ipAddress.getHostAddress();
        System.out.println("IP адрес компьютера: " + hostAddress);

        NetworkInterface network = NetworkInterface.getByInetAddress(ipAddress); // Получаем сетевой интерфейс
        byte[] macAddress = network.getHardwareAddress();

        // Преобразование MAC адреса в строку из байтов
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < macAddress.length; i++) {
            sb.append(String.format("%02X%s", macAddress[i], (i < macAddress.length - 1) ? "-" : ""));
        }
        String mac = sb.toString();


        ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", "echo ip:"+hostAddress+" > D://ipPc.txt");
        Process process = processBuilder.start();
        process.waitFor();

        processBuilder.command("cmd.exe", "/c", "echo MAC:"+mac+" > D://MAC.txt");
        Process process2 = processBuilder.start();
        process2.waitFor();
    }
}