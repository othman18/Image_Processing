import myUtils.*;
import surfaces.*;
//new branch test
public class exec {
	public static void main(String[] args) {
		Vector v1 = new Vector(1, 2, 3);
		Point p1 = new Point(1, 2, 3);
		Surfaces s1 = new Sphere(p1, 0);
		Surfaces s2 = new Triangle(v1, v1, v1);
		Surfaces s3 = new InfinitePlane(10,20,30,0);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
	}
}
