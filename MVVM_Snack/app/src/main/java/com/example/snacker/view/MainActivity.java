package com.example.snacker.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.example.snacker.R;
import com.example.snacker.model.Database;
import com.example.snacker.viewmodel.ViewModel;
import com.example.snacker.databinding.ActivityMainBinding;
import com.orhanobut.logger.Logger;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding; // 상속 ViewDataBinding
    ViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Logger.d("Main_onCrete() 실행");
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main); // Activity Content's View - Layout 연결 & 반환 : ViewDataBinding을 상속하는 제네릭 타입

        viewModel = new ViewModel(Database.getInstance());
        binding.setViewModel(viewModel);

        binding.okBtnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Logger.d("버튼 클릭");
                viewModel.getUser();
            }
        });
    }
}