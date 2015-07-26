package codeCampPZ1;

import java.awt.Point;

public class Line {

	Point startPoint, endPoint;
	int x1, y1, x2, y2;
	
	Line(Point sPoint, Point ePoint){
		this.startPoint = sPoint;
		this.endPoint = ePoint;
		
		this.x1 = sPoint.x;
		this.y1 = sPoint.y;
		this.x2 = ePoint.x;
		this.y2 = ePoint.y;
		
	}
}
