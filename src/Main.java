import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("=== CRIAÇÃO DE PERSONAGEM ===");
        System.out.print("Digite o nome do seu guerreiro: ");
        String nomeInicial = teclado.nextLine();
        
        // Instancia o personagem na memória
        Personagem jogador = new Personagem(nomeInicial);

        boolean continuar = true;

        // Loop principal de interação
        while (continuar) {
            System.out.println("\n========= STATUS DO GUERREIRO =========");
            System.out.println("Nome: " + jogador.getNome() + " | Nível: " + jogador.getNivel());
            System.out.println("Vida: " + jogador.getVida() + "/100");
            System.out.println("Energia: " + jogador.getEnergia() + "/100");
            System.out.println("Status: " + jogador.getStatus());
            System.out.println("--------------------------------------");
            System.out.println("Escolha uma ação:");
            System.out.println("1. Atacar (Consome 30 de Energia)");
            System.out.println("2. Descansar (Recupera 20 de Energia)");
            System.out.println("3. Sofrer Dano");
            System.out.println("4. Sair do Jogo");
            System.out.print("Opção: ");

            int opcao = teclado.nextInt();

            switch (opcao) {
                case 1:
                    jogador.atacar();
                    break;
                case 2:
                    jogador.descansar();
                    break;
                case 3:
                    System.out.print("Digite a quantidade de dano recebida: ");
                    int dano = teclado.nextInt();
                    jogador.receberDano(dano);
                    break;
                case 4:
                    System.out.println("\nSaindo... Obrigado por jogar!");
                    continuar = false;
                    break;
                default:
                    System.out.println("\n Opção inválida! Escolha um número de 1 a 4.");
            }
        }
        teclado.close();
    }
}public class Main {
    public static void main(String[] args) {
        System.out.println("=== TESTANDO AS REGRAS DE NEGÓCIO DO PERSONAGEM ===\n");

        // 1. Instanciação e valores iniciais
        Personagem guerreiro = new Personagem("Link");
        System.out.println("Nome do Personagem: " + guerreiro.getNome());
        System.out.println("Nível Inicial: " + guerreiro.getNivel());
        System.out.println("Vida Inicial: " + guerreiro.getVida());
        System.out.println("Energia Inicial: " + guerreiro.getEnergia());
        System.out.println("Status Inicial: " + guerreiro.getStatus());
        System.out.println("----------------------------------------------");

        // 2. Testando consumo de energia nos ataques
        System.out.println("\n--- Simulando Sequência de Ataques ---");
        guerreiro.atacar(); // Energia: 100 -> 70
        guerreiro.atacar(); // Energia: 70 -> 40
        guerreiro.atacar(); // Energia: 40 -> 10
        guerreiro.atacar(); // Deve falhar por energia insuficiente (10 < 30)

        // 3. Testando o limite superior de descanso (energia máxima = 100)
        System.out.println("\n--- Simulando Descanso ---");
        guerreiro.descansar(); // Energia: 10 -> 30
        guerreiro.descansar(); // Energia: 30 -> 50
        guerreiro.descansar(); // Energia: 50 -> 70
        guerreiro.descansar(); // Energia: 70 -> 90
        guerreiro.descansar(); // Energia: 90 -> 100 (Garante limite de 100)
        guerreiro.descansar(); // Mantém em 100
        System.out.println("Energia final após descanso excessivo: " + guerreiro.getEnergia());

        // 4. Testando danos e transições de status (Vivo -> Derrotado)
        System.out.println("\n--- Simulando Danos e Vida ---");
        guerreiro.receberDano(50); // Vida: 100 -> 50
        System.out.println("Status atual (Esperado: Vivo): " + guerreiro.getStatus());

        guerreiro.receberDano(60); // Vida: 50 -> 0 (Garante limite de 0)
        System.out.println("Vida após dano fatal: " + guerreiro.getVida());
        System.out.println("Status atual (Esperado: Derrotado): " + guerreiro.getStatus());

        // 5. Testando bloqueio de ações pós-derrota
        System.out.println("\n--- Testando Ações com Personagem Derrotado ---");
        guerreiro.atacar();    // Deve ser bloqueado
        guerreiro.descansar();  // Deve ser bloqueado
    }
}
