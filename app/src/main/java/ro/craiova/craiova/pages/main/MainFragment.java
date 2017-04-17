package ro.craiova.craiova.pages.main;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ro.craiova.craiova.R;
import ro.craiova.craiova.business.AppConstants;
import ro.craiova.craiova.pages.record.AddRecordFragment;
import ro.craiova.craiova.pages.record.MyRecordsFragment;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment implements View.OnClickListener {

	private OnMainFragmentInteractionListener mListener;

	public MainFragment() {
		// Required empty public constructor
	}


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View rootView = inflater.inflate(R.layout.fragment_main_copy, container, false);
		rootView.findViewById(R.id.addReport).setOnClickListener(this);
		rootView.findViewById(R.id.myReports).setOnClickListener(this);
		rootView.findViewById(R.id.callPolice).setOnClickListener(this);
		rootView.findViewById(R.id.callMayor).setOnClickListener(this);

		((TextView) rootView.findViewById(R.id.name)).setText(getString(R.string.welcome) + ", " + AppConstants.NAME + "!");

		return rootView;
	}

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);

		if (context instanceof OnMainFragmentInteractionListener) {
			mListener = (OnMainFragmentInteractionListener) context;
		}
	}

	@Override
	public void onDetach() {
		super.onDetach();
		mListener = null;
	}

	@Override
	public void onClick(View v) {
		if (mListener != null) {
			if (R.id.addReport == v.getId()) {
				mListener.onNavigationTileClicked(AddRecordFragment.TAG);
			} else if (R.id.myReports == v.getId()) {
				mListener.onNavigationTileClicked(MyRecordsFragment.TAG);
			} else if (R.id.callPolice == v.getId()) {
				mListener.onNavigationTileClicked("");
			} else if (R.id.callMayor == v.getId()) {
				mListener.onNavigationTileClicked("");
			}
		}
	}

	/**
	 * This interface must be implemented by activities that contain this
	 * fragment to allow an interaction in this fragment to be communicated
	 * to the activity and potentially other fragments contained in that
	 * activity.
	 * <p>
	 * See the Android Training lesson <a href=
	 * "http://developer.android.com/training/basics/fragments/communicating.html"
	 * >Communicating with Other Fragments</a> for more information.
	 */
	public interface OnMainFragmentInteractionListener {
		// TODO: Update argument type and name
		void onNavigationTileClicked(String fragmentTag);
	}
}
