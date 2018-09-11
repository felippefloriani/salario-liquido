package br.com.floriani.dao;

import br.com.floriani.model.Funcionario;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FuncionarioDAO {

    private DescontoDAO descontoDAO;

    public FuncionarioDAO(){
        descontoDAO = new DescontoDAO();
    }

    public List<Funcionario> findFuncionarios() {

        String query = "SELECT * FROM funcionario";

        List<Funcionario> funcionarios = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {

                Funcionario f = new Funcionario();
                f.setId(resultSet.getInt("id_funcionario"));
                f.setNome(resultSet.getString("nm_funcionario"));
                f.setValorSalarioBruto(resultSet.getBigDecimal("vl_salario_bruto"));

                f.setDescontos(descontoDAO.findDescontosByFuncionario(f));

                funcionarios.add(f);

            }

        } catch (SQLException | PropertyVetoException | IOException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return funcionarios;

    }


}
