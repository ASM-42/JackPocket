public abstract class Player {
    private String name ;
    private int role ; // 0 MrJack et 1 Detective
    private Player jeu;

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

    public MrJack setRoleMrJack(Player player) {
        player.setRole(0);
        MrJack joueurM = new MrJack(player.getName());
        return joueurM;
    }

    public Enqueteur setRoleEnqueteur(Player player) {
        player.setRole(1);
        Enqueteur joueurE = new Enqueteur(player.getName());
        return joueurE;
    }


 }
