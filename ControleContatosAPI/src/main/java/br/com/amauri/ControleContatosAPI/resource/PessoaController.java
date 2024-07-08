package br.com.amauri.ControleContatosAPI.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.amauri.ControleContatosAPI.Model.Contato;
import br.com.amauri.ControleContatosAPI.Model.Pessoa;

@RestController
@RequestMapping(value = "api/pessoa")
public class PessoaController {
	@GetMapping
	public ResponseEntity<Pessoa> getpessoa() {

		Pessoa PessoaCreated = new Pessoa();
		PessoaCreated.setID(1);
		PessoaCreated.setNome("meu nome");
		PessoaCreated.setEndereco("rua meu endereco");
		PessoaCreated.setCEP("MEU CEP");
		PessoaCreated.setCidade("minha cidade");
		PessoaCreated.setUF("Minha UF");

		return new ResponseEntity<Pessoa>(PessoaCreated, HttpStatus.OK);
	}
}
