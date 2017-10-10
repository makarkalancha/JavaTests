package com.everything.algorithms.byRobertLafore.ch08;

import java.util.Map;
import java.util.TreeMap;

/**
 * User: Makar Kalancha
 * Date: 13/01/2015
 * Time: 11:43
 */
public class FrequencyTable {
    private TreeMap<Character, Integer> _table = new TreeMap<>();
    private String _text;

    public FrequencyTable(String text) {
        this._text = text;
    }

    public static void main(String[] args) {
        String text = "SUSIE SAYS IT IS EASY";
        FrequencyTable ft = new FrequencyTable(text);
        ft.displayTable();

    }

    private void fillTable() {
        for (int i = 0; i < _text.length(); i++) {
            Character character = _text.charAt(i);
            int count = 0;
            if(_table.containsKey(character)) {
                count = _table.get(character);
            }
            _table.put(character, ++count);
        }
    }

    public void displayTable() {
        if (_table.isEmpty()) {
            fillTable();
        }

        for (Map.Entry<Character,Integer> entry : _table.entrySet()) {
            char character = entry.getKey();
            System.out.println(character + ": " + entry.getValue() + " -> " + Integer.toBinaryString((int) character));
        }
    }

    public void refillTable() {
        _table = new TreeMap<>();
        fillTable();
    }

}
