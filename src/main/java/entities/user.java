package entities;

public class user {
    public static StatsUser user = new StatsUser();

    public static StatsUser getUser(){
        return user;
    }

    public static void setUser(StatsUser newUser){
        user = newUser;
    }
}
