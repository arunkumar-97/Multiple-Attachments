package com.jesperapps.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jesperapps.api.model.ConfirmationToken;

public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Integer> {

}
