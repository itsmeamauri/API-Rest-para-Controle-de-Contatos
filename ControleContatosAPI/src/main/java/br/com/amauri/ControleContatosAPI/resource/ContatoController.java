package br.com.amauri.ControleContatosAPI.resource;

import java.util.Collections;
import java.util.List;
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

import br.com.amauri.ControleContatosAPI.DTO.ContatoDTO;
import br.com.amauri.ControleContatosAPI.Model.Contato;
import br.com.amauri.ControleContatosAPI.Model.Pessoa;
import br.com.amauri.ControleContatosAPI.repository.IContatoRepository;
import br.com.amauri.ControleContatosAPI.repository.IPessoaRepository;
import io.swagger.v3.oas.annotations.Operation;

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

    @Operation(summary = "Grava o registro de Contato")
    @PostMapping
    public ResponseEntity<Contato> salvarContato(@RequestBody ContatoDTO contato) {
        long pessoaId = contato.getPessoaId();

        Optional<Pessoa> objPessoa = _pessoaRepository.findById(pessoaId);
        if (!objPessoa.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Contato objContato = new Contato();
        objContato.setTipo(contato.getTipo());
        objContato.setContato(contato.getContato());
        objContato.setPessoa(objPessoa.get());

        _contatoRepository.save(objContato);

        return new ResponseEntity<Contato>(objContato, HttpStatus.CREATED);
    }

    @Operation(summary = "Busca todos os registros de Contato")
    @GetMapping
    public ResponseEntity<List<Contato>> getListaContatos() {
        List<Contato> contatos = (List<Contato>) _contatoRepository.findAll();
        if (contatos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contatos);
    }

    @Operation(summary = "Busca o registro de Contato por ID")
    @GetMapping("/{id}")
    public ResponseEntity<ContatoDTO> getContatoByID(@PathVariable long id) {
        Optional<Contato> objContato = _contatoRepository.findById(id);
        if (objContato.isPresent()) {
            ContatoDTO objDTO = new ContatoDTO(objContato.get().getID(), objContato.get().getTipo(),
                    objContato.get().getContato(), objContato.get().getPessoa().getID());
            return new ResponseEntity<ContatoDTO>(objDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Busca os registros de Contato por ID de Pessoa")
    @GetMapping("/pessoa/{idPessoa}")
    public ResponseEntity<List<Contato>> getContatosPessoaByID(@PathVariable long idPessoa) {
        Optional<Pessoa> objPessoa = _pessoaRepository.findById(idPessoa);
        if (!objPessoa.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        List<Contato> contatos = objPessoa.get().getContatos();
        if (contatos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contatos);
    }

    @Operation(summary = "Atualiza o registro de Contato por ID")
    @PutMapping("/{id}")
    public ResponseEntity<Contato> atualizaContato(@RequestBody Contato contato, @PathVariable long id) {
        if (_contatoRepository.existsById(id)) {
            contato.setID(id);
            _contatoRepository.save(contato);
            return new ResponseEntity<Contato>(contato, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Exclui o registro de Contato por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirContato(@PathVariable long id) {
        Optional<Contato> optionalContato = _contatoRepository.findById(id);
        if (optionalContato.isPresent()) {
            Contato contato = optionalContato.get();
            _contatoRepository.delete(contato);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

