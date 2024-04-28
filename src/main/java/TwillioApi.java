import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

public class TwillioApi {

       public static final String ACCOUNT_SID = "ACb9fd1464dd42b764542851d0c70026af";
       public static final String AUTH_TOKEN = "66f434f2c9ab4bd8cfcfd3fc05131ddc";

        public void twilioSms() {

            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
            try{
            Message message = Message
                    .creator(
                            new com.twilio.type.PhoneNumber("+5511964906490"),
                            new com.twilio.type.PhoneNumber("+16592011977"),
                            "alerta vermelho"
                            )
                            .create();
                }catch(Exception e){
                    System.out.println(e);
                }
        }
    }
