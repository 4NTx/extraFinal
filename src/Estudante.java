public class Estudante extends Pessoa {
    private String matricula;
    private float nota01;
    private float nota02;

    public Estudante(String nome, String cpf, String matricula, float nota01, float nota02) {
        super(nome, cpf);
        this.matricula = matricula;
        this.nota01 = nota01;
        this.nota02 = nota02;
    }

    public String getMatricula() {
        return matricula;
    }

    public float getNota01() {
        return nota01;
    }

    public float getNota02() {
        return nota02;
    }

    public float getMedia() {
        return (nota01 + nota02) / 2;
    }

    public String getEstudanteCSV() {
        return String.format("%s;%s;%s;%.2f;%.2f", getNome(), getCpf(), matricula, nota01, nota02).replace('.', ',');
    }

    public void setEstudanteCSV(String linha) {
        String[] partes = linha.split(";");
        if (partes.length == 5) {
            setNome(partes[0]);
            setCpf(partes[1]);
            this.matricula = partes[2];
            this.nota01 = Float.parseFloat(partes[3].replace(',', '.'));
            this.nota02 = Float.parseFloat(partes[4].replace(',', '.'));
        } else {
            throw new IllegalArgumentException("Linha CSV com formato inválido.");
        }
    }
}
