package com.example.snack;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment1 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.frag1,container,false);
        homepagetest(v);
        return v;
    }

    public void homepagetest(View v){
        Button bt1 =v.findViewById(R.id.imageView2);
        Button bt2 =v.findViewById(R.id.imageView3);
        Button bt3 =v.findViewById(R.id.imageView4);
        Button bt4 =v.findViewById(R.id.imageView5);
        Button bt5 =v.findViewById(R.id.imageView6);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),Xiangqing.class);
                i.putExtra("分类号",9);
                i.putExtra("商品号",1);
                startActivity(i);
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),Xiangqing.class);
                i.putExtra("分类号",9);
                i.putExtra("商品号",2);
                startActivity(i);
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),Xiangqing.class);
                i.putExtra("分类号",9);
                i.putExtra("商品号",3);
                startActivity(i);
            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),Xiangqing.class);
                i.putExtra("分类号",9);
                i.putExtra("商品号",4);
                startActivity(i);
            }
        });

        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),Xiangqing.class);
                i.putExtra("分类号",9);
                i.putExtra("商品号",5);
                startActivity(i);
            }
        });
    }

}
