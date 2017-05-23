package com.softworks.origami.velibfinder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.softworks.origami.velibfinder.AccessModel.StationFetcher;
import com.softworks.origami.velibfinder.Fragments.DetailFragment;
import com.softworks.origami.velibfinder.Models.Station;

/**
 * Created by Benjamin on 14/05/2017.
 */

public class DetailsActivity extends AppCompatActivity
{
    private Station stations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        stations = StationFetcher.getInstance().stationList.getValue();

        // Instantiate a ViewPager and a PagerAdapter.
        ViewPager mPager = (ViewPager) findViewById(R.id.pager);
        PagerAdapter mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                invalidateOptionsMenu();
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int pos = extras.getInt("pos");
            mPager.setCurrentItem(pos);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.details_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.share:
                share();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void addString(StringBuilder sb, String header, String msg)
    {
        sb.append(header);
        sb.append(System.getProperty("line.separator"));
        sb.append(msg);
        sb.append(System.getProperty("line.separator"));
        sb.append(System.getProperty("line.separator"));
    }

    private void share()
    {
        StringBuilder sb = new StringBuilder();

        sb.append(getResources().getString(R.string.title));
        sb.append(System.getProperty("line.separator"));
        sb.append(System.getProperty("line.separator"));

        TextView name = (TextView) findViewById(R.id.name);
        addString(sb, getResources().getString(R.string.name),  name.getText().toString());

        TextView status = (TextView) findViewById(R.id.status);
        addString(sb, getResources().getString(R.string.status), status.getText().toString());

        TextView bike_stands  = (TextView) findViewById(R.id.bike_stands);
        addString(sb, getResources().getString(R.string.available_bike_stands), bike_stands.getText().toString());

        TextView address = (TextView) findViewById(R.id.address);
        addString(sb, getResources().getString(R.string.address), address.getText().toString());

        TextView last_update = (TextView) findViewById(R.id.last_update);
        addString(sb, getResources().getString(R.string.last_update), last_update.getText().toString());

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, sb.toString());
        sendIntent.setType("text/plain");
        startActivity(Intent.createChooser(sendIntent, getResources().getText(R.string.share
        )));
    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            DetailFragment fragment = new DetailFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("pos", position);
            fragment.setArguments(bundle);
            return fragment;
        }

        @Override
        public int getCount() {
            return stations.records.size();
        }
    }
}
