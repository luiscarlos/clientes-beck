package br.com.lc.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lc.clientes.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
