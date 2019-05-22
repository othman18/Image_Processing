
public class Camera {
	Point position, lookAtPoint;
	Vector upVector;
	public double screenDistance, screenWidth, screenHeight;
	public Vector cameraDirection, x_Axis, y_Axis;
	double imageWidth, imageHeight;

	public Camera(Point position, Point lookAtPoint, Vector upVector, double screenDistance, double screenWidth,
			int width, int height) {
		this.position = position;
		this.lookAtPoint = lookAtPoint;
		this.upVector = upVector;
		this.screenDistance = screenDistance;
		this.screenWidth = screenWidth;
		this.imageWidth = (double) width;
		this.imageHeight = (double) height;
		this.screenHeight = screenWidth * (imageHeight / imageWidth);
		translateAxises();

	}

	private void translateAxises() {
		cameraDirection = new Vector(position, lookAtPoint);
		cameraDirection.normalise();
		x_Axis = Vector.crossProduct(upVector, cameraDirection);// right
		y_Axis = Vector.crossProduct(cameraDirection, x_Axis);// upwards
	}

	/** the screen's origin */
	public Point findLeftLowerPoint() {
		Point p0 = Point.findPoint(position, cameraDirection, screenDistance);
		p0 = Point.findPoint(p0, y_Axis, -screenHeight / 2);
		p0 = Point.findPoint(p0, x_Axis, -screenWidth / 2);
		return p0;
	}

}