package br.com.floriani;

import br.com.floriani.dao.FuncionarioDAO;
import br.com.floriani.model.Funcionario;

import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Funcionario> funcionarios = new FuncionarioDAO().findFuncionarios();

        funcionarios.stream()
                    .sorted(Comparator.comparing(Funcionario::getSalarioLiquido).reversed())
                    .forEach(System.out::println);

    }

}
