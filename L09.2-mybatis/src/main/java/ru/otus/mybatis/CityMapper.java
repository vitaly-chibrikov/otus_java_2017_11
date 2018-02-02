package ru.otus.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface CityMapper {

    @Select("select * from city where state=#{state}")
    List<City> findCityByState(@Param("state") String state);

    @SelectProvider(type = CityQueries.class, method = "findCityByCountry")
    List<City> findCityByCountry(String country);


}
