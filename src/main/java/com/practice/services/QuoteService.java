package com.practice.services;

import com.practice.models.Quote;
import com.practice.models.SCCharacter;
import com.practice.repos.QuoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class QuoteService {

    @Autowired
    private QuoteRepo quoteRepo;

    public Iterable<Quote> findAllQuotes() {
        return quoteRepo.findAll();
    }

    public Quote createQuote(Quote quote) {
        return quoteRepo.save(quote);
    }

    public Optional<Quote> findQuote(Integer quoteId) {
        Optional<Quote> optQuote = quoteRepo.findById(quoteId);
        if (optQuote.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No quote found");
        }
        return optQuote;
    }

    public void deleteQuote(Integer quoteId) {
        Optional<Quote> optQuote = quoteRepo.findById(quoteId);
        if (optQuote.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No quote found");
        }
        quoteRepo.deleteById(quoteId);
    }

    public Quote updateQuote(Integer quoteId, Quote quote) {
        Optional<Quote> optQuote = quoteRepo.findById(quoteId);
        if (optQuote.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No quote found");
        }
        Quote quoteToUpdate = optQuote.get();
        quoteToUpdate.setSchittQuote(quote.getSchittQuote());
        quoteToUpdate.setScCharacter(quote.getScCharacter());
        return quoteRepo.save(quoteToUpdate);
    }
}
