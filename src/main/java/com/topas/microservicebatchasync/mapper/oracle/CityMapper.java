package com.topas.microservicebatchasync.mapper.oracle;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.topas.microservicebatchasync.vo.City;


@Mapper
public interface CityMapper {
//	public int insert(Board board);
//	public int update(Board board);
//	public int delete(long id);
//	
//	@Select("SELECT COUNT(*) FROM xboard")
//	public int count();
//	@Select("SELECT * FROM xboard ORDER BY id DESC")
//	public List<Board> selectAll();
//	
//	public Board selectById(long id);
//	public List<Board> selectByLimit(@Param("page") int page, @Param("size") int size);
//	public int increment(@Param("id") long id, @Param("requester") String requester);
//	
//	
//	
	

	  @Insert("INSERT INTO city (name, state, country) VALUES(#{name}, #{state}, #{country})")
	  @Options(useGeneratedKeys = true, keyProperty = "id")
	  void insert(City city);

	  @Select("SELECT id, name, state, country FROM city WHERE id = #{id}")
	  City findById(long id);
	
	
	
	
	
	
	
	
	
}
