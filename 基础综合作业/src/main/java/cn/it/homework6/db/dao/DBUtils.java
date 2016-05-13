package cn.it.homework6.db.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import cn.it.homework6.db.DBHelper;
/**数据库访问工具类
 * @author lijun
 */
public class DBUtils {
	private static final String TABLE = "t_diary";
	private DBHelper dbHelper;

	public DBUtils(Context context) {
		dbHelper = new DBHelper(context);
	}
 //保存日记
	public int save(ContentValues values) {
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		long id = db.insert(TABLE, null, values);
		db.close();
		return (int) id;
	}
  //查看日记详细信息
	public Map<String, Object> getDetail(int id) {
		Map<String, Object> map = null;
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		Cursor query = db.query(TABLE, null, "_id="+id, null, null, null, null);
		if (query.moveToNext()) {
			map = new HashMap<String, Object>();
			map.put(query.getColumnName(0), query.getInt(0));
			map.put(query.getColumnName(1), query.getString(1));
			map.put(query.getColumnName(2), query.getString(2));
		}
		query.close();
		db.close();

		return map;
	}
    // 用户表  ：int  id   string name   String pwd
	// 查询日记列表 id title content
	public List<Map<String, Object>> queryList() {
		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();;
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		Cursor query = db.query(TABLE, null, null, null, null, null, null);
		while (query.moveToNext()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(query.getColumnName(0), query.getInt(0));  // key :_id  values:1     content  title 
			map.put(query.getColumnName(1), query.getString(1));
			map.put(query.getColumnName(2), query.getString(2));
			data.add(map);
		}
		query.close();
		db.close();
		return data;
	}


}
