package hambergerkalaunerorosz;

public class KeywordCipher extends MonoalphabeticCipher {
	
	public KeywordCipher(String keyword) {
		
        String keyfirst = keyword.toLowerCase().trim(); //Wandelt alle Buchstaben in Kleinbuschstaben um und entfernt führende und nachfolgende Leerzeichen.
		String keywordtrue = ""; // Ausgabe
        for (int i = 0; i < keyfirst.length(); i++) {
            int count = 0;
            for (int j = 0; j < keywordtrue.length(); j++) {
                if (keyfirst.charAt(i) == keywordtrue.charAt(j)) {
                    count++;
                }
            }
            if (count == 0) {
                keywordtrue = keywordtrue.concat(String.valueOf(keyfirst.charAt(i)));
            }
        }
        System.out.println(keywordtrue);
		
		
	}
	
	public void setKeyword(String keyword) {
		
	}
	
	public static void main(String[] args) {
		
		
	}

}
