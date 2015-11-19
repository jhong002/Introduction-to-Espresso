package com.captech.jhong.expressoexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    Button mSetToolbarButton, mSetTextViewButton;
    Toolbar mToolbar;
    EditText mEditText;
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar();

        mTextView = (TextView) findViewById(R.id.activity_main_textview);
        mEditText = (EditText) findViewById(R.id.activity_main_edit_text);
        mSetToolbarButton = (Button) findViewById(R.id.set_toolbar_title_button);
        mSetTextViewButton = (Button) findViewById(R.id.set_textview_button);
        mSetToolbarButton.setOnClickListener(this);
        mSetTextViewButton.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initToolbar() {

        mToolbar = (Toolbar) findViewById(R.id.activity_main_toolbar);
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
        }

    }

    @Override
    public void onClick(View view) {
        String editTextString = mEditText.getText().toString();

        switch (view.getId()){
            case R.id.set_toolbar_title_button:
                mToolbar.setTitle(editTextString);
                break;
            case R.id.set_textview_button:
                mTextView.setText(editTextString);
                break;
            default:
                break;
        }
    }
}
