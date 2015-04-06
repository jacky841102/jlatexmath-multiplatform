package org.scilab.forge.jlatexmath.graphics;

import org.robovm.apple.coregraphics.CGAffineTransform;
import org.scilab.forge.jlatexmath.platform.graphics.Transform;

public class TransformI implements Transform {

	private CGAffineTransform mCGAffineTransformTranslate;
	private CGAffineTransform mCGAffineTransformScale;
	private CGAffineTransform mCGAffineTransformShear;

	public TransformI() {
		mCGAffineTransformTranslate = new CGAffineTransform();
		mCGAffineTransformScale = new CGAffineTransform();
		mCGAffineTransformShear = new CGAffineTransform();
	}
	
	public TransformI(CGAffineTransform transformTranslate, CGAffineTransform transformScale, CGAffineTransform transformShear){
		mCGAffineTransformTranslate = transformTranslate;
		mCGAffineTransformScale = transformScale;
		mCGAffineTransformShear = transformShear;
	}
	
	public Object getNativeObject() {
		return this;
	}

	public double getTranslateX() {
		return mCGAffineTransformTranslate.getTx();
	}

	public double getTranslateY() {
		return mCGAffineTransformTranslate.getTy();
	}

	public double getScaleX() {
		return mCGAffineTransformScale.getTx();
	}

	public double getScaleY() {
		return mCGAffineTransformScale.getTy();
	}

	public double getShearX() {
		return mCGAffineTransformShear.getTx();
	}

	public double getShearY() {
		return mCGAffineTransformShear.getTy();
	}

	public Transform createClone() {
		return new TransformI(mCGAffineTransformTranslate, mCGAffineTransformScale, mCGAffineTransformShear);
	}

	public void scale(double sx, double sy) {
		mCGAffineTransformScale.setTx((float)sx);
		mCGAffineTransformScale.setTy((float)sy);
	}

	public void translate(double tx, double ty) {
		mCGAffineTransformTranslate.setTx((float)tx);
		mCGAffineTransformTranslate.setTy((float)ty);
	}

	public void shear(double sx, double sy) {
		mCGAffineTransformShear.setTx((float)sx); 
		mCGAffineTransformShear.setTy((float)sy);
	}

}
