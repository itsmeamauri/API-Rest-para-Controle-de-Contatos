package br.com.amauri.ControleContatosAPI.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.amauri.ControleContatosAPI.Model.Contato;

@RestController
@RequestMapping(value = "api/contato")
public class ContatoController {
	
	@GetMapping
	public ResponseEntity<Contato> getcontato() {

		Contato ContatoCreated = new Contato();
		ContatoCreated.setID(1);
		ContatoCreated.setTipo(0);
		ContatoCreated.setContato("eu sou sum contato");

		return new ResponseEntity<Contato>(ContatoCreated, HttpStatus.OK);
	}

}
