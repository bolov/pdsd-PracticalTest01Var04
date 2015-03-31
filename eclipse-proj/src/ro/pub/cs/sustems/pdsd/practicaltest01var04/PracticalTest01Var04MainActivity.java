package ro.pub.cs.sustems.pdsd.practicaltest01var04;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class PracticalTest01Var04MainActivity extends Activity {
	

	private ButtonClickListener buttonClickListener = new ButtonClickListener();
	
	  private class ButtonClickListener implements OnClickListener {
		  
	    @Override
	    public void onClick(View view) {
	    	EditText showText = (EditText)PracticalTest01Var04MainActivity.this.findViewById(R.id.show_txt);
	    	
	    	Button clickedButton = (Button)PracticalTest01Var04MainActivity.this.findViewById(view.getId());
	    	
	    	if (showText.getText().toString().isEmpty()){
	    		showText.setText(clickedButton.getText());
	    	} else {
	    		showText.setText(showText.getText() + "," + clickedButton.getText());
	    	}
	
	    
	    }
	  }
	  private final static String TAG = "PracticalTest01Var04MainActivity";
	
	 int numTries = 0;
	 int numCorrect = 0;
	 int numWrong = 0;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_main);
        
        // restore
        if (savedInstanceState != null) {
        	numTries = savedInstanceState.getInt("numTries");
        	numCorrect= savedInstanceState.getInt("numCorrect");
        	numWrong = savedInstanceState.getInt("numWrong");
        }
        
        Log.d(TAG, "(tries: correct/wrong) " + numTries + ": " + numCorrect + "/" + numWrong);
        
        Button doButton = (Button)findViewById(R.id.do_button);
        doButton.setOnClickListener(buttonClickListener);
        
        Button miButton = (Button)findViewById(R.id.mi_button);
        miButton.setOnClickListener(buttonClickListener);
        
        Button solButton = (Button)findViewById(R.id.sol_button);
        solButton.setOnClickListener(buttonClickListener);
        
        Button doPrimButton = (Button)findViewById(R.id.do_pr_button);
        doPrimButton.setOnClickListener(buttonClickListener);
        
        
    }
    
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {

        savedInstanceState.putInt("numTries", this.numTries);
        savedInstanceState.putInt("numCorrect", this.numCorrect);
        savedInstanceState.putInt("numWrong", this.numWrong);
      
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.practical_test01_var04_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
