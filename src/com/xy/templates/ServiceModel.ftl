
public interface ${leiName}Service {

	void save${leiName}(${leiName} model);

	void delete${leiName}Byid(${leiName} model);

	${leiName} get${leiName}ById(${leiName} model);

	void update${leiName}(${leiName} model);

	Pager search${leiName}Pager(${leiName} model);
}
