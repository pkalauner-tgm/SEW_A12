package hambergerkalaunerorosz;

public class Control {

	private View v;
	public Control(){
		this.v = new View(this);
	}
	public static void main(String[] args){
		new Control();
	}
}
