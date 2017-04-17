package ro.craiova.craiova;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;

import ro.craiova.craiova.pages.main.MainFragment;
import ro.craiova.craiova.pages.record.AddRecordFragment;
import ro.craiova.craiova.pages.record.MyRecordsFragment;

import static android.R.attr.bitmap;

public class MainActivity extends AppCompatActivity implements MainFragment.OnMainFragmentInteractionListener, FragmentManager.OnBackStackChangedListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Fragment main = new MainFragment();
		getSupportFragmentManager().beginTransaction().replace(R.id.container, main).commit();

		getSupportFragmentManager().addOnBackStackChangedListener(this);

		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		toolbar.setTitle(R.string.app_name);

//		Palette p = createPaletteSync(BitmapFactory.decodeResource(getResources(), R.drawable.craiova4));
//		Palette.Swatch vibrantSwatch = checkVibrantSwatch(p);
//		toolbar.setBackgroundColor(vibrantSwatch.getRgb());
//		getSupportActionBar().setDisplayShowHomeEnabled(true);
	}

	@Override
	public boolean onSupportNavigateUp() {
		onBackPressed();
		return true;
	}

	@Override
	public void onNavigationTileClicked(String fragmentTag) {
		if (AddRecordFragment.TAG.equals(fragmentTag)) {
			FragmentTransaction fT = getSupportFragmentManager().beginTransaction();
			fT.replace(R.id.container, new AddRecordFragment());
			fT.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
			fT.addToBackStack(null);
			fT.commit();
			getSupportActionBar().setTitle(R.string.add_complaint);
		} else if (MyRecordsFragment.TAG.equals(fragmentTag)) {
			FragmentTransaction fT = getSupportFragmentManager().beginTransaction();
			fT.replace(R.id.container, new MyRecordsFragment());
			fT.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
			fT.addToBackStack(null);
			fT.commit();
			getSupportActionBar().setTitle(R.string.my_complaints);
		}
	}

	@Override
	public void onBackStackChanged() {
		if (getSupportFragmentManager().getBackStackEntryCount() > 0) {//the first fragment is not added to the backstack
			getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		} else {
			getSupportActionBar().setDisplayHomeAsUpEnabled(false);
			getSupportActionBar().setTitle(R.string.app_name);
		}
	}

	// Return a palette's vibrant swatch after checking that it exists
	private Palette.Swatch checkVibrantSwatch(Palette p) {
		Palette.Swatch vibrant = p.getVibrantSwatch();
//		if (vibrant != null) {
			return vibrant;
//		}
		// Throw error
	}

	// Generate palette synchronously and return it
	public Palette createPaletteSync(Bitmap bitmap) {
		Palette p = Palette.from(bitmap).generate();
		return p;
	}

	// Generate palette asynchronously and use it on a different
// thread using onGenerated()
	public void createPaletteAsync(Bitmap bitmap) {
		Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
			public void onGenerated(Palette p) {
				// Use generated instance
			}
		});
	}
}
