package com.muhammet.jpa.repository;

import com.muhammet.jpa.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<Auth,Long> {
}
