@Transactional(readOnly=false)
public class ${leiName}ServiceImpl extends BaseActivitiService implements ${leiName}Service {
	private ${leiName}DAO ${fuperLeiName}Dao;

	/*
	 * 保存${fuperLeiName}
	 */
	@Override
	public void save${leiName}(${leiName} model) {
		${fuperLeiName}Dao.save${leiName}(model);
	}
	/*
	 * 根据id删除 ${fuperLeiName}
	 */
	@Override
	public void delete${leiName}Byid(${leiName} model) {
		${fuperLeiName}Dao.del${leiName}(model);
	}

	/**
	 * 根据id得到${fuperLeiName}
	 */
	@Override
	@Transactional(readOnly=true)
	public ${leiName} get${leiName}ById(${leiName} model) {
		return ${fuperLeiName}Dao.get${leiName}ById(model.getId());
	}
	/*
	 * 更新 ${fuperLeiName}
	 */
	@Override
	public void update${leiName}(${leiName} model) {
		${fuperLeiName}Dao.update${leiName}(model);
	}
	@Override
	@Transactional(readOnly=true)
	public Pager<${leiName}> search${leiName}Pager(${leiName} model) {
		List<${leiName}> yslist = ${fuperLeiName}Dao.search${leiName}PagerList(model);
		Long count = ${fuperLeiName}Dao.get${leiName}sPagerCount(model);
		return Pager.cloneFromPager(model.getPager(), count,yslist);
	}

/**
	 * @return the ${fuperLeiName}Dao
	 */
	public ${leiName}DAO get${leiName}Dao() {
		return ${fuperLeiName}Dao;
	}
	/**
	 * @param ${fuperLeiName}Dao the ${fuperLeiName}Dao to set
	 */
	public void set${leiName}Dao(${leiName}DAO ${fuperLeiName}Dao) {
		this.${fuperLeiName}Dao = ${fuperLeiName}Dao;
	}
	
}