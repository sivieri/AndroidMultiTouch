package processing.test.androidmultitouch;

import processing.core.PApplet;
import android.view.MotionEvent;

public class androidMultiTouch extends PApplet {

	int TouchEvents;
	float xTouch[];
	float yTouch[];
	int currentPointerId = 0;
	boolean printFPS;

	@Override
	public void setup() {

		orientation(LANDSCAPE);
		background(0, 255, 0);
		fill(0, 0, 244);
		rect(100, 100, 100, 100);
		stroke(255);

		this.xTouch = new float[10];
		this.yTouch = new float[10];

	}

	@Override
	public void draw() {
		background(255, 0, 0);

		for (int i = 0; i < this.xTouch.length; i++) {
			ellipse(this.xTouch[i], this.yTouch[i], 150, 150);
		}

	}

	@Override
	public boolean surfaceTouchEvent(MotionEvent event) {

		// Number of places on the screen being touched:
		this.TouchEvents = event.getPointerCount();

		// If no action is happening, listen for new events else
		for (int i = 0; i < this.TouchEvents; i++) {
			int pointerId = event.getPointerId(i);
			this.xTouch[pointerId] = event.getX(i);
			this.yTouch[pointerId] = event.getY(i);
		}

		// ACTION_DOWN
		if (event.getActionMasked() == 0) {
			print("Initial action detected. (ACTION_DOWN)");
			print("Action index: " + str(event.getActionIndex()));
		}
		// ACTION_UP
		else if (event.getActionMasked() == 1) {
			print("ACTION_UP");
			print("Action index: " + str(event.getActionIndex()));
		}
		// ACTION_POINTER_DOWN
		else if (event.getActionMasked() == 5) {
			print("Secondary pointer detected: ACTION_POINTER_DOWN");
			print("Action index: " + str(event.getActionIndex()));
		}
		// ACTION_POINTER_UP
		else if (event.getActionMasked() == 6) {
			print("ACTION_POINTER_UP");
			print("Action index: " + str(event.getActionIndex()));
		}
		//
		else if (event.getActionMasked() == 4) {

		}

		// If you want the variables for motionX/motionY, mouseX/mouseY etc.
		// to work properly, you'll need to call super.surfaceTouchEvent().
		return super.surfaceTouchEvent(event);
	}

	@Override
	public int sketchWidth() {
		return this.displayWidth;
	}

	@Override
	public int sketchHeight() {
		return this.displayHeight;
	}
}
