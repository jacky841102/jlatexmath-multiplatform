package org.scilab.forge.jlatexmath.graphics;

import java.io.IOException;

import org.robovm.apple.coregraphics.CGContext;
import org.robovm.apple.coregraphics.CGPoint;
import org.robovm.apple.coregraphics.CGRect;
import org.robovm.apple.foundation.NSString;
import org.robovm.apple.uikit.NSAttributedStringAttributes;
import org.robovm.apple.uikit.NSStringDrawingContext;
import org.robovm.apple.uikit.NSStringDrawingOptions;
import org.robovm.apple.uikit.UIFont;
import org.robovm.apple.uikit.UIGraphics;
import org.robovm.apple.uikit.UIImage;
import org.robovm.apple.uikit.UIImageView;
import org.robovm.apple.uikit.UIView;
import org.scilab.forge.jlatexmath.ColorUtil;
import org.scilab.forge.jlatexmath.font.FontI;
import org.scilab.forge.jlatexmath.font.FontRenderContextI;
import org.scilab.forge.jlatexmath.geom.Line2DI;
import org.scilab.forge.jlatexmath.geom.Rectangle2DI;
import org.scilab.forge.jlatexmath.geom.RoundRectangle2DI;
import org.scilab.forge.jlatexmath.platform.font.Font;
import org.scilab.forge.jlatexmath.platform.font.FontRenderContext;
import org.scilab.forge.jlatexmath.platform.geom.Line2D;
import org.scilab.forge.jlatexmath.platform.geom.Rectangle2D;
import org.scilab.forge.jlatexmath.platform.geom.RoundRectangle2D;
import org.scilab.forge.jlatexmath.platform.graphics.Color;
import org.scilab.forge.jlatexmath.platform.graphics.Graphics2DInterface;
import org.scilab.forge.jlatexmath.platform.graphics.Image;
import org.scilab.forge.jlatexmath.platform.graphics.RenderingHints;
import org.scilab.forge.jlatexmath.platform.graphics.Stroke;
import org.scilab.forge.jlatexmath.platform.graphics.Transform;

public class Graphics2DI implements Graphics2DInterface{
	
	private CustomView mCustomView;
	private CGContext mCGContext;
	private UIFont mUIFont;
	private CGRect mFrame;
	
	private FontI mFont;
	private ColorI mColor;
	private BasicStrokeI mStroke;
	private ScaleStack mScaleStack;
	
	private NSString mNSString;
	private NSStringDrawingOptions mNSStringDrawingOptions;
	private NSAttributedStringAttributes mNSAttributedStringAttributes;
	private NSStringDrawingContext mNSStringDrawingContext;
	
	public Graphics2DI(CGContext context, CGRect frame){
		mCGContext = context;
		mFont = new FontI("Serif", Font.PLAIN, 10);
		mUIFont = mFont.getTypeface();
		//mCustomView = new CustomView(frame);
		mScaleStack = new ScaleStack();
		mColor = (ColorI) ColorUtil.BLACK;
		mFrame = frame;
	}
	
	
//	public Graphics2DI(CGContext context) {
//		this();
//		setCGContext(context);
//	}

	public Graphics2DI(CGContext context, CGRect frame, CustomView view) {
		this(context, frame);
		setView(view);
	}
	
	public Graphics2DI(CGContext context, CGRect frame, UIImage mUIImage){
		this(context, frame);
		//mCustomView.setImage(mUIImage);
	}

	public void setCGContext(CGContext context) {
		mCGContext = context;
	}

	public void setView(CustomView view) {
		mCustomView = view;
	}
	
	public void setStroke(Stroke stroke) {
		BasicStrokeI basicStroke = (BasicStrokeI) stroke;
		setBasicStroke(basicStroke);
	}
	
	public void setBasicStroke(BasicStrokeI stroke) {
		// TODO Auto-generated method stub
		mCGContext.setLineWidth(stroke.getWidth());
		mCGContext.setMiterLimit(stroke.getMiterLimit());
		mCGContext.setLineJoin(stroke.getNativeJoin());
		mCGContext.setLineCap(stroke.getNativeCap());
		mStroke = stroke;
	}

	public Stroke getStroke() {
		// TODO Auto-generated method stub
		return new BasicStrokeI(mStroke.getWidth(), mStroke.getMiterLimit(), mStroke.getNativeCap(), mStroke.getNativeJoin());
	}

	public void setColor(Color color) {
		// TODO Auto-generated method stub
			mColor = (ColorI) color;
			int colorInt = mColor.getColor();
			//System.out.println("colorInt: " + colorInt);
			int r = (colorInt & 0x00000000) >> 24;
			int g = (colorInt & 0x00FF0000) >> 16;
			int b = (colorInt & 0x0000FF00) >> 8;
			//System.out.println("r: "+r+" g: "+g+"  b: "+b);
			//System.out.println("mCGContext == null: " + (mCGContext==null));
			mCGContext.setRGBStrokeColor((double)r/255,(double)g/255, (double)b/255, 1.0);
			mCGContext.setRGBFillColor((double)r/255,(double)g/255, (double)b/255, 1.0);
			
	}

	public Color getColor() {
		// TODO Auto-generated method stub
		return mColor;
	}

