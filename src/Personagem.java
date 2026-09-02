public class Personagem {
    private String nome;
    private int vida;
    private int energia;
    private int nivel;

    public Personagem(String nome) {
        this.nome = nome;
        this.vida = 100;     
        this.energia = 100;  
        this.nivel = 1;      
    }

    public String getNome() { return nome; }
    public int getVida() { return vida; }
    public int getEnergia() { return energia; }
    public int getNivel() { return nivel; }

    public void receberDano(int dano) {
        if (dano > 0) {
            this.vida -= dano;
            if (this.vida < 0) {
                this.vida = 0; 
            }
            System.out.println("\n💥 " + nome + " recebeu " + dano + " de dano!");
        }
    }

    public void descansar() {
        if (getStatus().equals("Derrotado")) {
            System.out.println("\n❌ Erro: Um personagem derrotado não pode descansar!");
            return;
        }
        
        int recuperacao = 20;
        this.energia += recuperacao;
        if (this.energia > 100) {
            this.energia = 100; 
        }
        System.out.println("\n💤 " + nome + " descansou e recuperou energia.");
    }

    public void atacar() {
        if (getStatus().equals("Derrotado")) {
            System.out.println("\n❌ Erro: Um personagem derrotado não pode atacar!");
            return;
        }

        int custoAtaque = 30; 
        if (this.energia >= custoAtaque) {
            this.energia -= custoAtaque;
            System.out.println("\n⚔️ " + nome + " desferiu um golpe!");
        } else {
            System.out.println("\n❌ Erro: Energia insuficiente para atacar! (Requer: " + custoAtaque + ")");
        }
    }

    public String getStatus() {
        if (this.vida == 0) {
            return "Derrotado";
        } else {
            return "Vivo";
        }
    }
}
