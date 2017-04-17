package ro.craiova.craiova.pages.record;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ro.craiova.craiova.R;
import ro.craiova.craiova.business.bean.ComplaintBean;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyRecordsFragment extends Fragment {

	public final static String TAG = MyRecordsFragment.class.getName();

	private RecyclerView mRecyclerView;

	public MyRecordsFragment() {
		// Required empty public constructor
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View rootView = inflater.inflate(R.layout.fragment_my_records, container, false);
		mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
		mRecyclerView.setHasFixedSize(true);

		// use a linear layout manager
		LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
		mRecyclerView.setLayoutManager(mLayoutManager);

		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		List<ComplaintBean> data = new ArrayList<>();
		data.add(new ComplaintBean(cal.getTime(), "Urbanistica", "Strada Floresti"));
		cal.add(Calendar.DAY_OF_MONTH, 1);
		cal.add(Calendar.HOUR, 1);
		cal.add(Calendar.MINUTE, 15);
		data.add(new ComplaintBean(cal.getTime(), "Urbanistica", "Strada Floresti"));
		cal.add(Calendar.DAY_OF_MONTH, 1);
		cal.add(Calendar.HOUR, 1);
		cal.add(Calendar.MINUTE, 15);
		data.add(new ComplaintBean(cal.getTime(), "Locala", "Bulevardul Decebal nr. 31"));
		cal.add(Calendar.DAY_OF_MONTH, 1);
		cal.add(Calendar.HOUR, 1);
		cal.add(Calendar.MINUTE, 15);
		data.add(new ComplaintBean(cal.getTime(), "Urbanistica", "Strada Floresti"));
		cal.add(Calendar.DAY_OF_MONTH, 1);
		cal.add(Calendar.HOUR, 1);
		cal.add(Calendar.MINUTE, 15);
		data.add(new ComplaintBean(cal.getTime(), "Vandalism", "Bvd. A.I. Cuza"));
		cal.add(Calendar.DAY_OF_MONTH, 1);
		cal.add(Calendar.HOUR, 1);
		cal.add(Calendar.MINUTE, 15);
		data.add(new ComplaintBean(cal.getTime(), "Urbanistica", "Strada Floresti"));
		cal.add(Calendar.DAY_OF_MONTH, 1);
		cal.add(Calendar.HOUR, 1);
		cal.add(Calendar.MINUTE, 15);
		data.add(new ComplaintBean(cal.getTime(), "Urbanistica", "Strada Floresti"));
		MyRecrodsAdapter adapter = new MyRecrodsAdapter(data);
		mRecyclerView.setAdapter(adapter);

		return rootView;
	}

}
