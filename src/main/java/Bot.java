import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

public class Bot {
    private Bot(){
        JDABuilder.createDefault(Config.get("token"))
                .addEventListeners(new Listener())
                .setActivity(Activity.playing("Java"))
                .build();
    }


    public static void main(String[] args) {
        new Bot();
    }
}
