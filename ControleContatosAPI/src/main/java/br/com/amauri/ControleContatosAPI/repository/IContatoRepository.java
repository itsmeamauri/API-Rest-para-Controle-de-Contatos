package br.com.amauri.ControleContatosAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.amauri.ControleContatosAPI.Model.Contato;
import br.com.amauri.ControleContatosAPI.Model.Pessoa;

@Repository
public interface IContatoRepository extends JpaRepository<Contato, Long> {
	
}
