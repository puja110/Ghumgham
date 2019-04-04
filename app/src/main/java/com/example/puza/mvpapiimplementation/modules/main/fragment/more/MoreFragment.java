//package com.example.puza.mvpapiimplementation.modules.main.fragment.more;
//
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.support.v7.app.AppCompatActivity;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.example.puza.mvpapiimplementation.application.di.ApplicationComponent;
//import com.example.puza.mvpapiimplementation.application.di.MainApplication;
//import com.example.puza.mvpapiimplementation.modules.main.fragment.more.di.DaggerMoreComponent;
//import com.example.puza.mvpapiimplementation.modules.main.fragment.more.di.MoreModule;
//import com.example.puza.mvpapiimplementation.modules.main.fragment.more.mvp.MorePresenter;
//import com.example.puza.mvpapiimplementation.modules.main.fragment.more.mvp.MoreView;
//
//import javax.inject.Inject;
//
//public class MoreFragment extends Fragment {
//
//    private ApplicationComponent appComponent;
//
//    @Inject
//    MorePresenter morePresenter;
//
//    @Inject
//    MoreView moreView;
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        DaggerMoreComponent.builder()
//                .applicationComponent(MainApplication.get(getActivity()).getApplicationComponent())
//                .moreModule(new MoreModule((AppCompatActivity) getActivity()))
//                .build()
//                .inject(this);
//
//
//        morePresenter.onCreateView();
//
//        return moreView;
//    }
//
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//
//        morePresenter.onDestroyView();
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//    }
//
//}
