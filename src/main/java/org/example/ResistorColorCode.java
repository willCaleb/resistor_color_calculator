package org.example;

import java.util.HashMap;
import java.util.Map;

public class ResistorColorCode {

    private static final Map<Character, String> DIGIT_COLORS = new HashMap<>();
    public static final Map<Character, Integer> MULTIPLIER = new HashMap<>();

    static {
        DIGIT_COLORS.put('0', "Preto");
        DIGIT_COLORS.put('1', "Marrom");
        DIGIT_COLORS.put('2', "Vermelho");
        DIGIT_COLORS.put('3', "Laranja");
        DIGIT_COLORS.put('4', "Amarelo");
        DIGIT_COLORS.put('5', "Verde");
        DIGIT_COLORS.put('6', "Azul");
        DIGIT_COLORS.put('7', "Violeta");
        DIGIT_COLORS.put('8', "Cinza");
        DIGIT_COLORS.put('9', "Branco");

        MULTIPLIER.put('0', 1);
        MULTIPLIER.put('k', 1000);
        MULTIPLIER.put('M', 1000000);
    }

    public static String[] getResistorColors(String resistorValue) {
        ResistorValueParser parser = new ResistorValueParser(resistorValue);
        int value = parser.parseResistorValue();
        return calculateColors(value);
    }

    private static String[] calculateColors(int value) {
        String valueString = String.valueOf(value);
        String[] colors = new String[3];

        for (int i = 0; i < 2; i++) {
            colors[i] = DIGIT_COLORS.get(valueString.charAt(i));
        }
        colors[2] = DIGIT_COLORS.get(valueString.length() - 2 >= 0 ? '0' : '1'); // Ajustar a cor do multiplicador

        return colors;
    }

    public static void main(String[] args) {
        String resistor = "47k ohms";
        String[] colors = getResistorColors(resistor);

        System.out.println("Cores do resistor: ");
        for (String color : colors) {
            System.out.println(color);
        }
    }
}