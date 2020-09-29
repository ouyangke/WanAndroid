package com.oyke.wanandroid.ui.page;

import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;

import com.oyke.baselibrary.base.BaseFragment;
import com.oyke.baselibrary.base.DataBindingConfig;
import com.oyke.wanandroid.R;

import java.lang.reflect.Field;


/**
 * Description:    搜索
 * Author:         oyke
 * CreateDate:     2020/3/29 12:49
 */
public class SearchFragment extends BaseFragment {

    @Override
    protected void initViewModel() {

    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return null;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_search, menu);
        SearchView mSearchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        mSearchView.setMaxWidth(Integer.MAX_VALUE);
        mSearchView.onActionViewExpanded();
        mSearchView.setQueryHint(getString(R.string.search_tint));
        mSearchView.setOnQueryTextListener(mOnQueryTextListener);
        mSearchView.setSubmitButtonEnabled(true);
        try {
            Field mField = mSearchView.getClass().getDeclaredField("mGoButton");
            mField.setAccessible(true);
            ImageView mGoButton = (ImageView) mField.get(mSearchView);
            mGoButton.setImageResource(R.drawable.ic_search_white_24dp);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        super.onCreateOptionsMenu(menu, inflater);
    }

    private SearchView.OnQueryTextListener mOnQueryTextListener = new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            return false;
        }
    };

}
