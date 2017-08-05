package com.programmingfree.springservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.programmingfree.springservice.domain.Restaurant;
import com.programmingfree.springservice.utility.DBUtility;

public class RestaurantService {

	private Connection connection;

	public RestaurantService() {
		connection = DBUtility.getConnection();
	}

	public int getUserCount() {
		int count = 0;
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select count(*) as count from menu_items");
			while (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public void addUser(Restaurant restaurant) {
		try {

			PreparedStatement preparedStatement = connection.prepareStatement(
					"insert into menu_items(id,short_name,name,description,price_small,price_large,small_portion_name,large_portion_name) values (?,?, ?, ?,?,?,?,?,? )");
			// Parameters start with 1
			preparedStatement.setLong(1, restaurant.getId());
			preparedStatement.setString(2, restaurant.getShort_name());
			preparedStatement.setString(3, restaurant.getName());
			preparedStatement.setString(4, restaurant.getDescription());
			preparedStatement.setString(5, restaurant.getPrice_small());
			preparedStatement.setString(6, restaurant.getPrice_large());
			preparedStatement.setString(7, restaurant.getSmall_portion_name());
			preparedStatement.setString(8, restaurant.getLarge_portion_name());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteUser(int userId) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from tblUser where userid=?");
			// Parameters start with 1
			preparedStatement.setInt(1, userId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Restaurant> getAllMenu() {
		List<Restaurant> menus = new ArrayList<Restaurant>();
		try {
			Statement statement = connection.createStatement();
			// ResultSet rs = statement.executeQuery("select * from menu_items
			// limit 15");
			ResultSet rs = statement.executeQuery("select * from menu_items");
			while (rs.next()) {
				Restaurant restaurant = new Restaurant();
				System.out.println(rs.getInt("id"));
				restaurant.setId(rs.getInt("id"));
				restaurant.setName(rs.getString("name"));
				restaurant.setShort_name(rs.getString("short_name"));
				restaurant.setDescription(rs.getString("description"));
				restaurant.setPrice_small(rs.getString("price_small"));
				restaurant.setPrice_large(rs.getString("price_large"));
				restaurant.setSmall_portion_name(rs.getString("small_portion_name"));
				restaurant.setLarge_portion_name(rs.getString("large_portion_name"));
				menus.add(restaurant);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return menus;
	}

	public List<Restaurant> getMenuByCategory(String category) {
		List<Restaurant> menus = new ArrayList<Restaurant>();
		try {

			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from menu_items where short_name like ? ");
			preparedStatement.setString(1, category + "%");
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				Restaurant restaurant = new Restaurant();
				restaurant.setId(rs.getInt("id"));
				restaurant.setName(rs.getString("name"));
				restaurant.setShort_name(rs.getString("short_name"));
				restaurant.setDescription(rs.getString("description"));
				restaurant.setPrice_small(rs.getString("price_small"));
				restaurant.setPrice_large(rs.getString("price_large"));
				restaurant.setSmall_portion_name(rs.getString("small_portion_name"));
				restaurant.setLarge_portion_name(rs.getString("large_portion_name"));
				menus.add(restaurant);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menus;
	}

}
