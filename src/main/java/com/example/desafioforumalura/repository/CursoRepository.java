package com.example.desafioforumalura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.desafioforumalura.modelo.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

}
