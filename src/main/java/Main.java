import com.github.britooo.looca.api.core.Looca;
import model.Totem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Looca looca = new Looca();
        TwillioApi twilio = new TwillioApi();
        Totem totem = new Totem();

        System.out.println("""
            ooooo       .o8                       ooooooooo
            `888'      "888                      d""\"""\""8'
             888   .oooo888   .ooooo.   .oooo.         .8'
             888  d88' `888  d88' `88b `P  )88b       .8'
             888  888   888  888ooo888  .oP"888      .8'
             888  888   888  888    .o d8(  888     .8'
            o888o `Y8bod88P" `Y8bod8P' `Y888""8o   .8'
            """);


        for (int i = 0; true ; i++) {
            Long consumoMemoriaRam = totem.getPorcentagemUsoMemoria();
            Long consumoProcessador = totem.getProcessadorUso();

            if (consumoMemoriaRam >= 70 && consumoProcessador >= 70){
                System.out.println("Alerta vermelho, enviando SMS pela API Twilio");
                //        twilio.twilioSms();
            }else if(consumoMemoriaRam >= 70 || consumoProcessador >= 70){
                System.out.println("Alerta laranja, consumo de memória RAM: %d, uso de processador: %d".formatted(consumoMemoriaRam, consumoProcessador));
            }else {
                System.out.println("Este totem está sem nenhum alerta, consumo de memória RAM: %d, uso de processador: %d".formatted(consumoMemoriaRam, consumoProcessador));
            }
            Thread.sleep(10000);
        }
    }

}
