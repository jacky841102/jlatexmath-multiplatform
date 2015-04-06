package org.scilab.forge.jlatexmath.graphics;

import org.robovm.apple.coregraphics.CGContext;
import org.robovm.apple.coregraphics.CGRect;
import org.robovm.apple.uikit.UIImage;
import org.scilab.forge.jlatexmath.platform.graphics.Graphics2DInterface;
import org.scilab.forge.jlatexmath.platform.graphics.Image;

public class ImageI implements Image{

	private UIImage mUIImage;
	private CGContext mCGContext;
	
	public ImageI(){
		mUIImage = new UIImage();
	//	mCGContext = cgContext;
	}
	
	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return (int) mUIImage.getSize().getWidth();
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return (int) mUIImage.getSize().getHeight();
	}

	public Graphics2DInterface createGraphics2D(CGContext context, CGRect frame) {
		// TODO Auto-generated method stub
		mCGContext = context;
		return new Graphics2DI(mCGContext, frame, mUIImage);
	}
	
	public UIImage getUIImage(){
		return mUIImage;
	}

	@Override
	public Graphics2DInterface createGraphics2D() {
		// TODO Auto-generated method stub
		return null;
	}

}
