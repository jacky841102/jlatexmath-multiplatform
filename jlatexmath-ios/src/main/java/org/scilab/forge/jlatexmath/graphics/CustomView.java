package org.scilab.forge.jlatexmath.graphics;

import org.robovm.apple.coregraphics.CGContext;
import org.robovm.apple.coregraphics.CGPoint;
import org.robovm.apple.coregraphics.CGRect;
import org.robovm.apple.foundation.NSString;
import org.robovm.apple.uikit.UIColor;
import org.robovm.apple.uikit.UIFont;
import org.robovm.apple.uikit.UIGraphics;
import org.robovm.apple.uikit.UIImageView;
import org.robovm.apple.uikit.UIView;
import org.scilab.forge.jlatexmath.ColorUtil;
import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;
import org.scilab.forge.jlatexmath.platform.graphics.Graphics2DInterface;
import org.scilab.forge.jlatexmath.platform.graphics.Insets;

public class CustomView extends UIView{
	
	private CGContext mCGContext; 
	
	public CustomView(CGRect frame){
		super(frame);
		setBackgroundColor(UIColor.lightGray());
		//CGContext context = UIGraphics.getCurrentContext();
		//System.out.println("context == null: " + (context==null));
	}
	
	@Override
	public void draw(CGRect rect){
		mCGContext = UIGraphics.getCurrentContext();
		//System.out.println("mCGContext == null: " + (mCGContext==null));
		String latex = "\\sqrt{1+\\frac{a}{b}}";
		
        TeXFormula formula = new TeXFormula(latex);
        TeXIcon icon = formula.createTeXIcon(TeXConstants.STYLE_DISPLAY, 50);
        icon.setInsets(new Insets(5, 5, 5, 5));
        ImageI image = new ImageI();
        Graphics2DInterface g2 = image.createGraphics2D(mCGContext, new CGRect(100,100,200,200));
        g2.setColor(ColorUtil.WHITE);
        //g2.fillRect(100, 100, icon.getIconWidth(), icon.getIconHeight());
        icon.paintIcon(null, g2, 100, 100);
		mCGContext.setLineWidth(2.0);
		mCGContext.setStrokeColor(UIColor.black().getCGColor());
        //mCGContext.addArc(50, 100, 20.0, 0.0, 6.28, 0);
        mCGContext.strokePath();
		//mCGContext = UIGraphics.getCurrentContext();
	}
	
	public void drawString(CGRect rect, String string, int x, int y, UIFont font){
		CGPoint point = new CGPoint(x,y);
		NSString drawString = new NSString(string);
		drawString.draw(point, font);
	}
	
	public CGContext getCGContext(){
		return mCGContext;
	}
}
