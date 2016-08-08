package com.lsf.reversi.app.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import com.lsf.reversi.R;
import com.lsf.reversi.app.game.Constant;

public class MainActivity extends Activity {

	private RadioButton black;
	private RadioButton write;
	private final RadioButton[] radioButtons = new RadioButton[8];
	private byte playerColor;
	private int difficulty;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainui_layout);
		
		black = (RadioButton) findViewById(R.id.black);
		black.setChecked(true);

		radioButtons[0] = (RadioButton) findViewById(R.id.level1);
		radioButtons[1] = (RadioButton) findViewById(R.id.level2);
		radioButtons[2] = (RadioButton) findViewById(R.id.level3);
		radioButtons[3] = (RadioButton) findViewById(R.id.level4);
		radioButtons[4] = (RadioButton) findViewById(R.id.level5);
		radioButtons[5] = (RadioButton) findViewById(R.id.level6);
		radioButtons[6] = (RadioButton) findViewById(R.id.level7);
		radioButtons[7] = (RadioButton) findViewById(R.id.level8);
		for (int i = 0; i < radioButtons.length; i++) {
			final int k = i;
			radioButtons[i]
					.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
						@Override
						public void onCheckedChanged(CompoundButton buttonView,
								boolean isChecked) {
							if (isChecked) {
								for (int index = 0; index < radioButtons.length; index++) {
									if (index != k) {
										radioButtons[index].setChecked(false);
									}
								}
							}
						}
					});
		}
		radioButtons[0].setChecked(true);
	}
	
	public void getHelp(View v){
		Intent intent = new Intent(MainActivity.this, GameRuleActivity.class);
		startActivity(intent);
		overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
	}

	public void playGame(View v) {
		Intent intent = new Intent(MainActivity.this, GameActivity.class);
		playerColor = getPlayerColor();
		difficulty = getDifficulty();
		intent.putExtra("playerColor", playerColor);
		intent.putExtra("difficulty", difficulty);
		startActivity(intent);
		overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
	}
	
	private byte getPlayerColor(){
        return (black.isChecked()? Constant.BLACK:Constant.WHITE);
    }

    private int getDifficulty(){
        for(int i = 0; i < 8; i++){
            if(radioButtons[i].isChecked()){
                return i+1;
            }
        }
        return 1;
    } 
}
