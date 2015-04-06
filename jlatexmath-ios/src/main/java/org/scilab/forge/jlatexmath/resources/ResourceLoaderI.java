package org.scilab.forge.jlatexmath.resources;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ByteArrayInputStream;

import org.robovm.apple.coregraphics.CGDataProvider;
import org.robovm.apple.foundation.NSBundle;
import org.robovm.apple.foundation.NSData;
import org.scilab.forge.jlatexmath.BaseObjectHelper;
import org.scilab.forge.jlatexmath.FactoryProvideriOS;
import org.scilab.forge.jlatexmath.exception.ResourceParseException;
import org.scilab.forge.jlatexmath.platform.resources.ResourceLoader;

public class ResourceLoaderI implements ResourceLoader{
	
	private NSBundle mNSBundle;
	
	public ResourceLoaderI(){
		mNSBundle = NSBundle.getMainBundle();
	}
	
	
	public InputStream loadResource(Object base, String path) throws ResourceParseException {
		try {
			
			path = mNSBundle.findResourcePath(path, null);
			//System.out.println("path: "+path);
			File f = new File(BaseObjectHelper.getPath(base, path));
			//System.out.println(f.getAbsolutePath());
			//System.out.println(f.exists());
			NSData mNSData = NSData.read(f);
			byte[] byteData = mNSData.getBytes();
			return new ByteArrayInputStream(byteData);
		} catch (Exception e) {
			throw new ResourceParseException("Could not load resource.", e);
		}
	}
	

}
