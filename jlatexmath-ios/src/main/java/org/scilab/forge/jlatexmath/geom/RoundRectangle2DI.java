package org.scilab.forge.jlatexmath.geom;

import org.robovm.apple.coregraphics.CGRect;
import org.scilab.forge.jlatexmath.platform.geom.RoundRectangle2D;

public class RoundRectangle2DI implements RoundRectangle2D {

	private CGRect mRect;
	private double mArcw;
	private double mArch;

	public RoundRectangle2DI(double x, double y, double w, double h, double arcw, double arch) {
		mRect = new CGRect();
		setRectangle(x, y, w, h);
		mArcw = arcw;
		mArch = arch;
	}

	public void setRectangle(double x, double y, double w, double h) {
		mRect = new CGRect((float)x, (float)y, (float)w, (float)h);
	}

	public double getArcW() {
		return mArcw;
	}

	public double getArcH() {
		return mArch;
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

	public CGRect getCGRect() {
		return mRect;
	}

	public void setRoundRectangle(double x, double y, double w, double h, double arcw, double arch) {
		setRectangle(x, y, w, h);
		mArcw = arcw;
		mArch = arch;
	}

}
