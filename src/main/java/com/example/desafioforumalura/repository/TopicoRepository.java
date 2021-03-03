package com.example.desafioforumalura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.desafioforumalura.modelo.Topico;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {

}
