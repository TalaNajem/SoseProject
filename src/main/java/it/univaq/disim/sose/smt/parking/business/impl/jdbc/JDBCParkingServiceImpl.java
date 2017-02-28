package it.univaq.disim.sose.smt.parking.business.impl.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.univaq.disim.sose.smt.parking.business.BusinessException;
import it.univaq.disim.sose.smt.parking.business.ParkingService;
import it.univaq.disim.sose.smt.parking.business.model.Parking;

@Service
public class JDBCParkingServiceImpl implements ParkingService {
	private static Logger LOGGER = LoggerFactory.getLogger(JDBCParkingServiceImpl.class);

	@Autowired
	private DataSource dataSource;

	// earth's mean radius, km
	private static final double EARTH_RADIUS = 6371;

	@Override
	public List<Parking> getParkings(double lat, double lon, int range) throws BusinessException {
		double latRadians = Math.toRadians(lat);
		double lonRadians = Math.toRadians(lon);
		// convert m to km
		double vicinityRangeToKM = (double) range / 1000;
	    // first-cut bounding box (in degrees)
	    double maxLat = lat + Math.toDegrees(vicinityRangeToKM/EARTH_RADIUS);
	    double minLat = lat - Math.toDegrees(vicinityRangeToKM/EARTH_RADIUS);
	    double maxLon = lon + Math.toDegrees(Math.asin(vicinityRangeToKM/EARTH_RADIUS) / Math.cos(Math.toRadians(lat)));
	    double minLon = lon - Math.toDegrees(Math.asin(vicinityRangeToKM/EARTH_RADIUS) / Math.cos(Math.toRadians(lat)));

	    String sql = "SELECT parking_id, name, latitude, longitude, capacity, capacity_disabled, fee, " +
	                 "  acos(sin(" + latRadians + ")*sin(radians(latitude)) + cos(" + latRadians + ")*cos(radians(latitude))*cos(radians(longitude)-" + lonRadians + ")) * " + EARTH_RADIUS + " As D " +
	            " FROM ( " +
	            "    SELECT *" +
	            "    FROM parkings" +
	            "    WHERE latitude Between " + minLat+ " And " + maxLat + 
	            "      And longitude Between " + minLon + " And " + maxLon +
	            ") As FirstCut " +
	            " WHERE acos(sin(" + latRadians+ ")*sin(radians(latitude)) + cos(" + latRadians + ")*cos(radians(latitude))*cos(radians(longitude)-" + lonRadians+ ")) * " + EARTH_RADIUS + " < " + vicinityRangeToKM +
	            " ORDER by name";
		LOGGER.info(sql);
	    //String sql = "SELECT * FROM parkings p ORDER BY p.name";
	    
		List<Parking> result = new ArrayList<>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			st = con.createStatement();

			rs = st.executeQuery(sql);
			while (rs.next()) {
				Parking parking = new Parking();
				parking.setId(rs.getLong("parking_id"));
				parking.setName(rs.getString("name"));
				parking.setLatitude(rs.getDouble("latitude"));
				parking.setLongitude(rs.getDouble("longitude"));
				parking.setCapacity(rs.getInt("capacity"));
				parking.setCapacityDisabled(rs.getInt("capacity_disabled"));
				parking.setFee(rs.getDouble("fee"));
				result.add(parking);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException(e);
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
				}
			}

		}
		
		return result;
	}

}