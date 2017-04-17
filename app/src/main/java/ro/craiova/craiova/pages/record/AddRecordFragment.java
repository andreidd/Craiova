package ro.craiova.craiova.pages.record;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ro.craiova.craiova.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddRecordFragment extends Fragment {

	public final static String TAG = AddRecordFragment.class.getName();

	public AddRecordFragment() {
		// Required empty public constructor
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_add_record, container, false);
	}

}
