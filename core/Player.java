package core;

import characters.Character;
import characters.CharacterMaker;

public class Player {
    private final String username;
    private String name;
    private float gold;
    private byte XP;
    private Army army;

    protected Player (String username, String name) {
        this.username = username;
        this.name = name;
        gold = 500;
        XP = 0;
        army = new Army();
    }


    // Getters

    public String getName() {
        return name;
    }
    public String getUsername() {
        return username;
    }
    public float getGold() {
        return gold;
    }
    public byte getXP() {
        return XP;
    }
    public String getArmy() {
        return army.getInfoString();
    }

    public void battleSomeone() {
        PlayerManager.getInstance().battleSomeone(this);
    }

    public void setHomeGround () {

    }

    public void buyCharacter(String category, int tier) {
        // Check if player already has someone of the category
        if (army.hasCharacter(category)) {
            System.out.println("You already have a " + category + " (" + army.getCharacterName(category) + ") in your army");
            return;
        }

        Character character = CharacterMaker.newCharacter(category, tier);

        // Check if player has enough gold
        if (character.getPrice() > gold) {
            System.out.println("You don't have enough Gold");
            return;
        }
        // Remove gold and add character to army
        army.addCharacter(character);
        addGold(-character.getPrice());
    }

    public void printArmySimpleInfo() {
        army.printSimpleInfo();
    }

    public void addGold (float amount) {
        gold += amount;
    }


/*
    public boolean addCharacter(Character character) {
        if (army.containsKey(character.getCategory())) {
            System.out.println("You already have " + character.getCategory() + " " + character.getName() + " in your Army");
            return false; // Indicate failure
        } else {
            army.put(character.getCategory(), character);
            return true; // Indicate success
        }
    }
    
    public void buyCharacter(String category, String name) {

    }
*/

}