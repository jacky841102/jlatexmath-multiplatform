package org.scilab.forge.jlatexmath.font;

import org.robovm.apple.foundation.NSBundle;
import org.robovm.apple.uikit.UIFont;
import org.scilab.forge.jlatexmath.BaseObjectHelper;
import org.scilab.forge.jlatexmath.exception.ResourceParseException;
import org.scilab.forge.jlatexmath.platform.font.Font;
import org.scilab.forge.jlatexmath.platform.font.FontLoader;

public class FontLoaderI implements FontLoader {

	private NSBundle mNSBundle;

	public FontLoaderI() {
		mNSBundle = NSBundle.getMainBundle();
	}

	public Font loadFont(Object fontType, String name) throws ResourceParseException {
		//System.out.println("path: "+BaseObjectHelper.getPath(fontType, name));
		//System.out.println("name: "+name);
		String filename = name.substring(name.lastIndexOf("/")+1, name.indexOf(".")); 
		UIFont typeface =  UIFont.getFont(filename, 48);
		//System.out.println("fontname: "+typeface.getFontName());
		return new FontI(typeface, Math.round(PIXELS_PER_POINT));
	}
}

