package com.practice.repos;

import com.practice.models.Quote;
import com.practice.models.SCCharacter;
import org.springframework.data.repository.CrudRepository;

public interface QuoteRepo extends CrudRepository<Quote, Integer> {
}
