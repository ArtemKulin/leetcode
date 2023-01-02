package detect_capital;

class Solution {
    public boolean detectCapitalUse(String word) {
        String lowerCase = word.toLowerCase();
        String upperCase = word.toUpperCase();
        boolean isFirstCapital = word.replaceFirst("^[A-Z]+[a-z]*$", "").isBlank();
        return word.equals(lowerCase) || word.equals(upperCase) || isFirstCapital;
    }
}