	public Transform getTransform() {
		// TODO Auto-generated method stub
		return null;
	}

	public Font getFont() {
		// TODO Auto-generated method stub
		return mFont;
	}

	public void setFont(Font font) {
		// TODO Auto-generated method stub
		mFont = (FontI) font;
		mUIFont = mFont.getTypeface();
	}

	public void fillRect(int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		//mCGContext.saveGState();
		mCGContext.fillRect(new CGRect(mScaleStack.scaleX(x), mScaleStack.scaleY(y), 
				mScaleStack.getScaleX() * width, mScaleStack.getScaleY() * height));
		//mCGContext.restoreGState();
	}

	public void fill(Rectangle2D rectangle) {
		// TODO Auto-generated method stub
		//mCGContext.saveGState();
		draw(rectangle);
		//mCGContext.restoreGState();
	}

	public void draw(Rectangle2D rectangle) {
		// TODO Auto-generated method stub
		CGRect rect = ((Rectangle2DI) rectangle).getCGRect();
		//CGRect copy = new CGRect(rect.getOrigin(),rect.getSize());
		mCGContext.addRect(mScaleStack.scaleCGRect(rect));
	}

	public void draw(RoundRectangle2D rectangle) {
		// TODO Auto-generated method stub
		CGRect rect = ((RoundRectangle2DI) rectangle).getCGRect();
		double x = rectangle.getX();
		double y = rectangle.getY();
		double width = rectangle.getWidth();
		double height = rectangle.getHeight();
		double arcW = rectangle.getArcW();
		double arcH = rectangle.getArcH();
		//mCGContext.moveToPoint(x, y - arcW);
		//mCGContext.addArcToPoint(x, y, x - width, y +, radius);
	}

	public void draw(Line2D line) {
		// TODO Auto-generated method stub
		Line2DI impl = (Line2DI) line;
		CGPoint start = impl.getStartPoint();
		CGPoint end = impl.getEndPoint();
		CGPoint[] drawline = {start, end};
		mCGContext.addLines(drawline);
	}

	public void drawChars(char[] data, int offset, int length, int x, int y) {
		// TODO Auto-generated method stub
		mCGContext.saveGState();
		//System.out.println("x: "+x+" y: "+y);
		String string = new String(data, offset, length);
		//System.out.println(""+mUIFont == null);
		CGPoint point = new CGPoint(mScaleStack.scaleX(x), mScaleStack.scaleY(y));
		NSString drawString = new NSString(string);
		drawString.draw(point, mUIFont);
		mCGContext.restoreGState();
	}
	
	public void drawString(String string, int x, int y){
		CGPoint point = new CGPoint(mScaleStack.scaleX(x), mScaleStack.scaleY(y));
		NSString drawString = new NSString(string);
		drawString.draw(point, mUIFont);
	}

	public void drawArc(int x, int y, int width, int height, int startAngle,
			int arcAngle) {
		// TODO Auto-generated method stub
		//mCGContext.add
	}

	public void fillArc(int x, int y, int width, int height, int startAngle,
			int arcAngle) {
		// TODO Auto-generated method stub
		
	}

	public void translate(double x, double y) {
		// TODO Auto-generated method stub
		//mCGContext.translateCTM(x,y);
		mCGContext.translateCTM(mScaleStack.scaleX((float) x), mScaleStack.scaleY((float) y));
	}

	public void scale(double x, double y) {
		// TODO Auto-generated method stub
		mScaleStack.appendScale((float) x, (float) y);
	}

	public void rotate(double theta, double x, double y) {
		// TODO Auto-generated method stub
		translate(x, y);
		rotate(theta);
		translate(-x, -y);
	}

	public void rotate(double theta) {
		// TODO Auto-generated method stub
		float degrees = (float) Math.toDegrees(theta);
		mCGContext.rotateCTM(degrees);
	}

	public void drawImage(Image image, int x, int y) {
		// TODO Auto-generated method stub
		ImageI imageI = (ImageI) image;
		mCGContext.drawImage(new CGRect(x, y, imageI.getWidth(), imageI.getHeight()), imageI.getUIImage().getCGImage());
	}

	public void drawImage(Image image, Transform transform) {
		// TODO Auto-generated method stub
		
	}

	public FontRenderContext getFontRenderContext() {
		// TODO Auto-generated method stub
		return new FontRenderContextI(mNSString, mNSStringDrawingOptions, 
				mNSAttributedStringAttributes, mNSStringDrawingContext);
	}

	public void setRenderingHint(int key, int value) {
		// TODO Auto-generated method stub
		if (key == RenderingHints.KEY_ANTIALIASING && value == RenderingHints.VALUE_ANTIALIAS_ON) {
			mCGContext.setShouldAntialias(true);
		} else {
			// No other rendering hint is supported
		}
	}

	public int getRenderingHint(int key) {
		// TODO Auto-generated method stub
		return -1;
	}

	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
	public void saveTransformation() {
		mCGContext.saveGState();
		mScaleStack.pushScaleValues();
	}

	public void restoreTransformation() {
		mCGContext.restoreGState();
		mScaleStack.popScaleValues();
	}
	
	

}
