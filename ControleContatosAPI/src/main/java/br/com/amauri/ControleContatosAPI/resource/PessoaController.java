package br.com.amauri.ControleContatosAPI.resource;

import java.util.Optional;

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

import br.com.amauri.ControleContatosAPI.DTO.PessoaMalaDireta;
import br.com.amauri.ControleContatosAPI.Model.Contato;
import br.com.amauri.ControleContatosAPI.Model.Pessoa;
import br.com.amauri.ControleContatosAPI.repository.IContatoRepository;
import br.com.amauri.ControleContatosAPI.repository.IPessoaRepository;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value = "api/pessoas")
public class PessoaController {

	private IPessoaRepository _pessoaRepository;

	@Autowired
	public PessoaController(IPessoaRepository pessoaRepository) {
		this._pessoaRepository = pessoaRepository;

	}
	
	@Operation(summary = "Grava o registro de Pessoa")
	@PostMapping
	public ResponseEntity<Pessoa> salvarPessoa(@RequestBody Pessoa pessoa) {

		Pessoa pessoaCreated = _pessoaRepository.save(pessoa);
		return new ResponseEntity<Pessoa>(pessoaCreated, HttpStatus.CREATED);

	}
	
	@Operation(summary = "Busca o registro por ID de Pessoa")
	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> getPessoaByID(@PathVariable long id) {

		Optional<Pessoa> objPessoa = _pessoaRepository.findById(id);
		Pessoa PessoaCreated = objPessoa.get();

		return new ResponseEntity<Pessoa>(PessoaCreated, HttpStatus.OK);

	}

	@Operation(summary = "Busca os registros de Pessoa por ID para mala direta")
	@GetMapping("/maladireta/{id}")
	public ResponseEntity<PessoaMalaDireta> getPessoaMalaDiretaByID(@PathVariable long id) {

		Optional<Pessoa> objPessoa = _pessoaRepository.findById(id);

		Pessoa PessoaCreated = objPessoa.get();

		String malaDireta = String.format("%s – CEP: %s – %s/%s", PessoaCreated.getEndereco(), PessoaCreated.getCEP(),
				PessoaCreated.getCidade(), PessoaCreated.getUF());

		PessoaMalaDireta pessoaMalaDireta = new PessoaMalaDireta(PessoaCreated.getID(), PessoaCreated.getNome(),
				malaDireta);

		return new ResponseEntity<PessoaMalaDireta>(pessoaMalaDireta, HttpStatus.OK);

	}
	
	@Operation(summary = "Busca todos os registros de Pessoa")
	@GetMapping
	public Iterable<Pessoa> getpessoa() {

		return _pessoaRepository.findAll();

	}

	@Operation(summary = "Atualiza o registro de Pessoa. Validação por ID")
	@PutMapping("/{id}")
	public ResponseEntity<Pessoa> atualizaPessoa(@RequestBody Pessoa pessoa, @PathVariable long id) {

		if (_pessoaRepository.existsById(id)) {
			pessoa.setID(id);
			_pessoaRepository.save(pessoa);

			return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);

		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@Operation(summary = "Exclui o registro de Pessoa por ID ")
	@DeleteMapping("/{id}")
	public ResponseEntity<Pessoa> excluirPessoa(@PathVariable long id) {
		Optional<Pessoa> optionalPessoa = _pessoaRepository.findById(id);

		if (optionalPessoa.isPresent()) {
			Pessoa pessoa = optionalPessoa.get();
			_pessoaRepository.delete(pessoa);

			return new ResponseEntity<Pessoa>(HttpStatus.OK);

		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}
}
