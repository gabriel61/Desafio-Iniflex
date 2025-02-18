package iniflex.service;

import iniflex.model.Funcionario;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class FuncionarioService {
    private List<Funcionario> funcionarios = new ArrayList<>();

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public List<Funcionario> listarFuncionarios() {
        return new ArrayList<>(funcionarios);
    }

    public void removerFuncionarioPorNome(String nome) {
        funcionarios.removeIf(func -> func.getNome().equals(nome));
    }

    public void aplicarAumentoSalarial(BigDecimal percentual) {
        funcionarios.forEach(func -> func.setSalario(func.getSalario().multiply(percentual)));
    }

    public Map<String, List<Funcionario>> agruparPorCargoOrdenado() {
        return funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getFuncao))
                .collect(Collectors.groupingBy(
                        Funcionario::getFuncao,
                        TreeMap::new,
                        Collectors.toList()
                ));
    }

    public List<Funcionario> filtrarAniversariantes(int... meses) {
        return funcionarios.stream()
                .filter(func -> Arrays.stream(meses).anyMatch(m -> func.getDataNascimento().getMonthValue() == m))
                .collect(Collectors.toList());
    }

    public Funcionario encontrarFuncionarioMaisVelho() {
        return funcionarios.stream()
                .min(Comparator.comparing(Funcionario::getDataNascimento))
                .orElseThrow();
    }

    public List<Funcionario> ordenarPorNome() {
        return funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .collect(Collectors.toList());
    }

    public BigDecimal calcularFolhaSalarial() {
        return funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Map<Funcionario, BigDecimal> calcularEquivalenciaSalarial(BigDecimal salarioMinimo) {
        return funcionarios.stream()
                .collect(Collectors.toMap(
                        func -> func,
                        func -> func.getSalario().divide(salarioMinimo, 2, BigDecimal.ROUND_HALF_UP)
                ));
    }
}