package com.isep.mrjack;

public abstract class Player {
    private String name ;
    private int role ; // 0 com.isep.mrjack.MrJack et 1 Detective

    public Player(String name, int role) {
        this.name = name;
        this.role = role;
    }

    public Player(String name) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
/*
    public MrJack setRoleMrJack(Player player) {
        player.setRole(0);
        //MrJack joueurM = (MrJack) player;
        MrJack joueurM = new MrJack(name);
        return joueurM;
    }Ú

    public Enqueteur setRoleEnqueteur(Player player) {
        player.setRole(1);
        Enqueteur joueurE = (Enqueteur) player;
        return joueurE;
    }
        uúuúd
    
*/

}