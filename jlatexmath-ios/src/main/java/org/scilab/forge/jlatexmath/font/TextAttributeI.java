package org.scilab.forge.jlatexmath.font;

import org.robovm.apple.uikit.NSAttributedStringAttribute;
import org.scilab.forge.jlatexmath.platform.font.TextAttribute;

public class TextAttributeI implements TextAttribute{
	
	private NSAttributedStringAttribute textAttribute;
	
	public TextAttributeI(NSAttributedStringAttribute textAttribute){
		this.textAttribute = textAttribute;
	}
	
	public NSAttributedStringAttribute getTextAttribute(){
		return textAttribute;
	}
	
}
