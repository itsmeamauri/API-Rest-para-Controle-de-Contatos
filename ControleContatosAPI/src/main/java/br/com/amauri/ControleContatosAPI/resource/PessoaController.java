package br.com.amauri.ControleContatosAPI.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.amauri.ControleContatosAPI.Model.Contato;
import br.com.amauri.ControleContatosAPI.Model.Pessoa;

@RestController
@RequestMapping(value = "api/pessoa")
public class PessoaController {
	
	@PostMapping
	public ResponseEntity<Pessoa> salvarPessoa(@RequestBody Pessoa pessoa) {

		return new ResponseEntity<Pessoa>(pessoa, HttpStatus.CREATED);
		
	}
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> getPessoaByID(@PathVariable long id) {
		
		Pessoa PessoaCreated = new Pessoa();
		PessoaCreated.setID(1);
		PessoaCreated.setNome("meu nome");
		PessoaCreated.setEndereco("rua meu endereco");
		PessoaCreated.setCEP("MEU CEP");
		PessoaCreated.setCidade("minha cidade");
		PessoaCreated.setUF("Minha UF");

		return new ResponseEntity<Pessoa>(PessoaCreated, HttpStatus.OK);

	}
	// TODO: aqui vai a mala direta 
	
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
	
	@PutMapping("/{id}")
	public ResponseEntity<Pessoa> atualizaPessoa(@RequestBody Pessoa pessoa, @PathVariable long id) {

		return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Pessoa> excluirPessoa(@PathVariable long id) {

		return new ResponseEntity<Pessoa>(HttpStatus.OK);

	}
	
}




