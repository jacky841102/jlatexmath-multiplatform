package org.scilab.forge.jlatexmath;

import org.robovm.apple.foundation.NSBundle;
import org.scilab.forge.jlatexmath.font.FontFactoryiOS;
import org.scilab.forge.jlatexmath.geom.GeomFactoryiOS;
import org.scilab.forge.jlatexmath.graphics.GraphicsFactoryiOS;
import org.scilab.forge.jlatexmath.parser.ParserFactoryiOS;
import org.scilab.forge.jlatexmath.platform.FactoryProvider;
import org.scilab.forge.jlatexmath.platform.font.FontFactory;
import org.scilab.forge.jlatexmath.platform.geom.GeomFactory;
import org.scilab.forge.jlatexmath.platform.graphics.GraphicsFactory;
import org.scilab.forge.jlatexmath.platform.parser.ParserFactory;
import org.scilab.forge.jlatexmath.platform.resources.ResourceLoaderFactory;
import org.scilab.forge.jlatexmath.resources.ResourceLoaderFactoryiOS;

public class FactoryProvideriOS extends FactoryProvider{
	
	private NSBundle mNSBundle; 
	
	public FactoryProvideriOS() {
		mNSBundle = NSBundle.getMainBundle();
	}

	@Override
	protected GeomFactory createGeomFactory() {
		return new GeomFactoryiOS();
	}

	@Override
	protected FontFactory createFontFactory() {
		return new FontFactoryiOS();
	}

	@Override
	protected GraphicsFactory createGraphicsFactory() {
		return new GraphicsFactoryiOS();
	}

	@Override
	protected ParserFactory createParserFactory() {
		return new ParserFactoryiOS();
	}

	@Override
	protected ResourceLoaderFactory createResourceLoaderFactory() {
		return new ResourceLoaderFactoryiOS();
	}
	
}
