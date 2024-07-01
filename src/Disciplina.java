import java.io.*;
import java.util.ArrayList;

public class Disciplina {
    private ArrayList<Estudante> turma;

    public Disciplina() {
        turma = new ArrayList<>();
    }

    public ArrayList<Estudante> getTurma() {
        return turma;
    }

    public void listarEstudantes() {
        if (turma.isEmpty()) {
            System.out.println("Nenhum estudante cadastrado.");
        } else {
            System.out.println("Lista de Estudantes:");
            for (Estudante estudante : turma) {
                exibirEstudante(estudante);
            }
        }
    }

    public float mediaTurma() {
        float soma = 0;
        for (Estudante estudante : turma) {
            soma += estudante.getMedia();
        }
        return turma.size() > 0 ? soma / turma.size() : 0;
    }

    public Estudante getEstudante(String matricula) {
        for (Estudante estudante : turma) {
            if (estudante.getMatricula().equals(matricula)) {
                return estudante;
            }
        }
        return null;
    }

    public boolean insereEstudante(Estudante novo) {
        if (getEstudante(novo.getMatricula()) != null) {
            System.out.println("Erro: Matrícula já cadastrada.");
            return false;
        }
        return turma.add(novo);
    }

    public boolean alteraEstudante(String matricula, Estudante atualizado) {
        Estudante estudante = getEstudante(matricula);
        if (estudante != null) {
            turma.remove(estudante);
            turma.add(atualizado);
            return true;
        }
        return false;
    }

    public boolean removeEstudante(String matricula) {
        Estudante estudante = getEstudante(matricula);
        if (estudante != null) {
            turma.remove(estudante);
            return true;
        }
        return false;
    }

    public void listaEstudantesAcima() {
        boolean encontrado = false;
        System.out.println("Estudantes com média acima de 6.0:");
        for (Estudante estudante : turma) {
            if (estudante.getMedia() > 6.0) {
                exibirEstudante(estudante);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum estudante com média acima de 6.0.");
        }
    }

    public void listaEstudantesAbaixo() {
        boolean encontrado = false;
        System.out.println("Estudantes com média abaixo de 6.0:");
        for (Estudante estudante : turma) {
            if (estudante.getMedia() < 6.0) {
                exibirEstudante(estudante);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum estudante com média abaixo de 6.0.");
        }
    }

    public void gravaArquivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("estudantes.csv"))) {
            for (Estudante estudante : turma) {
                writer.write(estudante.getEstudanteCSV());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao gravar dados no arquivo: " + e.getMessage());
        }
    }

    public void carregaDados() {
        File file = new File("estudantes.csv");
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String linha;
                while ((linha = reader.readLine()) != null) {
                    try {
                        Estudante estudante = new Estudante("", "", "", 0, 0);
                        estudante.setEstudanteCSV(linha);
                        insereEstudante(estudante);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro ao processar linha: " + linha + " - " + e.getMessage());
                    }
                }
            } catch (IOException e) {
                System.out.println("Erro ao ler dados do arquivo: " + e.getMessage());
            }
        } else {
            System.out.println("Arquivo não encontrado, será criado um novo ao salvar os dados.");
        }
    }

    void exibirEstudante(Estudante estudante) {
        System.out.println("+----------------------------+");
        System.out.printf("| Nome: %-20s |\n", estudante.getNome());
        System.out.printf("| CPF: %-21s |\n", estudante.getCpf());
        System.out.printf("| Matrícula: %-16s |\n", estudante.getMatricula());
        System.out.printf("| Nota 01: %-18.2f |\n", estudante.getNota01());
        System.out.printf("| Nota 02: %-18.2f |\n", estudante.getNota02());
        System.out.printf("| Média: %-19.2f |\n", estudante.getMedia());
        System.out.println("+----------------------------+");
    }
}
