package br.com.lc.clientes.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import br.com.lc.clientes.model.entity.Cliente;
import br.com.lc.clientes.repository.ClienteRepository;

@org.springframework.stereotype.Service
public class ClienteService {
	
	
	@Autowired
	private ClienteRepository pessoaRepository;

	public Cliente atualizar(Integer id, Cliente cliente) {
		Cliente clienteSalvo = buscarPessoaPeloCodigo(id);
		
		BeanUtils.copyProperties(cliente, clienteSalvo, "id");
		return pessoaRepository.save(clienteSalvo);
	}

	
	public Cliente buscarPessoaPeloCodigo(Integer id) {
		Cliente clienteSalvo = pessoaRepository.findById(id).get();
		if (clienteSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return clienteSalvo;
	}
}
