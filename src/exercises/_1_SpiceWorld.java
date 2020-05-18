package exercises;

/*
 * @author Yvonne Davis
 * @version 1
 */
import java.util.function.Consumer;

/*
 * @author Yvonne Davis
 * @version 1
 */
public class _1_SpiceWorld {
	/*
	 * Replace the anonymous inner class with a lambda expression.
	 */

	// function that defines entertainment backflips
	static Consumer<Integer> performFlips = (x) -> System.out.println("Do backflips.");

	public static void main(String[] args) {

		SpiceGirl sporty = new SpiceGirl();

		// sporty.setEntertainmentType((x) -> System.out.println("Do backflips."));
		// set entertainment type for sporty spice, which is backflips and call it by
		// perform method
		sporty.setEntertainmentType(performFlips);
		sporty.perform();

	}

}

class SpiceGirl {
	// define entertainment instance - Functional Interface
	private Consumer<Integer> entertainmentType;

	// entertainment setter
	public void setEntertainmentType(Consumer<Integer> entertainmentType) {
		this.entertainmentType = entertainmentType;
	}

	// abstract method perform
	void perform() {
		entertainmentType.accept(0);
	}
}

//@FunctionalInterface
//interface SpiceGirl {
//	void perform();
//}
