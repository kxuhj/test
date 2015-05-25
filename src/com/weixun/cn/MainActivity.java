package com.weixun.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.weixun.cn.index.PublishedActivity;
import com.weixun.cn.index.ReleaseActivity;
import com.weixun.cn.index.SearchActivity;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

@SuppressLint("ViewHolder")
public class MainActivity extends Activity {
	ActionBar actionBar;
	private LinearLayout mGallery;
	private int[] mImgIds;
	private LayoutInflater inflater;

	@SuppressLint("ViewHolder")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.index_activity_main);
		actionBar = getActionBar();
		actionBar.setDisplayShowHomeEnabled(false);
		actionBar.setCustomView(R.layout.index_title);
		actionBar.setDisplayShowCustomEnabled(true);
		actionBar.setDisplayShowTitleEnabled(false);
		inflater = getLayoutInflater();
		// TextView tView=(TextView)findViewById(R.id.index_news);
		// final String sText2 = "<img src=\"/mnt/sdcard/temp/1.jpg\" />3条信息";
		// final Html.ImageGetter imageGetter = new Html.ImageGetter() {
		// public Drawable getDrawable(String source) {
		// Drawable drawable=null;
		// drawable=Drawable.createFromPath(source);
		// drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
		// drawable.getIntrinsicHeight());
		// return drawable;
		// }
		// };
		// tView.setText(Html.fromHtml(sText2, imageGetter, null));
		initData();
		BaseAdapter adapter = new BaseAdapter() {

			public View getView(int position, View convertView, ViewGroup parent) {
				ViewHolder holder;
				if (convertView == null) {
					holder = new ViewHolder();
					convertView = inflater.inflate(R.layout.listview, null);
					holder.headimg = (ImageView) convertView
							.findViewById(R.id.headimg);
					holder.nickname = (TextView) convertView
							.findViewById(R.id.nickname);
					holder.share = (TextView) convertView
							.findViewById(R.id.share);
					holder.title = (TextView) convertView
							.findViewById(R.id.title);
					holder.timetext = (TextView) convertView
							.findViewById(R.id.timetext);
					holder.plun = (TextView) convertView
							.findViewById(R.id.plun);
					holder.love = (TextView) convertView
							.findViewById(R.id.love);
					holder.read = (TextView) convertView
							.findViewById(R.id.read);
					holder.imgs[0] = (ImageView) convertView
							.findViewById(R.id.imageView1);
					holder.imgs[1] = (ImageView) convertView
							.findViewById(R.id.imageView2);
					holder.imgs[2] = (ImageView) convertView
							.findViewById(R.id.imageView3);
					holder.imgs[3] = (ImageView) convertView
							.findViewById(R.id.imageView4);
					convertView.setTag(holder);
				} else {
					holder = (ViewHolder) convertView.getTag();
				}
				holder.headimg.setImageResource(R.drawable.speak_touxiang2);
				holder.nickname.setText("龙兄");
				for (int i = 0; i < mImgIds.length; i++) {
					holder.imgs[i].setImageResource(mImgIds[i]);
				}
				return convertView;
			}

			@Override
			public long getItemId(int position) {
				// TODO Auto-generated method stub
				return position;
			}

			@Override
			public Object getItem(int position) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return 6;
			}
		};
		ListView list = (ListView) findViewById(R.id.listView);
		list.setAdapter(adapter);
		//搜索按钮实现跳转
		Button search = (Button) findViewById(R.id.search);
		search.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent it = new Intent(MainActivity.this, SearchActivity.class);
				startActivity(it);
			}
		});
		//发布按钮实现跳转
		Button publish = (Button) findViewById(R.id.publish);
		publish.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent it = new Intent(MainActivity.this, PublishedActivity.class);
				startActivity(it);
			}
		});

	}

	static class ViewHolder {
		ImageView headimg;
		TextView nickname;
		TextView share;
		TextView title;
		TextView timetext;
		TextView plun;
		TextView love;
		TextView read;
		ImageView img0;
		ImageView img1;
		ImageView img2;
		ImageView img3;
		ImageView[] imgs = { img0, img1, img2, img3 };
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.search) {
			return true;
		} else if (id == R.id.publish) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private void initData() {
		mImgIds = new int[] { R.drawable.action_jiu1, R.drawable.action_jiu2,
				R.drawable.find_2, R.drawable.find_2 };
	}

	//
	private void initView() {
		LayoutInflater inflater = getLayoutInflater();
		View listview = inflater.inflate(R.layout.listview, null);
		LinearLayout layout = (LinearLayout) listview
				.findViewById(R.id.gallery);
		for (int i = 0; i < mImgIds.length; i++) {
			View view = inflater.inflate(R.layout.gallery_item, null);
			ImageView img = (ImageView) view.findViewById(R.id.imageView);
			img.setImageResource(mImgIds[i]);
			layout.addView(view);
		}
	}

	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("nickname", "小小的我");
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("nickname", "打打的是");
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("nickname", "发觉开房间");
		list.add(map);

		return list;
	}
}
