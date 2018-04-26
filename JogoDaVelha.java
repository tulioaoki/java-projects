package jogodavelha;
import java.security.SecureRandom;
import java.util.Scanner;

public class JogoDaVelha {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int opcao = 0;
        do {
            opcao = menu();
            if (opcao == 2) {
                System.out.println("Fim de jogo !");
            } else {
                if (escolherModo() == 1) {
                    umJogador();
                } else {
                    doisJogadores();
                }
            }
        } while (opcao == 1);
    }

    public static int menu() {
        Scanner in = new Scanner(System.in);
        int opcao = 0;
        while (opcao < 1 || opcao > 2) {
            System.out.println("");
            System.out.println("1 - Jogar");
            System.out.println("2 - Sair");
            System.out.print("Digite sua opção: ");
            opcao = in.nextInt();
            System.out.println("");
        }
        return opcao;
    }

    public static int escolherModo() {
        Scanner in = new Scanner(System.in);
        int opcao = 0;
        while (opcao < 1 || opcao > 2) {
            System.out.println("1 - Um Jogador");
            System.out.println("2 - Dois Jogadores");
            System.out.print("Digite sua opção: ");
            opcao = in.nextInt();
            System.out.println("");
        }
        return opcao;
    }

    public static void umJogador() {
        Scanner in = new Scanner(System.in);
        System.out.print("Informe o nome do jogador humano: ");
        String nome = in.nextLine();
        System.out.println("");
        int[][] jogo = new int[3][3];
        zerarJogo(jogo);
        int dificuldade = 0;
        do {
            System.out.println("");
            System.out.println("NIVEL DO JOGO");
            System.out.println("1- Facil");
            System.out.println("2- Difícil");
            System.out.println("Digite sua opção");
            System.out.println("");
            dificuldade = in.nextInt();
        } while (dificuldade < 1 || dificuldade > 2);
        if (dificuldade == 1) {
            jogaFacil(nome, jogo);
        } else {
            jogaDificil(nome, jogo);
        }
    }    

    public static void doisJogadores() {
        SecureRandom shuffle = new SecureRandom();
        Scanner in = new Scanner(System.in);
        System.out.print("Informe o nome do jogador 1: ");
        String nome1 = in.nextLine();
        String J1 = "J1";
        System.out.print("Informe o nome do jogador 2: ");
        String nome2 = in.nextLine();
        String J2 = "J2";
        System.out.println("\n X- " + nome1 + "\n O- " + nome2 + "\n");
        int[][] JOGO = new int[3][3];
        zerarJogo(JOGO);
        int inicia = shuffle.nextInt(2);
        if (inicia == 0) {
            System.out.println("Sorteando quem vai começar... " + nome1 + " começa.");
            jogarDois(J1, J2, nome1, nome2, JOGO);
        } else {
            System.out.println("Sorteando quem vai começar... " + nome2 + " começa.");
            jogarDois(J1, J2, nome1, nome2, JOGO);
        }
        if (verificar(JOGO) == 1) {
            System.out.println(nome1 + " venceu!");
        } else if (verificar(JOGO) == 2) {
            System.out.println(nome2 + " venceu!");
        } else if (verificar(JOGO) == 3) {
            System.out.println("EMPATOU");
        }

    }
    
    public static void jogarDois(String J1, String J2, String nome1, String nome2, int[][] JOGO) {
        exibeJogo(JOGO);
        while (verificar(JOGO) == 0) {
            System.out.println("É a vez de " + nome1 + " jogar !");
            preencher(J1, JOGO);
            exibeJogo(JOGO);
            if (verificar(JOGO) == 0) {
                preencher(J2, JOGO);
                System.out.println("É a vez de " + nome2 + " jogar !");
                exibeJogo(JOGO);
            }
        }
    }

    public static void jogaFacil(String nome, int[][] JOGO) {
        SecureRandom shuffle = new SecureRandom();
        int X = shuffle.nextInt(2);        
        final int inicia = X;
        if(inicia == 0){
        System.out.println("Sorteando quem vai começar... " + nome + " começa.");
        }else{
            System.out.println("Sorteando quem vai começar... o computador começa.");
        }
        while (verificar(JOGO) == 0) {            
            if (inicia == 0) {                
                exibeJogo(JOGO);
                System.out.println("É a vez de " + nome + " jogar !");
                preencher("J1", JOGO);
                exibeJogo(JOGO);
                if (verificar(JOGO) == 0) {
                    preencher("facil", JOGO);
                    System.out.println("O computador jogou : ");                    
                }
            } else {             
                System.out.println("O computador jogou : ");
                preencher("facil", JOGO);
                exibeJogo(JOGO);
                if (verificar(JOGO) == 0) {
                    System.out.println("É a vez de " + nome + " jogar !");
                    preencher("J1", JOGO);                   
                }
            }
        }
        if (verificar(JOGO) == 1) {
            System.out.println(nome + " VENCEU\n");
        } else if (verificar(JOGO) == 2) {
            System.out.println("PC VENCEU\n");
        } else if (verificar(JOGO) == 3) {
            System.out.println("EMPATOU\n");
        }
    }

    public static void jogaDificil(String nome, int[][] JOGO) {
        SecureRandom shuffle = new SecureRandom();
        int X = shuffle.nextInt(2);        
        final int inicia = X;
        if(inicia == 0){
        System.out.println("Sorteando quem vai começar... " + nome + " começa.");
        }else{
            System.out.println("Sorteando quem vai começar... o computador começa.");
        }
        while (verificar(JOGO) == 0) {
            if (inicia == 0) {                
                exibeJogo(JOGO);
                System.out.println("É a vez de " + nome + " jogar !");
                preencher("J1", JOGO);
                exibeJogo(JOGO);
                if (verificar(JOGO) == 0) {
                    preencher("dificil", JOGO);
                    System.out.println("O computador jogou : ");
                }
            } else {                
                System.out.println("O computador jogou : ");
                preencher("dificil", JOGO);
                exibeJogo(JOGO);
                if (verificar(JOGO) == 0) {
                    System.out.println("É a vez de " + nome + " jogar !");
                    preencher("J1", JOGO);
                }
            }
        }
        if (verificar(JOGO) == 1) {
            System.out.println(nome + " VENCEU\n");
        } else if (verificar(JOGO) == 2) {
            System.out.println("PC VENCEU\n");
        } else if (verificar(JOGO) == 3) {
            System.out.println("EMPATOU\n");
        }
    }

    public static void preencher(String tipo, int[][] JOGO) {
        Scanner in = new Scanner(System.in);
        SecureRandom shuffle = new SecureRandom();
        String jogador = tipo;
        if (tipo == "facil") {
            int L = shuffle.nextInt(3);
            int C = shuffle.nextInt(3);            
            if (JOGO[L][C] == 0) {
                JOGO[L][C] = 5;
            } else {
                preencher("facil", JOGO);
            }
        } else if (tipo == "J1") {
            int L, C;
            do {
                System.out.print("Informe a linha: ");
                L = in.nextInt() - 1;
                System.out.print("Informe a coluna: ");
                C = in.nextInt() - 1;
                if (L < 0 || L > 2 || C < 0 || L > 2) {
                    System.out.println("Informe posições válidas");
                }
            } while (L < 0 || L > 2 || C < 0 || L > 2);
            if (JOGO[L][C] == 0) {
                JOGO[L][C] = 4;
            } else {
                System.out.println("Posição já preenchida, insira outra.");
                preencher("J1", JOGO);
            }
        } else if (tipo == "J2") {
            int L, C;
            do {
                System.out.print("Informe a linha: ");
                L = in.nextInt() - 1;
                System.out.print("Informe a coluna: ");
                C = in.nextInt() - 1;
                if (L < 0 || L > 2 || C < 0 || L > 2) {
                    System.out.println("Informe posições válidas");
                }
            } while (L < 0 || L > 2 || C < 0 || L > 2);
            if (JOGO[L][C] == 0) {
                JOGO[L][C] = 5;
            } else {
                System.out.println("Posição já preenchida, insira outra.");
                preencher("J2", JOGO);
            }
        } else {
            preencherDificil(JOGO);
        }
    }

    public static void preencherDificil(int[][] JOGO) {
        int L1 = (JOGO[0][0] + JOGO[0][1] + JOGO[0][2]);
        int L2 = (JOGO[1][0] + JOGO[1][1] + JOGO[1][2]);
        int L3 = (JOGO[2][0] + JOGO[2][1] + JOGO[2][2]);
        int C1 = (JOGO[0][0] + JOGO[1][0] + JOGO[2][0]);
        int C2 = (JOGO[0][1] + JOGO[1][1] + JOGO[2][1]);
        int C3 = (JOGO[0][2] + JOGO[1][2] + JOGO[2][2]);
        int D1 = (JOGO[0][0] + JOGO[1][1] + JOGO[2][2]);
        int D2 = (JOGO[0][2] + JOGO[1][1] + JOGO[2][0]);
        if (D1 == 10) {
            for (int i = 0; i < JOGO.length; i++) {
                for (int j = 0; j < JOGO.length; j++) {
                    if (JOGO[i][i] == 0) {
                        JOGO[i][i] = 5;
                    }
                }
            }
        } else if (D2 == 10) {
            for (int i = 0; i < JOGO.length; i++) {
                for (int j = 0; j < JOGO.length; j++) {
                    if (JOGO[0][2] == 0) {
                        JOGO[0][2] = 5;
                    } else if (JOGO[1][1] == 0) {
                        JOGO[1][1] = 5;
                    } else if (JOGO[2][0] == 0) {
                        JOGO[2][0] = 5;
                    }
                }
            }
        } else if (C1 == 10) {
            for (int i = 0; i < JOGO.length; i++) {
                for (int j = 0; j < JOGO.length; j++) {
                    if (JOGO[i][0] == 0) {
                        JOGO[i][0] = 5;
                    }
                }
            }
        } else if (C2 == 10) {
            for (int i = 0; i < JOGO.length; i++) {
                for (int j = 0; j < JOGO.length; j++) {
                    if (JOGO[i][1] == 0) {
                        JOGO[i][1] = 5;
                    }
                }
            }
        } else if (C3 == 10) {
            for (int i = 0; i < JOGO.length; i++) {
                for (int j = 0; j < JOGO.length; j++) {
                    if (JOGO[i][2] == 0) {
                        JOGO[i][2] = 5;
                    }
                }
            }
        } else if (L1 == 10) {
            for (int i = 0; i < JOGO.length; i++) {
                for (int j = 0; j < JOGO.length; j++) {
                    if (JOGO[0][j] == 0) {
                        JOGO[0][j] = 5;
                    }
                }
            }
        } else if (L2 == 10) {
            for (int i = 0; i < JOGO.length; i++) {
                for (int j = 0; j < JOGO.length; j++) {
                    if (JOGO[1][j] == 0) {
                        JOGO[1][j] = 5;
                    }
                }
            }
        } else if (L3 == 10) {
            for (int i = 0; i < JOGO.length; i++) {
                for (int j = 0; j < JOGO.length; j++) {
                    if (JOGO[2][j] == 0) {
                        JOGO[2][j] = 5;
                    }
                }
            }
        } else {
            preencher("facil", JOGO);
        }
    }

    public static int verificar(int[][] JOGO) {
        int soma = 0;
        int L1 = (JOGO[0][0] + JOGO[0][1] + JOGO[0][2]);
        int L2 = (JOGO[1][0] + JOGO[1][1] + JOGO[1][2]);
        int L3 = (JOGO[2][0] + JOGO[2][1] + JOGO[2][2]);
        int C1 = (JOGO[0][0] + JOGO[1][0] + JOGO[2][0]);
        int C2 = (JOGO[0][1] + JOGO[1][1] + JOGO[2][1]);
        int C3 = (JOGO[0][2] + JOGO[1][2] + JOGO[2][2]);
        int D1 = (JOGO[0][0] + JOGO[1][1] + JOGO[2][2]);
        int D2 = (JOGO[0][2] + JOGO[1][1] + JOGO[2][0]);
        for (int i = 0; i < JOGO.length; i++) {
            for (int j = 0; j < JOGO.length; j++) {
                soma = soma + JOGO[i][j];
            }
        }
        if (D1 == 12 || D2 == 12 || L1 == 12 || L2 == 12 || L3 == 12 || C1 == 12 || C2 == 12 || C3 == 12) {
            return 1;
        } else if (D1 == 15 || D2 == 15 || L1 == 15 || L2 == 15 || L3 == 15 || C1 == 15 || C2 == 15 || C3 == 15) {
            return 2;
        } else if (soma >= 40) { // empate (o mínimo valor possível da soma de todos os espaços TODOS PREENCHIDOS é 40)
            return 3;
        }
        soma = 0;
        return 0;
    }

    public static void exibeJogo(int[][] JOGO) {
        System.out.println("");
        for (int i = 0; i < JOGO.length; i++) {
            for (int j = 0; j < JOGO.length; j++) {
                if (JOGO[i][j] == 4) {
                    System.out.print("X");
                } else if (JOGO[i][j] == 5) {
                    System.out.print("O");
                } else {
                    if (i < 2) {
                        System.out.print("_");
                    } else {
                        System.out.print(" ");
                    }
                }
                if (j < 2) {
                    System.out.print("|");
                }
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public static void zerarJogo(int[][] JOGO) {
        for (int i = 0; i < JOGO.length; i++) {
            for (int j = 0; j < JOGO.length; j++) {
                JOGO[i][j] = 0;
            }
        }
    }
}