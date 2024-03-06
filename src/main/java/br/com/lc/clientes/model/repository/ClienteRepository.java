package br.com.lc.clientes.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lc.clientes.model.entity.Cliente;



public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
