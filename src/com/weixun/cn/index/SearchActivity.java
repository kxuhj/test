package com.weixun.cn.index;



import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.weixun.cn.R;

public class SearchActivity extends Activity implements SearchView.OnQueryTextListener{
	private SearchView sv;
	private ListView lv;
	ActionBar actionBar;
	private LayoutInflater inflater;
	//自动完成的列表
	private final String[] mStrings={"aaaaaa","bbbbbb","ccccccc"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.index_search_details);
		inflater = getLayoutInflater();
		View title = inflater.inflate(R.layout.index_search_title, null);
		lv=(ListView)title.findViewById(R.id.index_search_sv);
		lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,mStrings));
		lv.setTextFilterEnabled(true);
		sv=(SearchView)title.findViewById(R.id.index_search);
		sv.setOnQueryTextListener(this);
		sv.setSubmitButtonEnabled(false);
		sv.setQueryHint("红酒");
		 int search_mag_icon_id = sv.getContext().getResources().getIdentifier("android:id/search_mag_icon", null, null);
	        ImageView  search_mag_icon = (ImageView)sv.findViewById(search_mag_icon_id);//获取搜索图标
	        search_mag_icon.setImageResource(R.drawable.index_search);//图标都是用src的
		actionBar = getActionBar();
		actionBar.setDisplayShowHomeEnabled(false);
		actionBar.setCustomView(title);
		actionBar.setDisplayShowCustomEnabled(true);
		actionBar.setDisplayShowTitleEnabled(false);
	}
	//用户输入字符时触发改方法
	public boolean onQueryTextChange(String newtext){
		if(TextUtils.isEmpty(newtext)){
			//清除ListView的过滤
			lv.clearTextFilter();
		}else{
			//使用用户输入的内容对listview的列表现进行过滤
			lv.setFilterText(newtext);
			
		}
		return true;
	}
	//单击搜索按钮的时候激发该方法
	public boolean onQueryTextSubmit(String query){
		Toast.makeText(this, "您的选择是"+query, Toast.LENGTH_SHORT).show();
		return false;
	}

}
