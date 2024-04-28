import com.github.britooo.looca.api.core.Looca;
import model.Totem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Looca looca = new Looca();
        TwillioApi twilio = new TwillioApi();
        Totem totem = new Totem();
        Scanner sc = new Scanner(System.in);

        Integer a = sc.nextInt();

        for (int i = 0; true ; i++) {
            if (totem.getPorcentagemUsoMemoria() >= 70 && totem.getProcessadorUso() >= 70){
                System.out.println("alerta vermelho");
                //        twilio.twilioSms();
            }else {
                System.out.println("ok");

            }
            Thread.sleep(3000);
        }
    }

}
