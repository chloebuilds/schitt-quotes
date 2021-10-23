package com.practice;

import com.practice.models.Quote;
import com.practice.models.SCCharacter;
import com.practice.repos.QuoteRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.List;
import java.util.Properties;

@SpringBootApplication
public class SchittQuotesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchittQuotesApplication.class, args);
	}

	@Bean
//	@Profile()
	CommandLineRunner commandLineRunner(QuoteRepo quoteRepo) {
		return args -> {
			Quote newQuote = new Quote();
			newQuote.setSchittQuote("Oh My God!");
			newQuote.setSchittCharacter("David Rose");

			Quote newQuote2 = new Quote();
			newQuote2.setSchittQuote("What you did was impulsive, capricious, and melodramatic. But, it was also wrong.");
			newQuote2.setSchittCharacter("Moira Rose");

			Quote newQuote3 = new Quote();
			newQuote3.setSchittQuote("Ew, David!");
			newQuote3.setSchittCharacter("Alexis Rose");

			Quote newQuote4 = new Quote();
			newQuote4.setSchittQuote("It's a nightshirt, David.");
			newQuote4.setSchittCharacter("Johnny Rose");

			quoteRepo.saveAll(List.of(newQuote, newQuote2));

			SCCharacter davidRose = new SCCharacter();
			davidRose.setName("David Rose");
			davidRose.setBio("The self-described black sheep of the family, David tries to cope with his unexpected exile with trademark bitterness. But his sarcasm belies a deep knowledge of design and aesthetic, a craftsman’s eye for detail, and an impressive business acumen; all of which he must put to use as he strives to find a place for himself in Schitt’s Creek.");
			davidRose.setImage("david-rose.jpg");

			SCCharacter moiraRose = new SCCharacter();
			moiraRose.setName("Moira Rose");
			moiraRose.setBio("Once she was the former star of a once-popular daytime soap opera, Sunrise Bay, where Moira's character Vivien Blake was best known for boldly slapping other characters when they got out of line. But now Moira has received her own slap in the face, having lost her fortune and most of her personal belongings, except for an extensive, and expensive, collection of eccentric outfits and individually named wigs.");
			moiraRose.setImage("moira-rose.jpg");

			SCCharacter alexisRose = new SCCharacter();
			alexisRose.setName("Alexis Rose");
			alexisRose.setBio("Now that Alexis is stuck in Schitt's Creek, her dating options are limited, but she does spend time with a rugged local named Mutt while serving community service for accidentally entering the Prada store inside a car. Alexis is kindhearted to a fault, which means that she's often juggling multiple relationships, and she loves to gossip about other people's lives, but she has nothing but good things to say about herself.");
			alexisRose.setImage("alexis-rose.jpg");

			SCCharacter johnnyRose = new SCCharacter();
			johnnyRose.setName("Johnny Rose");
			johnnyRose.setBio("Once proud of his reputation for spending money as fast as he made it with his business, now, his easy-going attitude and good temperament are tested, as he not only tries to rebuild his family’s financial empire, but his family as well.");
			johnnyRose.setImage("johnny-rose.jpg");

			characterRepo.saveAll(List.of(davidRose, moiraRose, alexisRose, johnnyRose));
		};
	}
}
