package iniflex;

import iniflex.model.Funcionario;
import iniflex.service.FuncionarioService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        FuncionarioService service = new FuncionarioService();
        Scanner sc = new Scanner(System.in);
        char opcao;

        do {
            System.out.println(" ");
            System.out.println("---------- MENU PRINCIPAL ----------");
            System.out.println("""
                    1- Cadastrar funcionários;
                    2- Listar todos os funcionários;
                    3- Aplicar aumento salarial;
                    4- Agrupar funcionários por cargo;
                    5- Listar aniversariantes dos meses 10 e 12;
                    6- Exibir funcionário mais velho;
                    7- Ordenar funcionários por nome;
                    8- Calcular folha salarial total;
                    9- Mostrar equivalência em salários mínimos;
                    0- Sair;
                    """);
            System.out.print("Escolha uma opção: ");
            opcao = sc.next().charAt(0);
            switch (opcao) {
                case '1' -> cadastrarFuncionarios(service);
                case '2' -> listarFuncionarios(service);
                case '3' -> aplicarAumentoSalarial(service);
                case '4' -> agruparPorCargo(service);
                case '5' -> listarAniversariantes(service);
                case '6' -> exibirFuncionarioMaisVelho(service);
                case '7' -> ordenarFuncionariosPorNome(service);
                case '8' -> calcularFolhaSalarial(service);
                case '9' -> mostrarEquivalenciaSalarial(service);
                case '0' -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != '0');
        sc.close();
    }

    private static void cadastrarFuncionarios(FuncionarioService service) {
        DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String[][] dadosFuncionarios = {
                {"Maria", "18/10/2000", "2009.44", "Operador"},
                {"João", "12/05/1990", "2284.38", "Operador"},
                {"Caio", "02/05/1961", "9836.14", "Coordenador"},
                {"Miguel", "14/10/1988", "19119.88", "Diretor"},
                {"Alice", "05/01/1995", "2234.68", "Recepcionista"},
                {"Heitor", "19/11/1999", "1582.72", "Operador"},
                {"Arthur", "31/03/1993", "4071.84", "Contador"},
                {"Laura", "08/07/1994", "3017.45", "Gerente"},
                {"Heloísa", "24/05/2003", "1606.85", "Eletricista"},
                {"Helena", "02/09/1996", "2799.93", "Gerente"}
        };

        for (String[] dados : dadosFuncionarios) {
            service.adicionarFuncionario(new Funcionario(
                    dados[0],
                    LocalDate.parse(dados[1], dataFormatada),
                    new BigDecimal(dados[2]),
                    dados[3]
            ));
        }
        System.out.println("Funcionários cadastrados com sucesso.");
    }

    private static void listarFuncionarios(FuncionarioService service) {
        service.listarFuncionarios().forEach(System.out::println);
    }

    private static void aplicarAumentoSalarial(FuncionarioService service) {
        service.aplicarAumentoSalarial(new BigDecimal("1.10"));
        System.out.println("Aumento salarial de 10% aplicado.");
    }

    private static void agruparPorCargo(FuncionarioService service) {
        Map<String, List<Funcionario>> funcionariosPorCargo = service.agruparPorCargoOrdenado();
        funcionariosPorCargo.forEach((cargo, funcs) -> {
            System.out.println("\n" + cargo + ":");
            funcs.forEach(System.out::println);
        });
    }

    private static void listarAniversariantes(FuncionarioService service) {
        List<Funcionario> aniversariantes = service.filtrarAniversariantes(10, 12);
        aniversariantes.forEach(System.out::println);
    }

    private static void exibirFuncionarioMaisVelho(FuncionarioService service) {
        Funcionario maisVelho = service.encontrarFuncionarioMaisVelho();
        System.out.println("Funcionário mais velho: " + maisVelho.getNome() + ", " + maisVelho.getIdade() + " anos");
    }

    private static void ordenarFuncionariosPorNome(FuncionarioService service) {
        service.ordenarPorNome().forEach(System.out::println);
    }

    private static void calcularFolhaSalarial(FuncionarioService service) {
        BigDecimal total = service.calcularFolhaSalarial();
        System.out.println("Folha salarial total: R$" + total);
    }

    private static void mostrarEquivalenciaSalarial(FuncionarioService service) {
        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        Map<Funcionario, BigDecimal> equivalencia = service.calcularEquivalenciaSalarial(salarioMinimo);

        equivalencia.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> {
                    String nome = entry.getKey().getNome();
                    String salarios = String.format("%.2f", entry.getValue()).replace(".", ",");
                    System.out.println(nome + ": " + salarios + " salários mínimos");
                });
    }
}