package org.scilab.forge.jlatexmath.font;

import java.util.Map;

import org.robovm.apple.coregraphics.CGFont;
import org.robovm.apple.uikit.UIFont;
import org.scilab.forge.jlatexmath.platform.font.Font;
import org.scilab.forge.jlatexmath.platform.font.TextAttribute;

public class FontI implements Font{
	private UIFont mUIFont;
	private static int mSize;
	private final static int DEFAULTSTYLE = 0; 
	
	public FontI(UIFont uiFont, int size) {
		mUIFont = uiFont;
		mSize = size;
	}
	
	//public FontI(CGFont cgFOnt, int size){
	//	mCGFont = cgFont;
	//	mSize = size;
	//}
	
	public FontI(String name, int style, int size) {
		mUIFont = new UIFont();
		mSize = size;
		if(style == DEFAULTSTYLE){
			mUIFont = getUIFontStyle(style);
		}
		else{
			mUIFont = UIFont.getFont(name, size);
		}
	}

	public UIFont getTypeface() {
		return mUIFont;
		//return mUIFont;
	}
	
	public int getSize() {
		return mSize;
	}

	public Font deriveFont(Map<TextAttribute, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	public Font deriveFont(int type) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private static UIFont getUIFontStyle(int fontStyle) {
		UIFont uiFontStyle = UIFont.getSystemFont(mSize);

		if (fontStyle == BOLD) {
			uiFontStyle = UIFont.getBoldSystemFont(mSize);
		} else if (fontStyle == ITALIC) {
			uiFontStyle = UIFont.getItalicSystemFont(mSize);
		} 
		return uiFontStyle;
	}

}
