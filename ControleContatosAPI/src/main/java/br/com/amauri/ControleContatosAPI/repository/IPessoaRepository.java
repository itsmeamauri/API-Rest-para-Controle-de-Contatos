package br.com.amauri.ControleContatosAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.amauri.ControleContatosAPI.Model.Pessoa;

@Repository 
public interface IPessoaRepository extends JpaRepository<Pessoa, Long> {

}


