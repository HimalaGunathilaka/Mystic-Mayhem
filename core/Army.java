package core;

import java.util.HashMap;

import characters.Character;

public class Army {
    
    private HashMap<String, Character> armyCharacters;

    public Army() {
        armyCharacters = new HashMap<>();
    }

    public void battleArmy(Army army) {


    }

    public boolean hasCharacter(String category) {
        if (armyCharacters.containsKey(category)) {
            return true;
        }
        return false;
    }

    public void addCharacter(Character character) {
        armyCharacters.put(character.getCategory(), character);
    }


    // Print Methods

    public void printSimpleInfo() {
        for (String category : Character.getCharacterOrder()) {
            if (armyCharacters.containsKey(category)) {
                System.out.println(category + ": " + getCharacterName(category));
            }
        }
    }
    
    public void printInfo() {
        for (String category : Character.getCharacterOrder()) {
            if (armyCharacters.containsKey(category)) {

                System.out.println(category + ": " + getCharacterName(category));
            }
        }
    }

    // Getters

    public Character getCharacter(String category) {
        return armyCharacters.get(category);
    }

    public String getCharacterName(String category) {
        return getCharacter(category).getName();
    }

    public String getInfoString() {
        String info = "";
        for (String category : Character.getCharacterOrder()) {
            if (armyCharacters.containsKey(category)) {
                info += category + ": " + getCharacterName(category) + "  ";
            }
        }
        return info;
    }

}
