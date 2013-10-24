package slidenerd.vivz.thepirateapp.custom_animations;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class SearchAutoCompleteTextViewAnimation extends Animation {
	private float centerX;
	private float centerY;
	private Camera camera=new Camera();
	public SearchAutoCompleteTextViewAnimation(float cx, float cy)
	{
		this.centerX=cx;
		this.centerY=cy;
//		Log.d("VIVZ", ""+centerX+" "+centerY);
	}
	@Override
	public void initialize(int width, int height, int parentWidth,
			int parentHeight) {
		// TODO Auto-generated method stub
		super.initialize(width, height, parentWidth, parentHeight);
		setDuration(3000);
		setFillAfter(true);
		setInterpolator(new AccelerateDecelerateInterpolator());
	}
	@Override
	protected void applyTransformation(float interpolatedTime, Transformation t) {
		// TODO Auto-generated method stub
		Matrix transformationMatrix=t.getMatrix();
		camera.save();
		camera.translate(2*centerX*interpolatedTime, 0.0f, (0-0.0f*interpolatedTime));
		camera.rotateY(360*interpolatedTime);
		camera.translate(-2*centerX*interpolatedTime, 0.0f, (0-0.0f*interpolatedTime));
		camera.getMatrix(transformationMatrix);
//		Log.d("VIVZ", "Matrix "+transformationMatrix.toShortString());
		
		camera.restore();
		
	}
}
