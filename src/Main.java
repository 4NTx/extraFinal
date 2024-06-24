import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Disciplina disciplina = new Disciplina();
        Scanner scanner = new Scanner(System.in);

        try {
            disciplina.carregaDados();
        } catch (Exception e) {
            System.out.println("Erro ao carregar dados do arquivo: " + e.getMessage());
        }

        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Cadastrar novo estudante");
            System.out.println("2. Alterar estudante");
            System.out.println("3. Remover estudante");
            System.out.println("4. Consultar estudante");
            System.out.println("5. Listar estudantes");
            System.out.println("6. Listar estudantes com média abaixo de 6.0");
            System.out.println("7. Listar estudantes com média acima de 6.0");
            System.out.println("8. Mostrar média da turma");
            System.out.println("9. Salvar");
            System.out.println("10. Sair");
            System.out.print("Escolha uma opção: ");

            while (true) {
                try {
                    opcao = scanner.nextInt();
                    scanner.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.print("Entrada inválida. Por favor, escolha uma opção válida: ");
                    scanner.nextLine();
                }
            }

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Matrícula: ");
                    String matricula = scanner.nextLine();
                    System.out.print("Nota 01: ");
                    float nota01 = obterNota(scanner);
                    System.out.print("Nota 02: ");
                    float nota02 = obterNota(scanner);
                    Estudante estudante = new Estudante(nome, cpf, matricula, nota01, nota02);
                    if (disciplina.insereEstudante(estudante)) {
                        System.out.println("Estudante cadastrado com sucesso.");
                    } else {
                        System.out.println("Falha ao cadastrar estudante.");
                    }
                    break;
                case 2:
                    System.out.print("Matrícula do estudante a alterar: ");
                    matricula = scanner.nextLine();
                    Estudante estudanteExistente = disciplina.getEstudante(matricula);
                    if (estudanteExistente != null) {
                        System.out.print("Nome: ");
                        nome = scanner.nextLine();
                        System.out.print("CPF: ");
                        cpf = scanner.nextLine();
                        System.out.print("Nota 01: ");
                        nota01 = obterNota(scanner);
                        System.out.print("Nota 02: ");
                        nota02 = obterNota(scanner);
                        Estudante estudanteAtualizado = new Estudante(nome, cpf, matricula, nota01, nota02);
                        if (disciplina.alteraEstudante(matricula, estudanteAtualizado)) {
                            System.out.println("Estudante alterado com sucesso.");
                        } else {
                            System.out.println("Falha ao alterar estudante.");
                        }
                    } else {
                        System.out.println("Estudante não encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Matrícula do estudante a remover: ");
                    matricula = scanner.nextLine();
                    if (disciplina.removeEstudante(matricula)) {
                        System.out.println("Estudante removido com sucesso.");
                    } else {
                        System.out.println("Estudante não encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Matrícula do estudante a consultar: ");
                    matricula = scanner.nextLine();
                    Estudante estudanteConsulta = disciplina.getEstudante(matricula);
                    if (estudanteConsulta != null) {
                        System.out.println("Dados do Estudante:");
                        disciplina.exibirEstudante(estudanteConsulta);
                    } else {
                        System.out.println("Estudante não encontrado.");
                    }
                    break;
                case 5:
                    disciplina.listarEstudantes();
                    break;
                case 6:
                    disciplina.listaEstudantesAbaixo();
                    break;
                case 7:
                    disciplina.listaEstudantesAcima();
                    break;
                case 8:
                    System.out.println("Média da turma: " + disciplina.mediaTurma());
                    break;
                case 9:
                    try {
                        disciplina.gravaArquivo();
                        System.out.println("Dados salvos com sucesso.");
                    } catch (Exception e) {
                        System.out.println("Erro ao salvar dados: " + e.getMessage());
                    }
                    break;
                case 10:
                    try {
                        disciplina.gravaArquivo();
                        System.out.println("Dados salvos com sucesso. Saindo...");
                    } catch (Exception e) {
                        System.out.println("Erro ao salvar dados: " + e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        } while (opcao != 10);

        scanner.close();
    }

    private static float obterNota(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextFloat();
            } catch (InputMismatchException e) {
                System.out.print("Entrada inválida. Por favor, insira um valor numérico para a nota: ");
                scanner.nextLine();
            }
        }
    }
}
