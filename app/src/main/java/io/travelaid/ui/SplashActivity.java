package io.travelaid.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import io.travelaid.R;
import io.travelaid.util.AppUtils;

/**
 * Splash activity
 */
public class SplashActivity extends AppCompatActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		//Show screen for 0.8 secs and navigate to the appropriate screen after user login state
		// is verified
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				if (AppUtils.isLoggedIn()) {
					SplashActivity.this.startActivity(new Intent(SplashActivity.this, OnBoardingScreen.class));
				} else {
					SplashActivity.this.startActivity(new Intent(SplashActivity.this, LoginActivity.class));
				}
				SplashActivity.this.finish();
			}
		}, 900);
	}
}
