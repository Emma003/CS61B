public class Deck {
    public static int[]cards;

    Deck() {
        cards = new int[]{1,3,4,10};
    }

    public static void main(String[]args) {
        Deck dingie = new Deck();
        dingie.cards[3] = 3;

        Deck p = new Deck();
        p.cards[3] = 3;

        int[] newArrWhoDis = {2, 2, 4, 1, 3};
        dingie.cards = p.cards;
        p.cards = newArrWhoDis;
        newArrWhoDis = null;


    }

}
