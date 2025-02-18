package iniflex.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.text.DecimalFormat;

public class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getSalarioFormatado() {
        DecimalFormat df = new DecimalFormat("###,##0.00");
        return df.format(salario).replace(".", ",").replaceFirst(",", ".");
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s", getNome(), getDataNascimentoFormatada(), getSalarioFormatado(), getFuncao());
    }
}