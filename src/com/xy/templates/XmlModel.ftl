


<bean id="${fuperLeiName}Dao" class="org.mybatis.spring.mapper.MapperFactoryBean" parent="baseDAO">
	<property name="mapperInterface" value="com.haier.openplatform.alm.${muKuai}.dao.${leiName}DAO" />
</bean>
<bean id="${fuperLeiName}Service" class="com.haier.openplatform.alm.${muKuai}.service.impl.${leiName}ServiceImpl" parent="activitiBaseService">
	<property name="${fuperLeiName}Dao" ref="${fuperLeiName}Dao"></property>
</bean>	
