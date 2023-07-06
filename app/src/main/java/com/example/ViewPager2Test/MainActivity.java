package com.example.ViewPager2Test;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;


public class MainActivity extends AppCompatActivity {

    // 뷰페이저2 인스턴스
    private ViewPager2 viewPager2;
    // 뷰페이저2를 보여줄 어댑터
    private ViewPager2Adapter adapter;

    // 텍스트뷰 버튼 객체 생성 : tvBtn1(왼쪽버튼), tvBtn2(오른쪽버튼)
    // 현재 뷰페이저2의 페이지 위치를 확인하기 위함
    TextView tvBtn1;
    TextView tvBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 뷰페이저2 어댑터 설정
        viewPager2 = findViewById(R.id.viewPager2);
        adapter = new ViewPager2Adapter(this); // 어댑터 생성
        viewPager2.setAdapter(adapter);

        // 뷰페이저2의 페이지 전환 시 콜백 함수
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                // 뷰페이저2의 페이지 인덱스를 확인하여 텍스트뷰 버튼 색상 변경
                CurrentPositionChk(position);
            }
        });

        // 텍스트뷰 버튼 객체 연결 : tvBtn1(왼쪽버튼), tvBtn2(오른쪽버튼)
        tvBtn1 = findViewById(R.id.textView0);
        tvBtn2 = findViewById(R.id.textView1);

        // 왼쪽 텍스트뷰 클릭 이벤트 : ViewPager2에서 Fragment1의 화면으로 이동
        tvBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager2.setCurrentItem(0);
            }
        });

        // 오른쪽 텍스트뷰 클릭 이벤트 : ViewPager2에서 Fragment2의 화면으로 이동
        tvBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager2.setCurrentItem(1);
            }
        });
    }

    // 뷰페이저2의 페이지 변경 시 페이지에 맞게 버튼의 색상을 변경해주는 함수
    public void CurrentPositionChk(int position) {
        // 프래그먼트 화면 인덱스 저장 함수
        int currentFragmentId = 0;

        // 페이지 인덱스 정보 저장
        if (currentFragmentId != position) { currentFragmentId = position; }

        // 텍스트뷰 버튼 객체 연결 : tvBtn1(왼쪽버튼), tvBtn2(오른쪽버튼)
        tvBtn1 = findViewById(R.id.textView0);
        tvBtn2 = findViewById(R.id.textView1);

        // 텍스트뷰 버튼 색상 정의 : 보라색, 현재 페이지의 위치를 구분하기 위해 선택된 페이지의 투명도를 더 높게 설정
        String BaseHexColor = "#E29EFF";
        int rgbColor = Color.parseColor(BaseHexColor);
        int selectedAlpha = 128;
        int unselectedAlpha = 25;

        // 첫번째 화면일 경우 왼쪽 버튼 활성화 표시 (배경색을 진하게 함)
        if (currentFragmentId == 0) {
            tvBtn1.setBackgroundColor(
                    Color.argb(selectedAlpha, Color.red(rgbColor), Color.green(rgbColor), Color.blue(rgbColor))
            );
            tvBtn2.setBackgroundColor(
                    Color.argb(unselectedAlpha, Color.red(rgbColor), Color.green(rgbColor), Color.blue(rgbColor))
            );
        }
        // 두번째 화면일 경우 오른쪽 버튼 활성화 표시 (배경색을 진하게 함)
        else if (currentFragmentId == 1) {
            tvBtn1.setBackgroundColor(
                    Color.argb(unselectedAlpha, Color.red(rgbColor), Color.green(rgbColor), Color.blue(rgbColor))
            );
            tvBtn2.setBackgroundColor(
                    Color.argb(selectedAlpha, Color.red(rgbColor), Color.green(rgbColor), Color.blue(rgbColor))
            );
        }
    }
}