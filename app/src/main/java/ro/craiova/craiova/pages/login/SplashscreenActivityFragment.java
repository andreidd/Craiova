package ro.craiova.craiova.pages.login;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ro.craiova.craiova.MainActivity;
import ro.craiova.craiova.R;
import ro.craiova.craiova.business.AppConstants;

/**
 * A placeholder fragment containing a simple view.
 */
public class SplashscreenActivityFragment extends Fragment implements View.OnClickListener {

	private TextInputEditText prenume;

	public SplashscreenActivityFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_splashscreen, container, false);
		rootView.findViewById(R.id.login).setOnClickListener(this);

		prenume = (TextInputEditText) rootView.findViewById(R.id.prenume);

		return rootView;
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent(getContext(), MainActivity.class);
		if (prenume.getText() != null && prenume.getText().toString() != null) {
			AppConstants.NAME = prenume.getText().toString();
		}
		startActivity(intent);
	}
}
