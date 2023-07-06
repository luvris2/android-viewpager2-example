package com.example.ViewPager2Test;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPager2Adapter extends FragmentStateAdapter {
    // 뷰페이저에 보여줄 페이지 개수 설정
    private static final int NUM_PAGES = 2;

    // 프래그먼트로 구성된 어댑터일 경우 MainActivity가 아닌 Fragment로 초기화하여야 함
    public ViewPager2Adapter(@NonNull MainActivity mainActivity) {
        super(mainActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // 반환할 프래그먼트 인스턴스 생성 및 초기화
        Fragment fragment = new FirstFragment();

        // 해당 위치(position)에 따라 프래그먼트 반환
        if (position == 0) // 첫번째 위치일 경우 FirstFragment 화면 반환
            fragment = new FirstFragment();
        else if (position ==1) // 첫번째 위치일 경우 FirstFragment 화면 반환
            fragment = new SecondFragment();

        // 위치에 따른 프래그먼트 반환
        return fragment;
    }

    @Override
    public int getItemCount() {
        return NUM_PAGES; // 전체 아이템 수 반환
    }
}
