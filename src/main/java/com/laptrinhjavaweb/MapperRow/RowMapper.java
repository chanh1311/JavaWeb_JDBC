package com.laptrinhjavaweb.MapperRow;

import java.sql.ResultSet;
import java.util.List;

public interface RowMapper<T> {
	 List<T> mapRow(ResultSet resultSet);
}
