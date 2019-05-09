package net.noodles.tutorial1.main.events;

import me.tigerhix.lib.scoreboard.ScoreboardLib;
import me.tigerhix.lib.scoreboard.common.EntryBuilder;
import me.tigerhix.lib.scoreboard.type.Entry;
import me.tigerhix.lib.scoreboard.type.Scoreboard;
import me.tigerhix.lib.scoreboard.type.ScoreboardHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.List;

import static org.bukkit.Bukkit.getServer;

public class JoinScoreboardEvent implements Listener {


    public void scoreboard() {
        for (Player player: getServer().getOnlinePlayers()) {
            Scoreboard scoreboard = ScoreboardLib.createScoreboard(player)
                    .setHandler(new ScoreboardHandler() {

                        @Override
                        public String getTitle(Player player) {
                            return null;
                        }

                        @Override
                        public List<Entry> getEntries(Player player) {
                            return new EntryBuilder()
                                    .blank()
                                    .next("&cHELLO YOUTUBE")
                                    .blank()
                                    .next("&aMY NAME IS " + player.getDisplayName())
                                    .blank()
                                    .next("&6www.bghd.dev")
                                    .build();
                        }

                    })
                    .setUpdateInterval(2l);
            scoreboard.activate();
        }
    }


    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        scoreboard();
    }



}
