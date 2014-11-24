package com.xy.common;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Service;

import com.xy.domain.BeanModel;
import com.xy.domain.LieModel;

@Service
public class BeanServiceImpl implements BeanService {

	@Resource(name = "dataSource")
	private DataSource ds;

	@Override
	public BeanModel getBeanModel(String tname) {
		BeanModel bm = new BeanModel();
		bm.setTableName(tname);
		List<LieModel> lm = new ArrayList<LieModel>();
		Connection conn;
		try {
			conn = ds.getConnection();
			String sql = "select a.COLUMN_NAME, a.DATA_TYPE, a.DATA_LENGTH, a.DATA_PRECISION, a.DATA_SCALE, "+
					       " a.NULLABLE,"+
					       " b.COMMENTS　from user_tab_columns a,"+
					       " user_col_comments b"+
					       " where a.table_name = b.table_name"+
					       " and a.column_name = b.column_name"+
					       " and a.table_name = UPPER('" + tname + "')";
			Statement st = null;
			LieModel m = null;
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				m = new LieModel();
				m.setLiename(rs.getString("COLUMN_NAME").toLowerCase());// 获取字段名
				m.setLietype(rs.getString("DATA_TYPE").toLowerCase());// 获取数据类型
				m.setLength(rs.getString("DATA_LENGTH"));
				m.setPrecision(rs.getString("DATA_PRECISION"));
				m.setScale(rs.getString("DATA_SCALE"));
				m.setZhushi(rs.getString("COMMENTS")==null?"":rs.getString("COMMENTS"));
				lm.add(m);
			}
			bm.setLiemodel(lm);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bm;
	}

}
