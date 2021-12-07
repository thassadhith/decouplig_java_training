package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

    public class Simulation {

        private final Logger logger = LoggerFactory.getLogger("simulation");
        private final Player player;//TODO add variable type
        private long numberToGuess;//TODO add variable type
        private long maximum;

        public Simulation(Player player) {
            this.player = player;//TODO add variable type
            this.numberToGuess = 0;
            this.maximum = 0;
        }

        public void initialize(long numberToGuess, long maxTry) {
            this.numberToGuess = numberToGuess;//TODO add variable type
            this.maximum = maxTry;
        }

        /**
         * @return true if the player have guessed the right number
         */
        private boolean nextRound() {
            long userGuess = player.askNextGuess();

            if (userGuess == numberToGuess) return true;
            else {
                player.respond(userGuess < numberToGuess);
            }
            return false;
        }

        public void loopUntilPlayerSucceed(long maxValue) {
            boolean game_continue;//TODO add variable type
            int number_increment = 0;

            long starting_game = System.currentTimeMillis();
            do {
                number_increment++;
                game_continue = nextRound();
            } while (!game_continue && number_increment < maximum);
            long ending_game = System.currentTimeMillis();

            long time_result = ending_game - starting_game;

            if (game_continue) {
                logger.log("well done!");
                logger.log("The number was " + numberToGuess);
                logger.log("It took you");
                logger.log(number_increment + " try again.");
            } else logger.log("not good " + numberToGuess);

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss.SSS"); // pattern for date
            Date resultTime = new Date(time_result);
            logger.log("Time: " + simpleDateFormat.format(resultTime));
        }

        public void initialize(long randomNumber) {
        }
    }

