package org.scilab.forge.jlatexmath.graphics;

import org.scilab.forge.jlatexmath.platform.graphics.BasicStroke;
import org.scilab.forge.jlatexmath.platform.graphics.Color;
import org.scilab.forge.jlatexmath.platform.graphics.GraphicsFactory;
import org.scilab.forge.jlatexmath.platform.graphics.Image;
import org.scilab.forge.jlatexmath.platform.graphics.Transform;

public class GraphicsFactoryiOS extends GraphicsFactory {

	@Override
	public BasicStroke createBasicStroke(float width, int cap, int join,
			float miterLimit) {
		return new BasicStrokeI(width, miterLimit, cap, join);
	}

	@Override
	public Color createColor(int red, int green, int blue) {
		return new ColorI(red, green, blue);
	}

	@Override
	public Image createImage(int width, int height, int type) {
		return new ImageI();
	}

	@Override
	public Image getImage(String path) {
		// TODO Get image in graphics factory
		return null;
	}

	@Override
	public Transform createTransform() {
		return new TransformI();
	}

}