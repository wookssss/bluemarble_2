package itschool.bluemarble.dao;

import itschool.bluemarble.dao.base.CommonDao;
import itschool.bluemarble.model.entity.tile.FixedTollCity;
import itschool.bluemarble.model.entity.tile.abs.City;
import itschool.bluemarble.model.enumclass.Color;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CityDao extends CommonDao {
    public static List<City> selectCities() {
        List<City> resultList = new ArrayList<>();

        Connection dbConn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            dbConn = connect();
            st = dbConn.createStatement();
            rs = st.executeQuery("SELECT * FROM city");


            while(rs.next()){
                String name = rs.getString("name");
                Color color = Color.valueOf(rs.getString("color"));
                int index = rs.getInt("index");
                int price = rs.getInt("price");
                int toll = rs.getInt("toll");
                int villaToll = rs.getInt("villa_toll");
                int buildingToll = rs.getInt("building_toll");
                int hotelToll = rs.getInt("hotel_toll");

                City city = new City(index,name, color, toll, price, villaToll, buildingToll, hotelToll);
                resultList.add(city);
            }
            return resultList;
        } catch(SQLException e){
            throw new RuntimeException("selectSCitites 오류 발생\n",e);
        } finally{
            try {
                st.close();
                rs.close();
                dbConn.close();
            } catch(SQLException e){
                throw new RuntimeException(e);
            }
        }
    }
    public static List<FixedTollCity> selectFIxedTollCities(){
        List<FixedTollCity> resultList = new ArrayList<>();

        Connection dbConn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            dbConn = connect();
            st = dbConn.createStatement();
            rs = st.executeQuery("SELECT * FROM fixed_toll_tile");


            while(rs.next()){
                String name = rs.getString("name");
                int index = rs.getInt("index");
                int price = rs.getInt("price");
                int toll = rs.getInt("toll");

                FixedTollCity fixedTollCity = new FixedTollCity(index, name, price, toll);
                resultList.add(fixedTollCity);
            }
            return resultList;
        } catch(SQLException e){
            throw new RuntimeException("selectSCitites 오류 발생\n",e);
        } finally{
            try {
                st.close();
                rs.close();
                dbConn.close();
            } catch(SQLException e){
                throw new RuntimeException(e);
            }
        }

    }
}
