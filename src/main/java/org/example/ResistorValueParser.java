package org.example;

class ResistorValueParser {
    private final String resistorValue;

    public ResistorValueParser(String resistorValue) {
        this.resistorValue = resistorValue.replace(" ohms", "").replace(" ", "").toLowerCase();
    }

    public int parseResistorValue() {
        String digits = extractDigits();
        int multiplier = extractMultiplier();
        return Integer.parseInt(digits) * multiplier;
    }

    private String extractDigits() {
        StringBuilder digits = new StringBuilder();
        for (char c : resistorValue.toCharArray()) {
            if (Character.isDigit(c)) {
                digits.append(c);
            } else {
                break;
            }
        }
        return digits.toString();
    }

    private int extractMultiplier() {
        for (char c : resistorValue.toCharArray()) {
            if (!Character.isDigit(c)) {
                return ResistorColorCode.MULTIPLIER.getOrDefault(c, 1);
            }
        }
        return 1;
    }
}