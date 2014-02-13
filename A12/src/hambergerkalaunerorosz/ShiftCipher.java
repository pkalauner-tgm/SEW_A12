package hambergerkalaunerorosz;

/**
 * @author Hamberger Gregor
 * @version 0.5
 * 
 */
public class ShiftCipher extends MonoalphabeticCipher {
	private int shiftAmount;

	/**
	 * Konstruktor mit Definition der Verschiebungszahl
	 * @param value
	 *            Der Wert um welchen das Alphabet verschoben werden soll.
	 */
	public ShiftCipher(int value) {
		// Erstellt ein Alphabet das gleichbleibt um das Geheimalphabet überschreiben zu können
		char[] alphatrue = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
				'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
				'w', 'x', 'y', 'z', 'ä', 'ö', 'ü', 'ß', 'a' };
		// Das Geheimalphabet
		char[] alpha = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
				'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
				'x', 'y', 'z', 'ä', 'ö', 'ü', 'ß' };

		if (value < 0) {
			throw new IllegalArgumentException(
					"Fehler! Sie haben einen Wert kleiner als 0 eingegeben!");
		}

		setShiftAmount(reduceInt(value));

		for (int i = 0; i < 30; i++) {
			if (i + this.shiftAmount > 30) { 
				// Wenn er das Ende das Alphabets erreicht hat beginnt er von neu.
				alpha[i] = alphatrue[i + this.shiftAmount - 30];
			} else {
				alpha[i] = alphatrue[i + this.shiftAmount];
			}
		}

		super.setSecretAlphabet(new String(alpha));

	}

	/**
	 * Setzt die Verschiebungsanzahl
	 * 
	 * @param shiftvalue
	 *            Verschiebung
	 */
	public void setShiftAmount(int shiftvalue) {
		this.shiftAmount = shiftvalue;
	}

	/**
	 * Verkleinert den angegebenen Wert. z.B: 33-->3
	 * 
	 * @param value
	 * @return gekürzter int Wert
	 */
	private int reduceInt(int value) {
		while (value > 29) {
			value = value % 30;
		}
		return value;
	}

	/**
	 * Testmethode
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Cipher sc = new ShiftCipher(12);
		String encrypted = sc.encrypt("abcdefghijklmnopqrstuvwxyzäöüß");
		System.out.println(encrypted);
		System.out.println(sc.decrypt(encrypted));
	}
}