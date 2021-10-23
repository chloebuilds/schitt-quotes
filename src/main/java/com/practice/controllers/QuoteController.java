package com.practice.controllers;

import com.practice.models.Quote;
import com.practice.services.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
public class QuoteController {

    @Autowired
    private QuoteService quoteService;

    @GetMapping("/quotes")
    public Iterable<Quote> getQuotes() {
        return quoteService.findAllQuotes();
    }

    @PostMapping("/quotes")
    public Quote postQuote(@RequestBody Quote quote) {

        return quoteService.createQuote(quote);
    }
    @GetMapping("/quotes/{quoteId}")
    public Optional<Quote> getQuote(@PathVariable Integer quoteId) {

        return quoteService.findQuote(quoteId);
    }

    @DeleteMapping("/quotes/{quoteId}")
    public void deleteQuote(@PathVariable Integer quoteId) {

        quoteService.deleteQuote(quoteId);
    }

    @PutMapping("/quotes/{quoteId}")
    public Quote putQuote(@PathVariable Integer quoteId,
                                   @RequestBody Quote quote) {
        return quoteService.updateQuote(quoteId, quote);
    }
}