import me.duncte123.botcommons.BotCommons;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.guild.member.GenericGuildMemberEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberUpdateEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class Listener extends ListenerAdapter {

    @Override
    public void onReady(@NotNull ReadyEvent event){
        System.out.printf("%#s is ready", event.getJDA().getSelfUser());
    }


    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String prefix = Config.get("prefix");
        String raw = event.getMessage().getContentRaw();
        if(raw.equalsIgnoreCase(prefix + "shutdown") && event.getAuthor().getId().equals(Config.get("owner_id"))){
            BotCommons.shutdown(event.getJDA());
        }
    }


}
