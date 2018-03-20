package ua.com.serhii.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.com.serhii.entity.Lector;
import ua.com.serhii.entity.helpingModels.Degree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class JDBCLectorDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Lector findHead(String departmentName) {
        String sql = "SELECT LEC.* FROM LECTOR LEC JOIN DEPARTMENT DEP " +
                "ON LEC.DEPARTMENT_ID = DEP.ID WHERE DEP.NAME =? AND LEC.IS_HEAD = TRUE";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, departmentName);
        List<Lector> lectors = new ArrayList<>();
        for (Map m : list) {
            Lector lector = new Lector();
            lector.setId((Long) m.get("ID"));
            lector.setFirstName((String) m.get("FIRST_NAME"));
            lector.setLastName((String) m.get("LAST_NAME"));
            lector.setHead((Boolean) m.get("IS_HEAD"));
            lector.setDegree(Degree.valueOf((String) m.get("DEGREE")));
            lector.setSalary((Double) m.get("SALARY"));
            lectors.add(lector);
        }
        return lectors.stream().findFirst().get();
    }

    public Map<Degree, Integer> statistic(String departmentName) {
        String sql = "SELECT LEC.DEGREE AS DEGREE, COUNT(LEC.DEGREE) AS NUM FROM LECTOR LEC JOIN DEPARTMENT DEP " + "ON LEC.DEPARTMENT_ID = DEP.ID WHERE DEP.NAME =? GROUP BY LEC.DEGREE";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, departmentName);
        Map<Degree, Integer> stat = new HashMap<>();
        for (Map m : list){
            Degree degree = Degree.valueOf((String) m.get("DEGREE"));
            Long count = (Long) m.get("NUM");
            stat.put(degree, count.intValue());
        }
        return stat;
    }

    public Double avgSalary(String departmentName){
        String sql = "SELECT CAST(AVG (LEC.SALARY) AS DECIMAL (12,2)) FROM LECTOR LEC JOIN DEPARTMENT DEP " + "ON LEC.DEPARTMENT_ID = DEP.ID  WHERE DEP.NAME = ? GROUP BY LEC.SALARY";
        return jdbcTemplate.queryForObject(sql, new Object[]{departmentName}, Double.class);
    }

    public Integer employeeCount(String departmentName) {
        String sql = "SELECT COUNT(*) FROM LECTOR LEC JOIN DEPARTMENT DEP " +
                "ON LEC.DEPARTMENT_ID = DEP.ID WHERE DEP.NAME = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{departmentName}, Integer.class);
    }

    public List<Lector> search(String s) {
        String sql = "SELECT * FROM LECTOR WHERE FIRST_NAME LIKE '%" + s + "%' OR LAST_NAME LIKE '%" + s + "%'";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        List<Lector> lectors = new ArrayList<>();
        for (Map m : list) {
            Lector lector = new Lector();
            lector.setId((Long) m.get("ID"));
            lector.setFirstName((String) m.get("FIRST_NAME"));
            lector.setLastName((String) m.get("LAST_NAME"));
            lector.setHead((Boolean) m.get("IS_HEAD"));
            lector.setDegree(Degree.valueOf((String) m.get("DEGREE")));
            lector.setSalary((Double) m.get("SALARY"));
            lectors.add(lector);
        }
        return lectors;
    }
}
