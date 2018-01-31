package ru.otus.mybatis;

import org.apache.ibatis.jdbc.SQL;

public class CityQueries {

    public String findCityByCountry(String country) {
        return new SQL() {{
            SELECT("*");
            FROM("city");
            if (country != null) {
                WHERE("country = #{country}");
            }
        }}.toString();
    }
}
