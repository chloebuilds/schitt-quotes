package com.practice.controllers;

import com.practice.models.Quote;
import com.practice.services.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@CrossOrigin("*")
@RestController
public class QuoteController {

    @Autowired
    private QuoteService quoteService;

    // FIND ALL
    @GetMapping("/quotes")
    public Iterable<Quote> getQuotes() {
        return quoteService.findAllQuotes();
    }

    // POST
    @PostMapping("/quotes")
    public Quote postQuote(@RequestBody Quote quote) {

        return quoteService.createQuote(quote);
    }

    // GET BY ID
    @GetMapping("/quotes/{quoteId}")
    public Optional<Quote> getQuote(@PathVariable Integer quoteId) {

        return quoteService.findQuote(quoteId);
    }

    // DELETE
    @DeleteMapping("/quotes/{quoteId}")
    public void deleteQuote(@PathVariable Integer quoteId) {

        quoteService.deleteQuote(quoteId);
    }

    // EDIT
    @PutMapping("/quotes/{quoteId}")
    public Quote putQuote(@PathVariable Integer quoteId,
                                   @RequestBody Quote quote) {
        return quoteService.updateQuote(quoteId, quote);
    }
}