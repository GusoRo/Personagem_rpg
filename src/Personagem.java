public class Personagem {
    // Atributos privados garantindo o encapsulamento
    private String nome;
    private int vida;
    private int energia;
    private int nivel;

    // Construtor: Inicializa o personagem com valores válidos padrão
    public Personagem(String nome) {
        this.nome = nome;
        this.vida = 100;     // Começa com a vida cheia
        this.energia = 100;  // Começa com a energia cheia
        this.nivel = 1;      // Regra de negócio: Nível deve começar em 1
    }

    // Getters e Setters necessários
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        if (nivel >= 1) {
            this.nivel = nivel;
        }
    }

    // Métodos de acesso (Apenas leitura) para Vida e Energia.
    // Nota: setVida() e setEnergia() NÃO foram implementados para proteger o estado interno.
    public int getVida() {
        return vida;
    }

    public int getEnergia() {
        return energia;
    }

    // Regra: O método receberDano(int dano) deve diminuir a vida (limite entre 0 e 100)
    public void receberDano(int dano) {
        if (dano > 0) {
            this.vida -= dano;
            if (this.vida < 0) {
                this.vida = 0; // Garante que a vida não fique negativa
            }
            System.out.println(nome + " recebeu " + dano + " de dano. (Vida atual: " + this.vida + ")");
        }
    }

    // Regra: O método descansar() deve recuperar energia (máximo 100)
    public void descansar() {
        if (getStatus().equals("Derrotado")) {
            System.out.println("Erro: Um personagem derrotado não pode descansar!");
            return;
        }

        int recuperacao = 20;
        this.energia += recuperacao;
        if (this.energia > 100) {
            this.energia = 100; // Impede que a energia ultrapasse o limite de 100
        }
        System.out.println(nome + " descansou. (Energia atual: " + this.energia + ")");
    }

    // Regra: O método atacar() deve consumir energia. Sem energia suficiente, não ataca.
    public void atacar() {
        if (getStatus().equals("Derrotado")) {
            System.out.println("Erro: Um personagem derrotado não pode atacar!");
            return;
        }

        int custoAtaque = 30; // Custo de energia para realizar o ataque
        if (this.energia >= custoAtaque) {
            this.energia -= custoAtaque;
            System.out.println(nome + " realizou um ataque físico! (Energia consumida: "
                    + custoAtaque + " | Energia atual: " + this.energia + ")");
        } else {
            System.out.println("Erro: " + nome + " não tem energia suficiente para atacar. (Energia atual: "
                    + this.energia + " | Custo: " + custoAtaque + ")");
        }
    }

    // Regra: O método getStatus() deve informar o estado dinamicamente (sem armazenar atributo status)
    public String getStatus() {
        if (this.vida == 0) {
            return "Derrotado";
        } else {
            return "Vivo";
        }
    }
}