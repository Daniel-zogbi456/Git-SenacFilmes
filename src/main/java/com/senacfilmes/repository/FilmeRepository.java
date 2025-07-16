package com.senacfilmes.repository;

import com.senacfilmes.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
}
