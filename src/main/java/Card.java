/**
 * Represents a card.
 * Each card has a specific name, suit and value.
 * This class includes the toString() method and equals() method.
 * @author Hailey Tam
 */
class Card{
    private String name;
    private String suit;
    private int value;

    /**
     * Creates a card that initalize the card's name, suit and value.
     * @param name A string that represents the card's name.
     * @param suit A string that represents the suit of the card.
     * @param value A integer that represents the ranking of the card.
     */
    public Card(String name, String suit, int value){
        if (name != null){
            this.name = name;
            }
            else{
                this.name = "0";
            }

        if (suit != null){
            this.suit = suit;
            }
            else {
                this.suit = "blank";
            }

        this.value = value;
    }

    /**
     * Gets the card's name.
     * @return A string representing the card's name.
     */
    public String getName(){
        return this.name;
    }

    /**
     * Gets the card's suit.
     * @return A string representing the card's suit.
     */
    public String getSuit(){
        return this.suit;
    }

    /**
     * Gets the card's value.
     * @return An integer representing the card's ranking.
     */
    public int getValue(){
        return this.value;
    }

    @Override
    public String toString(){
        return this.name + " of " + this.suit;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null || getClass() != obj.getClass()){
            return false; 
        }

        Card card = (Card)obj;
        if (card.getName().equals(this.name) && card.getSuit().equals(this.suit) && card.getValue() == this.value){
            return true;
        }
        return false;
    }
}