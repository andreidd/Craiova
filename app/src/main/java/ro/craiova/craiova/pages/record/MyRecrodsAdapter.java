package ro.craiova.craiova.pages.record;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ro.craiova.craiova.R;
import ro.craiova.craiova.business.bean.ComplaintBean;

/**
 * A custom adapter to use with the RecyclerView widget.
 */
public class MyRecrodsAdapter extends RecyclerView.Adapter<MyRecrodsAdapter.ViewHolder> {

	private List<ComplaintBean> entries = new ArrayList<>();

	public MyRecrodsAdapter(List<ComplaintBean> entries) {
		this.entries.clear();
		this.entries.addAll(entries);
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.record_item_layout, parent, false);
		return new ViewHolder(rootView);
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		holder.bindBean(entries.get(position));
	}

	@Override
	public int getItemCount() {
		return entries.size();
	}

	public static class ViewHolder extends RecyclerView.ViewHolder {

		private TextView dateTV;
		private TextView typeTV;
		private TextView locationTV;

		public ViewHolder(View itemView) {
			super(itemView);

			dateTV = (TextView) itemView.findViewById(R.id.date);
			typeTV = (TextView) itemView.findViewById(R.id.type);
			locationTV = (TextView) itemView.findViewById(R.id.location);
		}

		public void bindBean(ComplaintBean bean) {
			dateTV.setText(bean.getDate().toString());
			typeTV.setText(bean.getType());
			locationTV.setText(bean.getLocation());
		}

	}
}
