package com.example.ApiClientes.interfaces;

import com.example.ApiClientes.domains.Cliente;
import io.micrometer.observation.ObservationFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<Cliente,Long> {

    Page<Cliente> findAllByAtivoTrue(Pageable paginacao);
}
