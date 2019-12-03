package com.example.snack;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Fragment2 extends Fragment {
    public String[] data={"新品尝鲜","热卖爆款","坚果炒货","糕点甜心"};//左边列表的原始数据
    //分类1里商品的图片名字和价格
    public int[] images1={R.drawable.mangguogan,R.drawable.whsg,R.drawable.jylw,R.drawable.hjm,R.drawable.stb,R.drawable.jmrmb,R.drawable.jxhfb,R.drawable.rsjmb,};
    public String[] names1={"芒果干166g×3袋","什锦水果罐头200g×3罐","解压鸭肉卤味包","火鸡面685g","石头饼220g×2袋","酵母软面包","夹心华夫面包","乳酸菌风味小口袋面板"};
    public String[] prices1={"28.9","16.9","59.9","17.9","14.9","52.1","28.9","21.9"};
    public String[] details1={"第二件下单立减20","奶昔糖","礼包零食组合搭配","内含5小袋独立小包装","华夏智慧 古法传承"};
    //分类2里商品的图片名字和价格
    public int[] images2={R.drawable.rsjxbl,R.drawable.yjmg,R.drawable.nqmm,R.drawable.qshls,R.drawable.jgdlb,};
    public String[] names2={"乳酸菌小伴侣800g/箱","山东羊角木瓜5斤装","牛气满满包","抢手货零食包1067g","坚果大礼包"};
    public String[] prices2={"34.9","39.9","58.9","35.9","88"};
    public String[] details2={"第二件下单立减20","奶昔糖","礼包零食组合搭配","内含5小袋独立小包装","华夏智慧 古法传承"};

    public int[] images3={R.drawable.dbsz,R.drawable.mrjglh,R.drawable.zpyg,R.drawable.bfgg,R.drawable.sblr,};
    public String[] names3={"东北松子200g/袋","每日坚果礼盒750g/30袋","紫皮腰果190g","缤纷水果干大礼包","2袋装熟板栗仁80g/袋"};
    public String[] prices3={"59.9","149","39.9","45.9","18.9"};
    public String[] details3={"第二件下单立减20","奶昔糖","礼包零食组合搭配","内含5小袋独立小包装","华夏智慧 古法传承"};

    public int[] images4={R.drawable.ssmb,R.drawable.ywrsb,};
    public String[] names4={"原味手撕面包","原味肉松饼",};
    public String[] prices4={"43.9","16.9","52.1","28.9","21.9"};
    public String[] details4={"第二件下单立减20","奶昔糖","礼包零食组合搭配","内含5小袋独立小包装","华夏智慧 古法传承"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.frag2,container,false);//关联frag2页面
        araryadapterTest(v);
        simpleadapterTest(v,images1,names1,prices1,0);
        return v;
    }
    /*加载左边列表数据*/
    public void araryadapterTest(final View v){
        ListView lv=(ListView)v.findViewById(R.id.leftlist);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(),R.layout.leftlistlayout,data);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?>parent,View view,int position,long id){
                if(position==0){//如果点击第一个分类
                    simpleadapterTest(v,images1,names1,prices1,position);
                }
                else if(position==1){//点击第二个分类
                    simpleadapterTest(v,images2,names2,prices2,position);
                }
                else if(position==2){
                    simpleadapterTest(v,images3,names3,prices3,position);
                }
                else if(position==3){
                    simpleadapterTest(v,images4,names4,prices4,position);
                }
            }
        });
    }
    /*本方法加载右边列表数据*/
    public void simpleadapterTest(View v,final int[] images,final String[] names,final String[] prices,final int index){
        //把map集合放到list中
        List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
        //把原始数据放入map集合
        Map<String,Object> map;
        for(int i=0;i<images.length;i++){
            map=new HashMap<String,Object>();
            map.put("image",images[i]);
            map.put("name",names[i]);
            map.put("price",prices[i]);
            list.add(map);
        }

        ListView lv=(ListView)v.findViewById(R.id.rightlist);//找右边列表控件
        //设置simpleadapter适配器
        SimpleAdapter adapter=new SimpleAdapter(getActivity(),list,R.layout.rightlistlayout,new String[]{
                "image","name","price"},new int[]{R.id.imageview1,R.id.shopname,R.id.shopprice}){
            //重写getView方法
            @Override
            public View getView(final int position ,View convertView,ViewGroup parent){
                View layout=super.getView(position,convertView,parent);//加载选项布局
                Button iv=(Button)layout.findViewById(R.id.btnjia);//找要点击的控件
                iv.setOnClickListener(new View.OnClickListener(){//实现点击事件接口
                    @Override
                    public void onClick(View v){
                        Toast.makeText(getActivity(), names[position]+"  已加入到购物车", Toast.LENGTH_SHORT).show();
                        Map<String,Object> cartmap=new HashMap<String,Object>();//把数据添加到购物车集合
                        cartmap.put("cartimage",images[position]);
                        cartmap.put("cartname",names[position]);
                        cartmap.put("cartprice",prices[position]);
                        Cartcount.cartdata.add(cartmap);
                    }
                });
                return layout;
            }
        };
        lv.setAdapter(adapter);//把适配器放到listview控件中
        //点击右边列表跳转到商品详情页面
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?>parent,View view,int position,long id){
                Intent i=new Intent(getActivity(),Xiangqing.class);//跳转到详情页面
                i.putExtra("分类号", index);
                i.putExtra("商品号", position);
                i.putExtra("图片",images[position]);
                i.putExtra("名称",names[position]);
                i.putExtra("价格",prices[position]);
                getActivity().startActivity(i);//启动跳转
            }
        });
    }

}