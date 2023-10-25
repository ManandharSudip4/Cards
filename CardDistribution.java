import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDistribution {

  public List<List<String>> checkTrial(
    List<List<String>> players,
    int numPlayers
  ) {
    for (int i = 0; i < numPlayers; i++) {
      System.out.println("Player " + (i + 1) + " Hand: " + players.get(i));

      boolean trail = true;
      int index1 = players.get(i).get(0).indexOf(" ");
      String num = players.get(i).get(0).substring(0, index1);

      for (String card : players.get(i)) {
        int index = card.indexOf(" ");
        if (card.substring(0, index) != num) {
          trail = false;
        }
        System.out.println(card.substring(0, index));
      }

      if (trail) {
        System.out.println("Trail");
      } else {
        System.out.println("Not Trail");
      }

      //   players
      //     .get(i)
      //     .forEach(card -> {
      //       int index = card.indexOf(" ");
      //       if (card.substring(0, index) != num) {
      //         trial = true;
      //       }
      //       System.out.println(card.substring(0, index));
      //     });

      System.out.println("Colors");
      
      players
        .get(i)
        .forEach(card -> {
          int index = card.lastIndexOf(" ");
          System.out.println(card.substring(index + 1));
        });
    }

    return null;
  }

  public static void main(String[] args) {
    List<String> deck = new ArrayList<>();
    String[] suits = { "H", "D", "C", "S" };
    String[] ranks = {
      "2",
      "3",
      "4",
      "5",
      "6",
      "7",
      "8",
      "9",
      "10",
      "J",
      "Q",
      "K",
      "A",
    };

    // Create the deck
    for (String suit : suits) {
      for (String rank : ranks) {
        deck.add(rank + " of " + suit);
      }
    }

    // Shuffle the deck
    Collections.shuffle(deck);

    int numPlayers = 4; // Change this to the number of players you have
    int cardsPerPlayer = 3;

    // Create an array to represent the players and their hands
    List<List<String>> players = new ArrayList<>();
    for (int i = 0; i < numPlayers; i++) {
      players.add(new ArrayList<>());
    }

    // Distribute cards to players
    int currentPlayer = 0;
    for (int i = 0; i < numPlayers * cardsPerPlayer; i++) {
      String card = deck.remove(0); // Remove the top card from the deck
      players.get(currentPlayer).add(card); // Add the card to the current player's hand
      currentPlayer = (currentPlayer + 1) % numPlayers; // Move to the next player
    }

    // // Display each player's hand
    // for (int i = 0; i < numPlayers; i++) {
    //     System.out.println("Player " + (i + 1) + " Hand: " + players.get(i));
    //     System.out.println("Numbers Only");
    // }

    // Display each player's hand
    // for (int i = 0; i < numPlayers; i++) {
    //     System.out.println("Player " + (i + 1) + " Hand: " + players.get(i));

    //     System.out.println("Numbers");
    //     players.get(i).forEach(card -> {int index = card.indexOf(" "); System.out.println(card.substring(0, index));});
    //     System.out.println("Colors");
    //     players.get(i).forEach(card -> {int index = card.lastIndexOf(" "); System.out.println(card.substring(index+1));});
    // }

    CardDistribution myGame = new CardDistribution();
    myGame.checkTrial(players, numPlayers);
  }
}
