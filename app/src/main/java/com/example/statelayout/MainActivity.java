package com.example.statelayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.statelayout_lib.OnReLoadListener;
import com.example.statelayout_lib.StateLayout;
import com.example.statelayout_lib.StateLayoutManager;

public class MainActivity extends AppCompatActivity implements OnReLoadListener {

    private StateLayout mStateLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mStateLayout = findViewById(R.id.state_layout);
        mStateLayout.setLayoutManager(
                new StateLayoutManager.Builder()
                        .setContentLayoutResId(R.layout.default_content)
                        .setLoadingLayoutResId(R.layout.default_loading)
                        .setEmptyDataLayoutResId(R.layout.default_empty_data)
                        .setNetErrorLayoutResId(R.layout.default_net_error)
                        .setErrorLayoutResId(R.layout.default_error)
                        .setNetErrorReLoadViewResId(R.id.btn_load)
                        .setErrorReLoadViewResId(R.id.btn_load)
                        .setOnReLoadListener(this)
                        .build()
        );
        mStateLayout.showContentLayout();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.content:
                mStateLayout.showContentLayout();
                break;
            case R.id.loading:
                mStateLayout.showLoadingLayout();
                break;
            case R.id.empty_data:
                mStateLayout.showEmptyDataLayout();
                break;
            case R.id.net_error:
                mStateLayout.showNetErrorLayout();
                break;
            case R.id.error:
                mStateLayout.showErrorLayout();
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public void reLoad() {
        Toast.makeText(this, "ReLoad", Toast.LENGTH_SHORT).show();
    }
}
