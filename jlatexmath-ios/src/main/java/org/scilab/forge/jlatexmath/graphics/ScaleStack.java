package org.scilab.forge.jlatexmath.graphics;

import java.util.ArrayList;
import java.util.List;

import org.robovm.apple.coregraphics.CGPoint;
import org.robovm.apple.coregraphics.CGRect;
import org.robovm.apple.coregraphics.CGSize;

public class ScaleStack {

	private List<Float> mScaleStackX;
	private List<Float> mScaleStackY;

	public ScaleStack() {
		mScaleStackX = new ArrayList<Float>();
		mScaleStackX.add(1.0f);
		mScaleStackY = new ArrayList<Float>();
		mScaleStackY.add(1.0f);
	}

	public void appendScale(float sx, float sy) {
		float x = scaleX(sx);
		float y = scaleY(sy);
		mScaleStackX.set(getScaleStackXTopIndex(), x);
		mScaleStackY.set(getScaleStackYTopIndex(), y);
	}

	public float getScaleX() {
		return mScaleStackX.get(getScaleStackXTopIndex());
	}

	public float getScaleY() {
		return mScaleStackY.get(getScaleStackYTopIndex());
	}

	public void pushScaleValues() {
		mScaleStackX.add(getScaleX());
		mScaleStackY.add(getScaleY());
	}

	public void popScaleValues() {
		mScaleStackX.remove(getScaleStackXTopIndex());
		mScaleStackY.remove(getScaleStackYTopIndex());
	}

	private int getScaleStackXTopIndex() {
		return mScaleStackX.size() - 1;
	}

	private int getScaleStackYTopIndex() {
		return mScaleStackY.size() - 1;
	}

	public float scaleX(float x) {
		return x * getScaleX();
	}

	public float scaleY(float y) {
		return y * getScaleY();
	}

	public float scaleFontSize(float size) {
		return Math.min(getScaleX(), getScaleY()) * size;
	}

	public CGRect scaleCGRect(CGRect rect) {
		//rect.bottom *= getScaleY();
		//rect.top *= getScaleY();
		//rect.left *= getScaleX();
		//rect. *= getScaleX();
		double x = rect.getOrigin().getX();
		double y = rect.getOrigin().getY();
		double buttomScale = getScaleY();
		double topScale = getScaleY();
		double leftScale = getScaleX();
		double rightScale = getScaleX();
		rect = new CGRect(x * leftScale, y * topScale + 40, 
				rect.getWidth() * rightScale, rect.getHeight());
		return rect;
	}

	public CGPoint scalePointF(CGPoint point) {
		point.setX(point.getX()*getScaleX());
		point.setY(point.getY()*getScaleY());
		return point;
	}

//	public Bitmap scaleBitmap(Bitmap bitmap) {
//		int scaledWidth = Math.round(scaleX(bitmap.getWidth()));
//		int scaledHeight = Math.round(scaleY(bitmap.getHeight()));
//		return Bitmap.createScaledBitmap(bitmap, scaledWidth, scaledHeight,
//				false);
//	}
}