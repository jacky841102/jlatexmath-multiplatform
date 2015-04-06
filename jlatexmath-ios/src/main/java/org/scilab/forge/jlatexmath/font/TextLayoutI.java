package org.scilab.forge.jlatexmath.font;

import org.robovm.apple.coregraphics.CGRect;
import org.robovm.apple.coregraphics.CGSize;
import org.robovm.apple.foundation.NSString;
import org.robovm.apple.uikit.NSAttributedStringAttributes;
import org.robovm.apple.uikit.NSStringDrawingContext;
import org.robovm.apple.uikit.NSStringDrawingOptions;
import org.robovm.apple.uikit.UIGraphics;
import org.scilab.forge.jlatexmath.geom.Rectangle2DI;
import org.scilab.forge.jlatexmath.graphics.Graphics2DI;
import org.scilab.forge.jlatexmath.platform.font.TextLayout;
import org.scilab.forge.jlatexmath.platform.geom.Rectangle2D;
import org.scilab.forge.jlatexmath.platform.graphics.Graphics2DInterface;

public class TextLayoutI implements TextLayout{
	private NSString mNSString;
	private NSStringDrawingOptions mNSStringDrawingOptions;
	private NSAttributedStringAttributes mNSAttributedStringAttributes;
	private NSStringDrawingContext mNSStringDrawingContext;
	private String mString;
	private FontI mFont;
	
	public TextLayoutI(String string, FontI font, FontRenderContextI fontRenderContext) {
		mString = string;
		mFont = font;
		mNSString = fontRenderContext.getNSString();
		mNSStringDrawingOptions = fontRenderContext.getNSStringDrawingOptions();
		mNSAttributedStringAttributes = fontRenderContext.getNSAttributedStringAttributes();
		mNSStringDrawingContext = fontRenderContext.getNSStringDrawingContext();
	}

	public Rectangle2D getBounds() {
		updatePaint();
		CGRect bounds = new CGRect();
		CGSize mCGSize = mNSString.getSize(mNSAttributedStringAttributes);
		bounds = mNSString.getBoundingRect(mCGSize, mNSStringDrawingOptions,
				mNSAttributedStringAttributes, mNSStringDrawingContext);

		return new Rectangle2DI(bounds);
	}

	public void draw(Graphics2DInterface graphics, int x, int y) {
		updatePaint();
		Graphics2DI g2d = (Graphics2DI) graphics;
		g2d.drawString(mString, x, y);
	}

	private void updatePaint() {
		//TO-DO
		
		//mPaint.setTypeface(mFont.getTypeface());
		//mPaint.setTextSize(mFont.getSize());
		//mPaint.setStyle(Style.FILL);
	}
	
}
