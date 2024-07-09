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

import java.util.ArrayList;
import java.util.List;
import br.com.amauri.ControleContatosAPI.Model.Contato;

@RestController
@RequestMapping(value = "api/contatos")
public class ContatoController {

	@PostMapping
	public ResponseEntity<Contato> salvarContato(@RequestBody Contato contato) {

		return new ResponseEntity<Contato>(contato, HttpStatus.CREATED);
	}

	@GetMapping
	public Iterable<Contato> getListaContatos() {

		List<Contato> ListaContatos = new ArrayList<>();

		Contato ContatoCreated = new Contato();
		ContatoCreated.setID(1);
		ContatoCreated.setTipo(0);
		ContatoCreated.setContato("eu sou sum contato");

		ListaContatos.add(ContatoCreated);

		Contato ContatoCreated2 = new Contato();
		ContatoCreated2.setID(0);
		ContatoCreated2.setTipo(1);
		ContatoCreated2.setContato("eu sou sum contato 2");

		ListaContatos.add(ContatoCreated2);

		return ListaContatos;

	}

	@GetMapping("/{id}")
	public ResponseEntity<Contato> getContatoByID(@PathVariable long id) {

		Contato ContatoCreated = new Contato();
		ContatoCreated.setID(1);
		ContatoCreated.setTipo(0);
		ContatoCreated.setContato("eu sou sum contato");

		return new ResponseEntity<Contato>(ContatoCreated, HttpStatus.OK);

	}

	@GetMapping("/pessoa/{idPessoa}")
	public Iterable<Contato> getContatosPessoaByID(@PathVariable long idPessoa) {

		List<Contato> ListaContatos = new ArrayList<>();

		Contato ContatoCreated = new Contato();
		ContatoCreated.setID(1);
		ContatoCreated.setTipo(0);
		ContatoCreated.setContato("eu sou sum contato");

		ListaContatos.add(ContatoCreated);

		Contato ContatoCreated2 = new Contato();
		ContatoCreated2.setID(0);
		ContatoCreated2.setTipo(1);
		ContatoCreated2.setContato("eu sou sum contato 2");

		ListaContatos.add(ContatoCreated2);

		return ListaContatos;

	}

	@PutMapping("/{id}")
	public ResponseEntity<Contato> atualizaContato(@RequestBody Contato contato, @PathVariable long id) {

		return new ResponseEntity<Contato>(contato, HttpStatus.OK);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Contato> excluirContato(@PathVariable long id) {

		return new ResponseEntity<Contato>(HttpStatus.OK);

	}
}
