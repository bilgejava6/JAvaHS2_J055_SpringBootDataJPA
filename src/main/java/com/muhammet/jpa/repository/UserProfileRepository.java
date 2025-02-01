package com.muhammet.jpa.repository;

import com.muhammet.jpa.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Soru: interface ler den yeni bir nesne yaratılabilir mi?
 * new UserProfileRepository(); -  HAYIR
 */
public interface UserProfileRepository extends JpaRepository<UserProfile,Long> {

}
