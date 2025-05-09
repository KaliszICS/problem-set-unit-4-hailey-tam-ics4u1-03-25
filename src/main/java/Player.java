/**
 * Represents a player.
 * Each player has a specific name, age, and playing hand.
 * This class includes a draw() method, discardCard() method, returnCard() method, and toString() method.
 * @author Hailey Tam
 */
public class Player {
    private String name;
    private int age;
    private Card[] hand;

    /**
     * Creates a player object that initalize player's name, age and an array of cards.
     * If the array of cards is empty or null, the player's hand will be empty.
     * @param name a string that represents the player's name.
     * @param age a integer that represents the player's age in years.
     * @param cards a card array that contains playing cards in the player's hand.
     */
    public Player(String name, int age, Card[] cards){
       this.name = name;
       this.age = age;

       this.hand = new Card[0];
       if (cards != null && cards.length != 0){
            int vaildLength = 0;
            for (int i = 0; i < cards.length; i++){
                if (cards[i] != null){
                    vaildLength++;
                }
            }

            Card[] newCards = new Card[vaildLength];
            int validIndex = 0;
            for (int i = 0; i < cards.length; i++){
                if (cards[i] != null){
                    newCards[validIndex++] = cards[i];
                }
            }
            this.hand = newCards;
        }
    }

    /**
     * Creates a player that initalize player's name and age.
     * The player's hand has no playing cards by default.
     * @param name a string that represents the player's name
     * @param age an integer that represents the player's age in years
     */
    public Player(String name, int age){
        this.name = name;
        this.age = age;
        this.hand = new Card[0];
    }
    
    /**
     * Determines the number of playing cards in a player´s hand.
     * @return an integer of the number of playing cards in a player´s hand.
     */
    public int size(){
        return this.hand.length;
    }

    /**
     * Draws one card from the deck of cards and adds it to the player's hand.
     * @param deck a deck Object representing the deck of cards.
     */
    public void draw(Deck deck){
        Card card = deck.draw();
        if (card != null){
            Card[] newHands = new Card[size() + 1];
            for (int i = 0; i < size(); i++){
                newHands[i] = this.hand[i];
            }
        newHands[newHands.length - 1] = card;
        this.hand = newHands;
        }
    }

    /**
     * Discards the first occurance of the specific card from the hand to the deck's discard pile.
     * @param card a Card object representing a playing card.
     * @param discardPile a discard pile object that represents the discard pile.
     * @return a boolean that if true represents the card existed in the players hand, otherwise false.
     */
    public boolean discardCard(Card card, DiscardPile discardPile){
        int index = -1;
        if (card != null){
            for (int i = 0; i < size(); i++){
                if (card.equals(this.hand[i])){
                    index = i;
                    i = size();
                } 
            }
        }

        if (index == -1){
            return false;
        }
        
        Card[] newHands = new Card[size() - 1];
        int validIndex = 0;
        for (int j = 0; j < size(); j++){
            if (j != index){
                newHands[validIndex++] = this.hand[j];
            }
        }
        this.hand = newHands;
        discardPile.addCard(card);
        return true;
    }

    /**
     * Returns a specific card from a player´s hand to the deck of cards.
     * @param card a Card object that represents a playing card.
     * @param deck a Deck object that represents the deck of cards.
     * @return a boolean that if true represents the card existed in the players hand, otherwise false.
     */
    public boolean returnCard(Card card, Deck deck){
        int index = -1;
        if (card != null){
         for (int i = 0; i < size(); i++){
                if (card.equals(this.hand[i])){
                    index = i;
                    i = size();
                } 
            }
        }

        if (index == -1){
            return false;
        }

        int validIndex = 0;
        Card[] newHands = new Card[size() - 1];
        for (int j = 0; j < size(); j++){
            if (j != index){
                newHands[validIndex++] = this.hand[j];
            }
        }
        this.hand = newHands;
        deck.addCard(card);
        return true;
    }

    @Override
    public String toString(){
        String playerHands = this.name + ", " + this.age + ", ";
        for (int i = 0; i < size() - 1; i++){
            playerHands += this.hand[i].toString() + ", ";
        }
        playerHands += this.hand[size() - 1].toString() + ".";
        return playerHands;
        }
    }