// TODO FG Review
package com.newtonforever.einstein;

import java.util.TimerTask;

import com.newtonforever.einstein.jni.Native;

class ScreenRefresh extends TimerTask {

	private final EinsteinView einsteinView;
	int cc = 0;

	public ScreenRefresh(Einstein e, EinsteinView ev) {
		this.einsteinView = ev;
	}

	@Override
	public void run() {
		// TODO MM Immer wieder bis 10 zu z�hlen ist keine wirklich reproduzierbare Zeitspanne. Warum hast Du das
		// so gemacht? Vermutlich ist diese Zeit auf jedem Device anders. Besser w�re es, wenn man hier so was machen
		// w�rde wie Thread.currentThread().sleep(zeitInMillisekunden). Das w�re zumindest halbwegs reproduzierbar.
		cc++;
		if (10 == cc) {
			cc = 0;
			//Log.i("ScreenRefresh", "Tick");
		}
		if (0 != Native.screenIsDirty()) {
			einsteinView.postInvalidate();
			//Log.i("ScreenRefresh", "Drawing");
		}
	}
}