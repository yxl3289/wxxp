package com.example.snack;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class Fragment3 extends Fragment {
    public static SimpleAdapter adapter;

    public TextView sumtext;  //用于存放总价控件
    private Button clearbt;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.frag3,container,false);
        simpleadapterTest( v);
        sumtext=(TextView)v.findViewById(R.id.sum);
        clearbt=(Button)v.findViewById(R.id.clear);
        initclear();
        return v;
    }
    public void simpleadapterTest(View v){
        ListView lv=(ListView)v.findViewById(R.id.cartlist);//找右边列表控件
        //设置simpleadapter适配器
        adapter=new SimpleAdapter(getActivity(),Cartcount.cartdata,R.layout.cartlistlayout,new String[]{
                "cartimage","cartname","cartprice"},new int[]{R.id.cartimage,R.id.cartname,R.id.cartprice}){
            //重写getView方法
            @Override
            public View getView(final int position ,View convertView,ViewGroup parent){
                final View layout=super.getView(position,convertView,parent);//加载选项布局
                Button jian=(Button)layout.findViewById(R.id.jian); //找点击减按钮
                jian.setOnClickListener(new View.OnClickListener() { //为减按钮添加点击事件

                    @Override
                    public void onClick(View arg0) {
                        TextView tv=(TextView)layout.findViewById(R.id.zonge);  //找数量控件
                        int count=Integer.parseInt(tv.getText().toString()); //获取原有数量并转换成 Int型
                        if(count>0){
                            count--;			//每点击一次减1
                            tv.setText(""+count); 			//把数量传递给控件
                            TextView pricetext=(TextView)layout.findViewById(R.id.cartprice);//找价格控件
                            String pricestr1=pricetext.getText().toString();
                            String[] pricestr2=pricestr1.split("元"); //以元为界限，将前后分为两个数据
                            String pricestr3=pricestr2[0];
                            double price=Double.parseDouble(pricestr3);  //把字符串转换成小数
                            Cartcount.sumprice -=price; //每点击一次减一个单价
                            sumtext.setText(String.format("%.2f",Cartcount.sumprice)); //保留两位小数，并设置给总价控件
                        }
                    }
                });
                Button jia=(Button)layout.findViewById(R.id.jia); //找点击加按钮
                jia.setOnClickListener(new View.OnClickListener() {	//为加按钮添加点击事件

                    @Override
                    public void onClick(View arg0) {
                        TextView tv=(TextView)layout.findViewById(R.id.zonge);  //找数量控件
                        int count=Integer.parseInt(tv.getText().toString()); //获取原有数量并转换成 Int型
                        count++;			//每点击一次减1
                        tv.setText(""+count); 			//把数量传递给控件
                        TextView pricetext=(TextView)layout.findViewById(R.id.cartprice);//找价格控件
                        String pricestr1=pricetext.getText().toString();
                        String[] pricestr2=pricestr1.split("元"); //以元为界限，将前后分为两个数据
                        String pricestr3=pricestr2[0];
                        double price=Double.parseDouble(pricestr3);  //把字符串转换成小数
                        Cartcount.sumprice +=price;  //每点击一次加一次单价
                        sumtext.setText(String.format("%.2f",Cartcount.sumprice)); //保留两位小数，并设置给总价控件
                    }
                });
                return layout;
            }
        };
        lv.setAdapter(adapter);//把适配器放到listview控件中
    }
    public void initclear(){
        clearbt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Cartcount.cartdata.clear();  //清空购物车集合
                adapter.notifyDataSetChanged();		//刷新购物车列表
                Cartcount.sumprice=0;		//清空总价
                sumtext.setText("0"); 		//清空总价控件
            }
        });
    }
}
