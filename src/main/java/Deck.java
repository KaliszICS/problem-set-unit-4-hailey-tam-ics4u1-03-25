/**
 * Represents a deck of cards.
 * This class includes the size() method, draw() method, shuffle() method, addCard() method, and reshuffle() method.
 * @author Hailey Tam
 */
class Deck{
    private Card[] deckOfCards;

    /**
     * Creates a deck of cards that initalize an array of cards.
     * If the array of cards is null or empty, the deck will be empty.
     * @param cards an array of cards that represents the playing cards in the deck.
     */
    public Deck(Card[] cards){  
        this.deckOfCards = new Card[0];
        if (cards != null && cards.length != 0){
            int vaildLength = 0;
            for (int i = 0; i < cards.length; i++){
                if (cards[i] != null){
                vaildLength++;
                }
            }

            this.deckOfCards = new Card[vaildLength];
            for (int i = 0; i < cards.length; i++){
                if (cards[i] != null){
                    this.deckOfCards[i] = cards[i];
                    }
                }
            }
        }
    
    /**
     * Creates a default deck of cards with a standardize deck of 52 playing cards.
     * Goes from Ace to King in the order of suits: hearts, clubs, diamonds, and spades.
     * The playing cards are ranked by Ace having the lowest value (1) to King have the highest value (13).
     */
    public Deck(){
        this.deckOfCards = new Card[52];
        String[] names = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        String[] suits = {"hearts","clubs", "diamonds", "spades"};
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        int cardCounter = 0;   

        for (int i = 0; i < suits.length; i++){
            for (int j = 0; j < names.length; j++){
                this.deckOfCards[cardCounter++] = new Card(names[j], suits[i], values[j]);
            }
        }
    }

    /**
     * Determines the number of playing cards in the deck.
     * @return an integer that represents the number of cards in the deck.
     */
    public int size(){
        return this.deckOfCards.length;
    }

    /**
     * Draws only one card from the deck, which is the top card of the deck.
     * @return a Card object representing a playing card.
     */
    public Card draw(){
        if (size() == 0){
            return null;
        }

        Card cardDrawn = this.deckOfCards[size() - 1];
        Card[] cardsAfter = new Card[size() - 1];
        for (int i = 0; i < cardsAfter.length; i++){
            cardsAfter[i] = this.deckOfCards[i];
        }
        this.deckOfCards = cardsAfter;
        return cardDrawn;
    } 

    /**
     * Shuffles the deck of cards.
     * The number of times that the deck shuffles itself depends on the total amount of cards are in the deck.
     */
    public void shuffle(){
        for (int i = 0; i < size(); i++){
            int randomNum = (int) (Math.random()*size()-1) + 0;
            Card temp = this.deckOfCards[randomNum];
            this.deckOfCards[randomNum] = this.deckOfCards[i];
            this.deckOfCards[i] = temp;
            }
        }

    /**
     * Adds a playing card into the deck of cards.
     * @param card a Card object that represents a playing card.
     */
    public void addCard(Card card){
        if (card != null){
            Card[] newCards = new Card[size() + 1];
            for (int i = 0; i < size(); i++){
                newCards[i] = this.deckOfCards[i];
            }
            newCards[newCards.length - 1] = card;
            this.deckOfCards = newCards;
        }
    }
    
    /**
     * Resuffles the deck after adding in all the playing cards into the deck.
     * @param cards an array of cards that contains mulitple playing cards.
     */
    public void reshuffle(Card[] cards){
        if (cards != null && cards.length != 0){
            int vaildLength = 0;

            for (int i = 0; i < cards.length; i++){
                if (cards[i] != null){
                    vaildLength++;
                }
            }

            Card[] newCards = new Card[size() + vaildLength];
            int  validIndex = 0;
            for (int j = 0; j < size(); j++){
                newCards[validIndex++] = this.deckOfCards[j];
            }
        
            for (int k = 0; k < cards.length; k++){
                if (cards[k]!= null){
                    newCards[validIndex++] = cards[k];
                }
            }   
            this.deckOfCards = newCards;
        }
        shuffle();
    }
}