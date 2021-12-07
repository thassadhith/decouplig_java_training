package fr.lernejo.guessgame;

import java.util.Scanner;
import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

    public class HumanPlayer implements Player{
        public static final Scanner sc = new Scanner(System.in);
        private final Logger logger = LoggerFactory.getLogger("player");

        @Override
        public long askNextGuess() {
            boolean attempt;

            System.out.println(" type a value > ");
            String myuserinput = sc.nextLine();
            long guess = Long.parseLong(myuserinput);
            do {
                logger.log("number please ");
                myuserinput = sc.nextLine();
                try {
                    guess = Long.parseLong(myuserinput);
                    attempt = false;
                } catch (Exception e) {
                    logger.log("Enter a number.");
                    attempt = true;
                }
            } while (attempt);
            return guess;




        }

        @Override
        public void respond(boolean lowerOrGreater) {
            logger.log("input number was" + (lowerOrGreater ? "lower" : "greater"));

        }
    }

