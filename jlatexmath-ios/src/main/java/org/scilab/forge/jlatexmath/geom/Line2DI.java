package org.scilab.forge.jlatexmath.geom;

import org.robovm.apple.coregraphics.CGPoint;
import org.scilab.forge.jlatexmath.platform.geom.Line2D;

public class Line2DI implements Line2D{
	private CGPoint start;
	private CGPoint end;
	
	public Line2DI(double x1, double y1, double x2, double y2) {
		start = new CGPoint();
		end = new CGPoint();
		setLine(x1, y1, x2, y2);
	}

	public void setLine(double x1, double y1, double x2, double y2) {
		start.setX((float)x1);
		start.setY((float)y1);
		end.setX((float)x2);
		end.setY((float)y2);
	}

	public CGPoint getStartPoint() {
		return start;
	}
	
	public CGPoint getEndPoint() {
		return end;
	}

	public double getX1() {
		return start.getX();
	}

	public double getY1() {
		return start.getY();
	}

	public double getX2() {
		return end.getX();
	}

	public double getY2() {
		return end.getY();
	}
}
