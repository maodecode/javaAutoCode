package com.haier.openplatform.alm.${muKuai}.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ${leiQuanName};
import com.haier.openplatform.alm.${muKuai}.model.${leiName}SearchModel;
import com.haier.openplatform.dao.CommonDAO;

/**
 * 对${leiName}实体进行CRUD操作
 */
public interface ${leiName}DAO extends CommonDAO{	

	/**
	 * @param ${fuperLeiName}
	 * 添加
	 */
	public void save${leiName}(@Param("model") ${leiName} ${fuperLeiName});	
	/**
	 * @param ${fuperLeiName}
	 * 删除
	 */
	public void del${leiName}(@Param("model") ${leiName} ${fuperLeiName});
	/**
	 * @param ${fuperLeiName}
	 * 修改
	 */
	public void update${leiName}(@Param("model") ${leiName} ${fuperLeiName});
	
	/**
	 * @param 
	 * @return 查找
	 */
	public ${leiName} get${leiName}ById(@Param("id") Long id);
	/**
	 * @param 
	 * @return 查找
	 */
	public ${leiName} get${leiName}By${leiName}(@Param("model") ${leiName} ${fuperLeiName});
	
	/**
	 * @param model
	 */
	public List<${leiName}> search${leiName}PagerList(@Param("model") ${leiName} ${fuperLeiName});
	/**
	 * @param model
	 * @return
	 */
	public long get${leiName}sPagerCount(@Param("model") ${leiName} ${fuperLeiName});
	
}
