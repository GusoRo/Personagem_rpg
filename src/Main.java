public class Main {
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