package alladinmarket.com.alladinmarket.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import alladinmarket.com.alladinmarket.R;
import alladinmarket.com.alladinmarket.adapters.MarketAdaper;
import alladinmarket.com.alladinmarket.adapters.SearchProductAdaper;

public class MarketActivity extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_markets);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MarketAdaper();
        mRecyclerView.setAdapter(mAdapter);
    }
}
