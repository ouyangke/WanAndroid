package com.oyke.wanandroid.ui.page;

import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.blankj.utilcode.util.ToastUtils;
import com.oyke.baselibrary.base.BaseFragment;
import com.oyke.wanandroid.R;
import com.oyke.wanandroid.databinding.FragmentMainBinding;
import com.oyke.wanandroid.viewmodel.state.MainViewModel;


/**
 * Description:    主界面
 * Author:         oyke
 * CreateDate:     2020/3/29 12:49
 */
public class MainFragment extends BaseFragment<FragmentMainBinding, MainViewModel> {
    private long mExitTime;
    private Toolbar mToolbar;
    private NavController navMain;
    private NavController navRoot;

    @Override
    protected void initParam() {

    }

    @Override
    protected int initContentView() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initBinding() {
        mBinding.setClick(new ClickProxy());
    }

    @Override
    protected void initData() {
        mToolbar = mBinding.includeToolbar.toolbar;
        mActivity.setSupportActionBar(mToolbar);
        mActivity.getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {

                if (System.currentTimeMillis() - mExitTime <= 2000) {
                    mActivity.finish();
                } else {
                    mExitTime = System.currentTimeMillis();
                    ToastUtils.setBgColor(getResources().getColor(R.color.transparent_75));
                    ToastUtils.setMsgColor(getResources().getColor(R.color.White));
                    ToastUtils.setGravity(Gravity.CENTER, 0, 0);
                    ToastUtils.showShort(getString(R.string.exit_tip));
                }


            }
        });

        navRoot = Navigation.findNavController(mActivity, R.id.nhf_root);

        navMain = Navigation.findNavController(mActivity, R.id.nhf_main);
        NavigationUI.setupWithNavController(mBinding.bnvMain, navMain);
        mBinding.bnvMain.setOnNavigationItemSelectedListener(item -> {
            changePage(item.getItemId());
            return false;
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(mActivity, mBinding.dlMain, mToolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mBinding.dlMain.addDrawerListener(toggle);
        toggle.syncState();

        mBinding.nvMain.setNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.scoreFragment:
                    navRoot.navigate(R.id.action_mainFragment_to_scoreFragment);
                    break;
                case R.id.collectFragment:
                    navRoot.navigate(R.id.action_mainFragment_to_collectFragment);
                    break;
                case R.id.shareFragment:
                    navRoot.navigate(R.id.action_mainFragment_to_shareFragment);
                    break;
                case R.id.todoFragment:
                    navRoot.navigate(R.id.action_mainFragment_to_todoFragment);
                    break;
                case R.id.nav_night_mode:
                    break;
                case R.id.settingFragment:
                    navRoot.navigate(R.id.action_mainFragment_to_settingFragment);
                    break;
                case R.id.nav_logout:
                    break;
                default:
                    break;
            }
            return false;
        });


    }

    @Override
    protected void initViewObservable() {

    }


    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        if (mBinding.bnvMain.getSelectedItemId() != R.id.squareFragment) {
            inflater.inflate(R.menu.menu_main, menu);
        }
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                navRoot.navigate(R.id.action_mainFragment_to_searchFragment);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 切换页面
     *
     * @param itemId 页面id
     */
    private void changePage(int itemId) {
        navMain.navigate(itemId);
        switch (itemId) {
            case R.id.homeFragment:
                mToolbar.setTitle(R.string.app_name);
                break;
            case R.id.squareFragment:
                mToolbar.setTitle(R.string.square);
                break;
            case R.id.weChatFragment:
                mToolbar.setTitle(R.string.wechat);
                break;
            case R.id.systemFragment:
                mToolbar.setTitle(R.string.knowledge_system);
                break;
            case R.id.projectFragment:
                mToolbar.setTitle(R.string.project);
                break;
            default:
                break;
        }
    }


    public class ClickProxy {

        public void onFABClick() {

        }
    }


}
