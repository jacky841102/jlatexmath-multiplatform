package org.scilab.forge.jlatexmath.geom;

import org.robovm.apple.coregraphics.CGPoint;
import org.scilab.forge.jlatexmath.platform.geom.Point2D;

public class Point2DI implements Point2D{
	private CGPoint point;

	public Point2DI(double x, double y) {
		point = new CGPoint((float) x, (float) y);
	}
	
	@Override
	public double getX() {
		// TODO Auto-generated method stub
		return point.getX();
	}

	@Override
	public double getY() {
		// TODO Auto-generated method stub
		return point.getY();
	}

	@Override
	public void setX(double x) {
		// TODO Auto-generated method stub
		point.setX(x);
	}

	@Override
	public void setY(double y) {
		// TODO Auto-generated method stub
		point.setY(y);
	}
}
