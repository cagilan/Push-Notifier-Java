	package nsn.mobile.apps.layout;
	
	import android.content.Context;
	import android.graphics.Color;
import android.preference.RingtonePreference;
import android.util.AttributeSet;
	import android.view.View;
	import android.view.ViewGroup;
import android.widget.TextView;
	
	public class RingPref extends RingtonePreference {
	
	public RingPref(Context context) {
	super(context);
	}
	
	public RingPref(Context context, AttributeSet attrs) {
	super(context, attrs);
	}
	
	
	
	    /**
	* We catch the view after its creation, and before the activity will use it, in order to make our changes
	* @param parent
	* @return
	*/
	protected View onCreateView(ViewGroup parent) {
		View newView = super.onCreateView(parent);

        // Making the text visible (The background is transparent, no need to worry there)l6
        ((TextView)newView.findViewById(android.R.id.title)).setTextColor(Color.BLACK);
        ((TextView)newView.findViewById(android.R.id.summary)).setTextColor(Color.GRAY);
      return newView;
	}
	}