package alladinmarket.com.alladinmarket.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import alladinmarket.com.alladinmarket.R;
import alladinmarket.com.alladinmarket.adapters.CategoryAdaper;
import alladinmarket.com.alladinmarket.adapters.SearchShopkeeperAdaper;

public class ShopKeepersActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private SearchShopkeeperAdaper mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_search_product);

        mRecyclerView = (RecyclerView)findViewById(R.id.rv_search_product_list);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new SearchShopkeeperAdaper();
        mAdapter.setOnItemClickListener(new CategoryAdaper.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                Intent i = new Intent(ShopKeepersActivity.this,ShopkeeprDetail.class);
                startActivity(i);
            }
        });

        mRecyclerView.setAdapter(mAdapter);
    }
}
