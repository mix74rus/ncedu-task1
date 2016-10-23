package org.lavrinovich;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Controller
public class ClassifyController {


    private Classificator classificator;

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setClassificator(Classificator classificator) {
        this.classificator = classificator;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @RequestMapping(value = {"/ClassifyNumber", "/ClassifyNumber/"}, method = RequestMethod.GET)
    public String processNumber(@RequestParam Map<String,String> allRequestParams, Map<String, Object> model){
        String number = allRequestParams.get("number");
        if (number == null){
            return "/WEB-INF/views/hello.jsp";
        }
        try {
            model.put("number", number);
            Integer n = Integer.valueOf(number);
            List<Result> results = jdbcTemplate.query("select * from results where number =" + n, new ResultMapper());
            if (results.size() != 0){
                model.put("isFromCache", true);
                model.put("classification", results.get(0).getMap());
            } else {
                Map<String,Boolean> map = classificator.classifyNumber(n);
                model.put("classification",classificator.classifyNumber(n));
                jdbcTemplate.update("insert into results (number, result) values (?,?)",n,map);
            }
        } catch (NumberFormatException e){
            model.put("Message", number.toString() + " is not a number");
            return "/WEB-INF/views/error.jsp";
        } catch (DataAccessException e) {
            model.put("Message", "Cant access DB");
            return "/WEB-INF/views/error.jsp";
        }
        return "/WEB-INF/views/classify.jsp";
    }

    private static class Result {

        private int n;
        private Map<String, Boolean> map;
        public int getN() {
            return n;
        }

        public void setN(int n) {
            this.n = n;
        }

        public Map<String, Boolean> getMap() {
            return map;
        }

        public void setMap(Map<String, Boolean> map) {
            this.map = map;
        }

    }
    private static class ResultMapper implements RowMapper<Result> {
        @Override
        public Result mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Result result = new Result();
            result.setN(resultSet.getInt("number"));
            try {
                result.setMap((Map<String, Boolean>)
                        new ObjectInputStream(resultSet.getBlob("result").
                                getBinaryStream()).readObject());
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            return result;
        }
    }
}
