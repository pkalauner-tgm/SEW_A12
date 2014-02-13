package hambergerkalaunerorosz;

/**
 * @author Hamberger Gregor
 * @version 0.5
 *
 */
public class ShiftCipher extends MonoalphabeticCipher {
	String SecretAlpha;
	
	/**
	 * @param value Der Wert um welchen das Alphabet verschoben werden soll.
	 */
	public ShiftCipher(int value) {
		//Erstellt ein Alphabet das gleichbleibt um das Geheimalphabet überschreiben zu können
		char[] alphatrue = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','ä','ö','ü','ß','a'};
		//Das Geheimalphabet
		char[] alpha = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','ä','ö','ü','ß'};
		
		if (value <0 || value>30) {
			throw new IllegalArgumentException("Fehler! Sie haben einen Wert kleiner 0 oder größer 30 eingegeben!");
		}
		
		for (int i = 0; i < 30; i++) {
			if (i + value > 30) { //Wenn er das Ende das Alphabets erreicht hat beginnt er von neu.
				alpha[i] = alphatrue[i + value - 30];
			} else {
				alpha[i] = alphatrue[i + value];
			}
		}
		
		SecretAlpha = new String(alpha);

	}

	/**
	 * @param shiftvalue
	 */
	public void setShiftAmount(int shiftvalue) {
		
	}
	
	public static void main(String[] args) {
		ShiftCipher a = new ShiftCipher(-10);
	}
}