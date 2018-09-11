package br.com.floriani.dao;

import br.com.floriani.model.Desconto;
import br.com.floriani.model.Funcionario;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DescontoDAO {

    public List<Desconto> {

        Objects.requireNonNull(f);

        String query = "SELECT * FROM desconto d WHERE d.id_funcionario = ?";

        List<Desconto> descontos = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(query);) {

            ps.setInt(1, f.getId());

            try(ResultSet resultSet = ps.executeQuery()) {

                while (resultSet.next()) {

                    Desconto d = new Desconto();
                    d.setId(resultSet.getInt("id_desconto"));
                    d.setValorDesconto(resultSet.getBigDecimal("vl_desconto"));
                    d.setFuncionario(f);

                    descontos.add(d);

                }

            }

        } catch (SQLException | PropertyVetoException | IOException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return descontos;

    }

}
