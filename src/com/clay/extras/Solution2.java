package extras;

//overlap area of two rectangle
public class Solution2 {

	private static int getOverlapArea(Rectangle r1, Rectangle r2) {

		Coord c1 = new Coord(r1.getbLeft().xy1, r2.getbLeft().xy1);
		Coord c2 = new Coord(r1.gettRight().xy1, r2.gettRight().xy1);
		int overlapWidth = getDistance(c1, c2);
		if (overlapWidth <= 0) {
			return -1;
		}
		Coord c3 = new Coord(r1.getbLeft().xy2, r2.getbLeft().xy2);
		Coord c4 = new Coord(r1.gettRight().xy2, r2.gettRight().xy2);
		int overlapHeight = getDistance(c3, c4);
		if (overlapHeight <= 0) {
			return -1;
		}
		return overlapWidth * overlapHeight;
	}

	private static int getDistance(Coord c1, Coord c2) {
		int maxWidth = Math.max(c1.xy1, c1.xy2);
		int minWidth = Math.min(c2.xy1, c2.xy2);
		return minWidth - maxWidth;
	}

	public static void main(String[] args) {
		Rectangle r1 = new Rectangle(new Coord(2, 2), new Coord(5, 5));
		Rectangle r2 = new Rectangle(new Coord(3, 3), new Coord(6, 6));

		int overlapArea = getOverlapArea(r1, r2);
		System.out.println(overlapArea);
	}
}

class Rectangle {

	private Coord bLeft;
	private Coord tRight;

	public Rectangle(Coord c1, Coord c2) {
		this.bLeft = c1;
		this.tRight = c2;
	}

	public Coord Coord() {
		return bLeft;
	}

	public Coord gettRight() {
		return tRight;
	}

	public Coord getbLeft() {
		return bLeft;
	}

}

class Coord {
	int xy1, xy2;

	public Coord(int x, int y) {
		this.xy1 = x;
		this.xy2 = y;
	}
}