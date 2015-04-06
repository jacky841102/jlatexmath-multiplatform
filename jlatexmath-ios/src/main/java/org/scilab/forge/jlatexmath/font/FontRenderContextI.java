package org.scilab.forge.jlatexmath.font;

import org.robovm.apple.foundation.NSString;
import org.robovm.apple.uikit.NSAttributedStringAttributes;
import org.robovm.apple.uikit.NSStringDrawingContext;
import org.robovm.apple.uikit.NSStringDrawingOptions;
import org.robovm.apple.uikit.UIFont;
import org.robovm.apple.uikit.UIGraphics;
import org.scilab.forge.jlatexmath.platform.font.FontRenderContext;

public class FontRenderContextI implements FontRenderContext{
	
	private UIFont mUIFont;
	
	private NSString mNSString;
	private NSStringDrawingOptions mNSStringDrawingOptions;
	private NSAttributedStringAttributes mNSAttributedStringAttributes;
	private NSStringDrawingContext mNSStringDrawingContext;
	
	
	public FontRenderContextI(UIFont uiFont){
		mUIFont = uiFont;
	}
	
	public FontRenderContextI(NSString nsString, NSStringDrawingOptions nsStringDrawingOptions
			,NSAttributedStringAttributes nsAttributedStringAttributes
			,NSStringDrawingContext nsStringDrawingContext){
		mNSString = nsString;
		mNSStringDrawingOptions = nsStringDrawingOptions;
		mNSAttributedStringAttributes = nsAttributedStringAttributes;
		mNSStringDrawingContext = nsStringDrawingContext;
	}
	
	public UIFont getUIFont(){
		return mUIFont;
	}
	
	public NSString getNSString(){
		return mNSString;
	}

	public NSStringDrawingOptions getNSStringDrawingOptions() {
		return mNSStringDrawingOptions;
	}

	public NSAttributedStringAttributes getNSAttributedStringAttributes() {
		return mNSAttributedStringAttributes;
	}

	public NSStringDrawingContext getNSStringDrawingContext() {
		return mNSStringDrawingContext;
	}

}
