package ${leiPackage};
import com.haier.openplatform.domain.BaseDomain;

public class ${leiName} extends SearchModel{
	<#list liemodel as col>
  	//${col.zhushi}
	private ${col.javaType} ${col.lieJaveName};
	</#list>
}