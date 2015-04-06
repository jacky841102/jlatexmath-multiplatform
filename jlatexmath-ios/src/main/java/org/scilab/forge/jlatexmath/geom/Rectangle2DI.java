package org.scilab.forge.jlatexmath.geom;

import org.robovm.apple.coregraphics.CGRect;
import org.scilab.forge.jlatexmath.platform.geom.Rectangle2D;

public class Rectangle2DI implements Rectangle2D {

	private CGRect mRect;

	public Rectangle2DI(CGRect rect) {
		mRect = rect;
	}

	public Rectangle2DI(double x, double y, double w, double h) {
		setRectangle(x, y, w, h);
	}
	
	public void setRectangle(double x, double y, double width, double height) {
		// TODO Auto-generated method stub
		mRect = new CGRect((float)x, (float)y, width, height);
	}


	public CGRect getCGRect() {
		return mRect;
	}

	public double getX() {
		return mRect.getOrigin().getX();
	}

	public double getY() {
		return mRect.getOrigin().getY();
	}

	public double getWidth() {
		return mRect.getWidth();
	}

	public double getHeight() {
		return mRect.getHeight();
	}

}
