import android.annotation.SuppressLint;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.widget.TextView;
import ca.ualberta.cs.lonelytwitter.IntentReaderActivity;

@SuppressLint("NewApi")
public class IntentReaderActivityTest extends
        ActivityInstrumentationTestCase2<IntentReaderActivity> {

    public IntentReaderActivityTest() {
        super(IntentReaderActivity.class);
    }

    public void testSendText() {
        Intent intent = new Intent();
        String text = "hello";
        intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
        
        setActivityIntent(intent);
        IntentReaderActivity activity = getActivity();
        
        assertEquals("IntentReaderActivity should get text from intent", text, activity.getText());
    }    
    
    public void testDoubleText() {
        Intent intent = new Intent();
        String text = "hello";
        intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
        intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, IntentReaderActivity.DOUBLE);
        
        setActivityIntent(intent);
        IntentReaderActivity activity = getActivity();
        
        assertEquals("IntentReaderActivity should double the text", "hellohello", activity.getText());
    }
    
    public void testDisplayText() {
        Intent intent = new Intent();
        String text = "hello";
        intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
        
        setActivityIntent(intent);
        IntentReaderActivity activity = getActivity();

        TextView textView = (TextView) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
        assertEquals("Tex should be displayed", text, textView.getText().toString());
    }
    
    public void testReverseText() {
        Intent intent = new Intent();
        String text = "hello";
        intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
        intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, IntentReaderActivity.REVERSE);
        
        setActivityIntent(intent);
        IntentReaderActivity activity = getActivity();
        
        assertEquals("IntentReaderActivity should double the text", "olleh", activity.getText());
    }
    
    public void testDefaultMessage() {
        Intent intent = new Intent();
        intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, IntentReaderActivity.REVERSE);
        
        setActivityIntent(intent);
        IntentReaderActivity activity = getActivity();
        
        TextView textView = (TextView) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
        assertEquals("Text should be displayed", "default", textView.getText().toString());
    }
    
    public void testTextViewIsVisible() {
    	Intent intent = new Intent();
        String text = "hello";
        intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
        intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, IntentReaderActivity.REVERSE);
        
        setActivityIntent(intent);
        IntentReaderActivity activity = getActivity();
        ViewAsserts.assertOnScreen(activity.getWindow().getDecorView(), 
        		activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText));
    }
}
