package se.simpor.urbanterror.logparser.domain;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: simon.rydberg
 * Date: 2012-11-01
 * Time: 21:43
 * To change this template use File | Settings | File Templates.
 */
public class Player {
    String name;

    long kills;

    long deaths;

    List<Player> hitPlayer = Lists.newArrayList();

    List<Player> killedPlayer = Lists.newArrayList();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getKills() {
        return kills;
    }

    public void setKills(long kills) {
        this.kills = kills;
    }

    public long getDeaths() {
        return deaths;
    }

    public void setDeaths(long deaths) {
        this.deaths = deaths;
    }

    public List<Player> getHitPlayer() {
        return hitPlayer;
    }

    public void setHitPlayer(List<Player> hitPlayer) {
        this.hitPlayer = hitPlayer;
    }

    public List<Player> getKilledPlayer() {
        return killedPlayer;
    }

    public void setKilledPlayer(List<Player> killedPlayer) {
        this.killedPlayer = killedPlayer;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", kills=" + kills +
                ", deaths=" + deaths +
                ", hitPlayer=" + hitPlayer +
                ", killedPlayer=" + killedPlayer +
                '}';
    }
}
