<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
"http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.haier.openplatform.alm.${muKuai}.dao.${leiName}DAO">
	<!-- oracle 分页头 -->
	<sql id="pagination_Head">
		<![CDATA[select * from ( select row_.*, rownum rownum_ from ( ]]>
	</sql>
	<!-- oracle 分页尾 -->
	<sql id="pagination_Tail">
	  <![CDATA[) row_ where rownum <= ${"#{"}model.pager.pageSize} * ${"#{"}model.pager.currentPage} ) where rownum_ >= ${"#{"}model.pager.firstResult} + 1]]>
	</sql>
	<!-- count * from -->
	<sql id="count_Start_Head">
		<![CDATA[select count(*) from ( ]]>
	</sql>
	<sql id="count_Start_Tail">
		<![CDATA[)]]>
	</sql>

	<resultMap id="${fuperLeiName}Map" type="${leiQuanName}">
		<#list liemodel as col>
		<result property="${col.lieJaveName}" column="${col.liename}" /><!-- ${col.zhushi} -->
		</#list>
	</resultMap>

	<!-- 保存信息 -->
	<insert id="save${leiName}">
		<selectKey keyProperty="model.id" order="BEFORE" resultType="long">
			SELECT XXXX.NEXTVAL FROM DUAL
		</selectKey>
		<![CDATA[
		insert into ${tableName} (
			${allLie})
		values (
			${allLieFlag}			
		   )
		]]>
	</insert>
	<!-- 根据xxx删除 -->
	<delete id="del${leiName}">
		<![CDATA[
		delete from ${tableName} where id = ${"#{"}model.id}
		]]>
	</delete>
	
	<!-- 保存信息 -->
	<update id="update${leiName}" >
		<![CDATA[
		update ${tableName}
			set ${updateLieFlag}  
		where id = ${"#{"}model.id}
		]]>
	</update>
	
	<!-- 根据ID查询-->
	<select id="get${leiName}ById" parameterType="Long" resultMap="${fuperLeiName}Map">
		<include refid="searchAll_sql" />
		<![CDATA[
		where t.id = ${"#{"}id}
		]]>
	</select>
	<!-- 根据其他条件查询-->
	<select id="get${leiName}By${leiName}" resultMap="${fuperLeiName}Map">
		<include refid="searchAll_sql" />
		<![CDATA[
		where t.id = ${"#{"}id}
		]]>
	</select>
	
	
	
	<!-- 查询所有字段 -->
	<sql id="searchAll_sql">
		<![CDATA[
	    select ${allLie}
	      from ${tableName} t
		  ]]>
	</sql>
	<!-- 根据条件查询 -->
	<sql id="searchWhere_sql">
		<include refid="searchAll_sql" />
		where id = ${"#{"}model.id}
	</sql>
	
	<!-- 带条件的分页查询 -->
	<select id="search${leiName}PagerList"
		resultMap="${fuperLeiName}Map">
		<include refid="pagination_Head" />
		<include refid="searchWhere_sql" />
		<include refid="pagination_Tail" />
	</select>
	<!-- 带条件的分页查询合计 -->
	<select id="get${leiName}sPagerCount"
		resultType="long">
		<include refid="count_Start_Head" />
		<include refid="searchWhere_sql" />
		<include refid="count_Start_Tail" />
	</select>
	
</mapper>