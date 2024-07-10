package br.com.amauri.ControleContatosAPI.resource;

import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.Optional;

import br.com.amauri.ControleContatosAPI.DTO.ContatoDTO;
import br.com.amauri.ControleContatosAPI.Model.Contato;
import br.com.amauri.ControleContatosAPI.Model.Pessoa;
import br.com.amauri.ControleContatosAPI.repository.IContatoRepository;
import br.com.amauri.ControleContatosAPI.repository.IPessoaRepository;

@RestController
@RequestMapping(value = "api/contatos")
public class ContatoController {

	private IContatoRepository _contatoRepository;
	private IPessoaRepository _pessoaRepository;

	@Autowired
	public ContatoController(IContatoRepository contatoRepository, IPessoaRepository pessoaRepository) {
		this._contatoRepository = contatoRepository;
		this._pessoaRepository = pessoaRepository;
	}

	@PostMapping
	public ResponseEntity<Contato> salvarContato(@RequestBody ContatoDTO contato) {
		long pessoaId = contato.pessoaId();

		Optional<Pessoa> objPessoa = _pessoaRepository.findById(pessoaId);

		Contato objContato = new Contato();
		objContato.setTipo(contato.tipo());
		objContato.setContato(contato.contato());
		objContato.setPessoa(objPessoa.get());

		_contatoRepository.save(objContato);

		return new ResponseEntity<Contato>(HttpStatus.CREATED);
	}

	@GetMapping
	public Iterable<Contato> getListaContatos() {
		return _contatoRepository.findAll();

	}

	@GetMapping("/{id}")
	public ResponseEntity<ContatoDTO> getContatoByID(@PathVariable long id) {

		Optional<Contato> objContato = _contatoRepository.findById(id);

		ContatoDTO objDTO = new ContatoDTO(objContato.get().getID(), objContato.get().getTipo(),
				objContato.get().getContato(), objContato.get().getPessoa().getID());

		return new ResponseEntity<ContatoDTO>(objDTO, HttpStatus.OK);

	}

	@GetMapping("/pessoa/{idPessoa}")
	public Iterable<Contato> getContatosPessoaByID(@PathVariable long idPessoa) {

		Optional<Pessoa> objPessoa = _pessoaRepository.findById(idPessoa);

		return objPessoa.get().getContatos();

	}

	@PutMapping("/{id}")
	public ResponseEntity<Contato> atualizaContato(@RequestBody Contato contato, @PathVariable long id) {

		if (_contatoRepository.existsById(id)) {
			contato.setID(id);
			_contatoRepository.save(contato);

			return new ResponseEntity<Contato>(contato, HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Contato> excluirContato(@PathVariable long id) {
		Optional<Contato> optionalContato = _contatoRepository.findById(id);

		if (optionalContato.isPresent()) {
			Contato contato = optionalContato.get();
			_contatoRepository.delete(contato);

			return new ResponseEntity<Contato>(contato, HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}
}
