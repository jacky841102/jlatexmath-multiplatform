

import org.robovm.apple.coregraphics.CGContext;
import org.robovm.apple.coregraphics.CGRect;
import org.robovm.apple.uikit.NSTextAlignment;
import org.robovm.apple.uikit.UIButton;
import org.robovm.apple.uikit.UIButtonType;
import org.robovm.apple.uikit.UIColor;
import org.robovm.apple.uikit.UIControl;
import org.robovm.apple.uikit.UIControlState;
import org.robovm.apple.uikit.UIEvent;
import org.robovm.apple.uikit.UIFont;
import org.robovm.apple.uikit.UIGraphics;
import org.robovm.apple.uikit.UIImageView;
import org.robovm.apple.uikit.UILabel;
import org.robovm.apple.uikit.UIView;
import org.robovm.apple.uikit.UIViewController;
import org.scilab.forge.jlatexmath.ColorUtil;
import org.scilab.forge.jlatexmath.FactoryProvideriOS;
import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;
import org.scilab.forge.jlatexmath.graphics.CustomView;
import org.scilab.forge.jlatexmath.graphics.ImageI;
import org.scilab.forge.jlatexmath.platform.FactoryProvider;
import org.scilab.forge.jlatexmath.platform.graphics.Graphics2DInterface;
import org.scilab.forge.jlatexmath.platform.graphics.Insets;

public class MyViewController extends UIViewController {
   // private final UIButton button;
    //private final UILabel label;
	private UIImageView imageView;
    private int clickCount;

    public MyViewController () {
        // Get the view of this view controller.
    	FactoryProvider.INSTANCE = new FactoryProvideriOS();
 
    	
        UIView view = getView();
//        String latex = "x=\\frac{-b \\pm \\sqrt {b^2-4ac}}{2a}";
//        TeXFormula formula = new TeXFormula(latex);
//        TeXIcon icon = formula.createTeXIcon(TeXConstants.STYLE_DISPLAY, 200);
//        icon.setInsets(new Insets(5, 5, 5, 5));
//        ImageI image = new ImageI();
        
        CGRect viewRect = new CGRect(0,100,view.getBounds().getWidth(),
                view.getBounds().getHeight()/2);
        //String latex1 = "x=\\frac{-b \\pm \\sqrt {b^2-4ac}}{2a}";
        CustomView latexView1 = new CustomView(viewRect);
        view.addSubview(latexView1);
        
        view.setBackgroundColor(UIColor.white());
        //imageView = new UIImageView(image.getUIImage());
        
        

//        // Setup label.
//        label = new UILabel(new CGRect(20, 250, 280, 44));
//        label.setFont(UIFont.getSystemFont(24));
//        label.setTextAlignment(NSTextAlignment.Center);
//        view.addSubview(label);
//
//        // Setup button.
//        button = UIButton.create(UIButtonType.RoundedRect);
//        button.setFrame(new CGRect(110, 150, 100, 40));
//        button.setTitle("Click me!", UIControlState.Normal);
//        button.getTitleLabel().setFont(UIFont.getBoldSystemFont(22));
//
//        button.addOnTouchUpInsideListener(new UIControl.OnTouchUpInsideListener() {
//            @Override
//            public void onTouchUpInside (UIControl control, UIEvent event) {
//                label.setText("Click Nr. " + (++clickCount));
//            }
//        });
//        view.addSubview(button);
    }
}
