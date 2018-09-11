package br.com.floriani.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Desconto {

    private int id;

    private Funcionario funcionario;

    private BigDecimal valorDesconto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public BigDecimal getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(BigDecimal valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Desconto desconto = (Desconto) o;
        return id == desconto.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
