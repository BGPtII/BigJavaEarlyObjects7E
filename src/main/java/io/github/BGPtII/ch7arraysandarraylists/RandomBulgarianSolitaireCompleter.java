package io.github.BGPtII.ch7arraysandarraylists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Game starts with 45 cards.
 * Game is played by first diving a deck of 45 cards (what is on the card doesn't matter) into a random number of
 * piles of random quantities, then a card is taken from each pile to form a new pile; the game is over when the pile
 * card quantities are { 1, 2, 3, 4, 5, 6, 7, 8, 9 } in any order.
 */
public class RandomBulgarianSolitaireCompleter {

    public static ArrayList<Integer> initialize() {
        Random random = new Random();
        int cardsLeftInDeck = 45;
        ArrayList<Integer> cardPileQuantities = new ArrayList<>();
        while (cardsLeftInDeck != 0) {
            int pileAmount = random.nextInt(cardsLeftInDeck) + 1;
            cardPileQuantities.add(pileAmount);
            cardsLeftInDeck-= pileAmount;
        }
        System.out.println(cardPileQuantities);
        return cardPileQuantities;
    }

    public static ArrayList<Integer> completeIteration(ArrayList<Integer> cardPileQuantities) {
        ArrayList<Integer> updatedPileQuantities = new ArrayList<>();
        int newPileCount = 0;
        for (Integer cardPileQuantity : cardPileQuantities) {
            int newQuantity = cardPileQuantity - 1;
            newPileCount++;
            if (newQuantity != 0) {
                updatedPileQuantities.add(newQuantity);
            }
        }
        updatedPileQuantities.add(newPileCount);
        return updatedPileQuantities;
    }

    public static void main(String[] args) {
        ArrayList<Integer> cardPileQuantities = initialize();
        List<Integer> endResult = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        while (!cardPileQuantities.containsAll(endResult)) {
            cardPileQuantities = completeIteration(cardPileQuantities);
            System.out.println(cardPileQuantities);
        }
    }
}
