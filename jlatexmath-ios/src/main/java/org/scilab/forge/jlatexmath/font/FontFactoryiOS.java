package org.scilab.forge.jlatexmath.font;

import org.robovm.apple.foundation.NSBundle;
import org.scilab.forge.jlatexmath.platform.font.Font;
import org.scilab.forge.jlatexmath.platform.font.FontFactory;
import org.scilab.forge.jlatexmath.platform.font.FontLoader;
import org.scilab.forge.jlatexmath.platform.font.FontRenderContext;
import org.scilab.forge.jlatexmath.platform.font.TextAttributeProvider;
import org.scilab.forge.jlatexmath.platform.font.TextLayout;

public class FontFactoryiOS extends FontFactory{
	
	private NSBundle mNSBundle;
	
	public FontFactoryiOS(){
		mNSBundle = NSBundle.getMainBundle();
	}
	
	@Override
	public Font createFont(String name, int style, int size) {
		return new FontI(name, style, size);
	}

	@Override
	public TextLayout createTextLayout(String string, Font font,
			FontRenderContext fontRenderContext) {
		return new TextLayoutI(string, (FontI) font, (FontRenderContextI) fontRenderContext);
	}

	@Override
	public TextAttributeProvider createTextAttributeProvider() {
		return new TextAttributeProviderI();
	}

	@Override
	public FontLoader createFontLoader() {
		return new FontLoaderI();
	}
}
