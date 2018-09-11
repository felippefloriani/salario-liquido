package br.com.floriani.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class Funcionario {

    private int id;

    private String nome;

    private BigDecimal valorSalarioBruto;

    private List<Desconto> descontos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValorSalarioBruto() {
        return valorSalarioBruto;
    }

    public void setValorSalarioBruto(BigDecimal valorSalarioBruto) {
        this.valorSalarioBruto = valorSalarioBruto;
    }

    public List<Desconto> getDescontos() {
        return descontos;
    }

    public BigDecimal getSalarioLiquido() {

        if (descontos != null && !descontos.isEmpty()) {

            BigDecimal valorTotalDescontos = descontos
                    .stream()
                    .map(Desconto::getValorDesconto)
                    .reduce(BigDecimal::add)
                    .orElse(BigDecimal.ZERO);

            return valorSalarioBruto.subtract(valorTotalDescontos);

        }

        return valorSalarioBruto;

    }

    public void setDescontos(List<Desconto> descontos) {
        this.descontos = descontos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return nome + ", Salário Líquido: R$ " + getSalarioLiquido();
    }
}
