package org.scilab.forge.jlatexmath.graphics;

import org.robovm.apple.coregraphics.CGLineCap;
import org.robovm.apple.coregraphics.CGLineJoin;
import org.scilab.forge.jlatexmath.platform.graphics.BasicStroke;

public class BasicStrokeI implements BasicStroke{
	private float mWidth;
	private float mMiterLimit;
	private int mCap;
	private int mJoin;
	
	public BasicStrokeI(float width, float miterLimit, CGLineCap cap, CGLineJoin join) {
		this(width, miterLimit, getCap(cap), getJoin(join));
	}

	public BasicStrokeI(float width, float miterLimit, int cap, int join) {
		mWidth = width;
		mMiterLimit = miterLimit;
		mCap = cap;
		mJoin = join;
	}

	public float getWidth() {
		return mWidth;
	}

	public float getMiterLimit() {
		return mMiterLimit;
	}
	
	public CGLineCap getNativeCap() {
		switch (mCap) {
		case CAP_BUTT:
			return CGLineCap.Butt;
		case CAP_ROUND:
			return CGLineCap.Round;
		case CAP_SQUARE:
			return CGLineCap.Square;
		default:
			return CGLineCap.Butt;
		}
	}

	public CGLineJoin getNativeJoin() {
		switch (mJoin) {
		case JOIN_BEVEL:
			return CGLineJoin.Bevel;
		case JOIN_MITER:
			return CGLineJoin.Miter;
		case JOIN_ROUND:
			return CGLineJoin.Round;
		default:
			return CGLineJoin.Bevel;
		}
	}
	
	private static int getCap(CGLineCap cap) {
		switch (cap) {
		case Butt:
			return CAP_BUTT;
		case Round:
			return CAP_ROUND;
		case Square:
			return CAP_SQUARE;
		default:
			return CAP_BUTT;
		}
	}
	
	private static int getJoin(CGLineJoin join) {
		switch (join) {
		case Bevel:
			return JOIN_BEVEL;
		case Miter:
			return JOIN_MITER;
		case Round:
			return JOIN_ROUND;
		default:
			return JOIN_BEVEL;
		}
	}
}
