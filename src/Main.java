import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static final String PATH = "src/resource/";
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome do arquivo:");
        String name = sc.next();

        final Path finalPath = Paths.get(PATH + name.toLowerCase());
        final List<String> linhas = Files.readAllLines(finalPath);
        final List<Transacao> transacoes = new ArrayList<>();

        linhas.stream().forEach( e -> {
            String[] campos = e.split(",");
            var t = new Transacao(campos[0], campos[1]);
            transacoes.add(t);
        });
        BigDecimal total = BigDecimal.ZERO;
        List<BigDecimal> valores = transacoes.stream().map(t -> t.valor)
                .collect(Collectors.toList());

        for (BigDecimal v: valores) {
           total = total.add(v);
        }
        System.out.println(total.setScale(2));


        sc.close();
    }

    public static class Transacao{
        public String nome;
        public BigDecimal valor;

        public Transacao(String nome, String valor) {
            this.nome = nome;
            this.valor = new BigDecimal(valor);
        }
    }
}

