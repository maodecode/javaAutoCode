
/**
 * @author Administrator
 *	${leiName}维护action
 */
public class ${leiName}Action extends BaseProjectAction{
	private ${leiName}Service ${fuperLeiName}Service;
	private ${leiName} model = new ${leiName}();
	private Pager pager = new Pager();
	/**
	* 分页查询
	* ${leiName}
	*/
	@Override
	public String execute() throws Exception {
		model.setPager(pager);
		this.pager = ${fuperLeiName}Service.search${leiName}Pager(model);
		return SUCCESS;
	}
	/**
	* 保存实体
	* ${leiName}
	*/
	public String save${leiName}(){
		${fuperLeiName}Service.save${leiName}(model);
		return SUCCESS;
	}
	/**
	* 根据id删除实体
	* ${leiName}
	*/
	public String del${leiName}ByidNosec(){
		try{
			${fuperLeiName}Service.delete${leiName}Byid(model);
		}catch(Exception e){
			this.getJsonResult().setFlag(false);
			this.getJsonResult().setMsg(e.getMessage());
		}
		return SUCCESS;
	}
	
	/**
	*修改实体
	* ${leiName}
	*/
	public String toUpdate${leiName}Nosec(){
		model = ${fuperLeiName}Service.get${leiName}ById(model);
		return SUCCESS;
	}
	public String update${leiName}Nosec(){
		try{
			${fuperLeiName}Service.update${leiName}(model);
		}catch(Exception e){
			this.getJsonResult().setFlag(false);
			this.getJsonResult().setMsg(e.getMessage());
		}
		return SUCCESS;
	}
	/**
	* 根据id得到实体
	* ${leiName}
	*/
	public String get${leiName}(){
		model = ${fuperLeiName}Service.get${leiName}ById(model);
		return SUCCESS;
	}
	
	
	public Pager getPager() {
		return pager;
	}
	public void setPager(Pager pager) {
		this.pager = pager;
	}
	public ${leiName} getModel() {
		return model;
	}
	public void setModel(${leiName} model) {
		this.model = model;
	}
}