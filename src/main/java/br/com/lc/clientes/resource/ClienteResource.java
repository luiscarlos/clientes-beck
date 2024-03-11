package br.com.lc.clientes.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.lc.clientes.model.Cliente;
import br.com.lc.clientes.repository.ClienteRepository;
import br.com.lc.clientes.service.ClienteService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping("/api/clientes")
public class ClienteResource {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente salvar(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Cliente>> buscarPeloCodigo(@PathVariable Integer id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente != null ? ResponseEntity.ok(cliente) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Object> deletar(@PathVariable Integer id) {
		clienteRepository.deleteById(id);
		return ResponseEntity.noContent().build();

	}

	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Integer id, @RequestBody Cliente clienteAtualizado) {
		Cliente clienteSalvo = clienteService.atualizar(id, clienteAtualizado);
		return ResponseEntity.ok(clienteSalvo);

	}
	/*
	@PutMapping("/{id}")
	public void UPDATE(@PathVariable Integer id, @RequestBody Cliente clienteAtualizado) {
		clienteRepository.findById(id).map(cliente -> { clienteAtualizado.setId(cliente.getId());
			return clienteRepository.save(clienteAtualizado);
			
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

	}*/
	
	/*
	@PutMapping("/{id}")
	public void UPDATE(@PathVariable Integer id, @RequestBody Cliente clienteAtualizado) {
		clienteRepository.findById(id).map(cliente -> {
		 cliente.setNome(clienteAtualizado.getNome());
		 cliente.setCpf(clienteAtualizado.getCpf());
			return clienteRepository.save(clienteAtualizado);
			
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

	}*/
}
