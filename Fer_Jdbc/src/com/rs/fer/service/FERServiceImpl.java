package com.rs.fer.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.Expense;
import com.rs.fer.bean.PersonalInfo;
import com.rs.fer.bean.User;
import com.rs.fer.util.DBUtil;

public class FERServiceImpl implements FERService {

	@Override
	public boolean registration(User user) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DBUtil.getConnection();

			String query = "INSERT INTO user VALUES (?,?,?,?,?,?,?,?)";

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, user.getId());
			preparedStatement.setString(2, user.getFirstName());
			preparedStatement.setString(3, user.getMiddleName());
			preparedStatement.setString(4, user.getLastName());
			preparedStatement.setString(5, user.getUsername());
			preparedStatement.setString(6, user.getPassword());
			preparedStatement.setString(7, user.getEmail());
			preparedStatement.setString(8, user.getMobile());

			int r = preparedStatement.executeUpdate();
			if (r > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}

		return false;
	}

	@Override
	public boolean login(User user) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			connection = DBUtil.getConnection();

			String query = "select userName,password from user";
			preparedStatement = connection.prepareStatement(query);
			rs = (ResultSet) preparedStatement.executeQuery();
			while (rs.next()) {

				String username1 = rs.getString(1);
				String password1 = rs.getString(2);

				System.out.println(username1);
				System.out.println(password1);
				break;
			}

			if (rs != null) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}

		return false;
	}

	@Override
	public boolean addExpense(Expense expense) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DBUtil.getConnection();

			String query = "INSERT INTO expense VALUES (?,?,?,?,?,?,?,?)";

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, expense.getExpenseId());
			preparedStatement.setString(2, expense.getExpenseType());
			preparedStatement.setString(3, expense.getDate());
			preparedStatement.setInt(4, expense.getNoOfItems());
			preparedStatement.setInt(5, expense.getPrice());
			preparedStatement.setString(6, expense.getTotal());
			preparedStatement.setString(7, expense.getByWhom());
			preparedStatement.setInt(8, expense.getUserId());

			int r = preparedStatement.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}

		return false;
	}

	@Override
	public boolean editExpense(Expense expense) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DBUtil.getConnection();

			String query = "update expense set expenseType=?,date=? where expenseId=?";

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, expense.getExpenseType());
			preparedStatement.setString(2, expense.getDate());

			preparedStatement.setInt(3, 1);

			int r = preparedStatement.executeUpdate();
			if (r > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}

		return false;
	}

	@Override
	public boolean deleteExpense(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DBUtil.getConnection();

			String query = "delete from expense where expenseId=?";
			int ExpensId = 3;
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, ExpensId);

			int r = preparedStatement.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}

		return false;
	}

	@Override
	public boolean resetpassword(int id, String currentpassword, String newpassword) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DBUtil.getConnection();

			String query = "update user set password =? where id=?";

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, "srikanth");
			preparedStatement.setInt(2, 103);

			int r = preparedStatement.executeUpdate();
			if (r > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}

		return false;
	}

	@Override
	public List<Expense> getexpenses() {
		List<Expense> expenses = new ArrayList<Expense>();
		Expense expense = null;
		Connection connection = null;
		PreparedStatement preparedstatement = null;

		try {
			connection = DBUtil.getConnection();

			String query = "select * from expense ";
			preparedstatement = connection.prepareStatement(query);
			ResultSet rs = preparedstatement.executeQuery();
			while (rs.next()) {
				expense = new Expense();
				expense.setExpenseId(rs.getInt("expenseId"));
				expense.setExpenseType(rs.getString("expenseType"));
				expense.setDate(rs.getString("date"));
				expense.setPrice(rs.getInt("price"));
				expense.setNoOfItems(rs.getInt("noOfItems"));
				expense.setTotal(rs.getString("total"));
				expense.setByWhom(rs.getString("byWhom"));
				expense.setUserId(rs.getInt("userId"));
				expenses.add(expense);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}

		return expenses;

	}

	@Override
	public List<Expense> getexpense() {
		Expense expense = null;
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		List<Expense> expenses = new ArrayList<Expense>(1);
		try {
			connection = DBUtil.getConnection();

			String query = "select * from expense where expenseId =?";
			int expenseId = 1;
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setInt(1, expenseId);
			ResultSet rs = preparedstatement.executeQuery();
			while (rs.next()) {
				expense = new Expense();
				expense.setExpenseId(rs.getInt("expenseId"));
				expense.setExpenseType(rs.getString("expenseType"));
				expense.setDate(rs.getString("date"));
				expense.setPrice(rs.getInt("price"));
				expense.setNoOfItems(rs.getInt("noOfItems"));
				expense.setTotal(rs.getString("total"));
				expense.setByWhom(rs.getString("byWhom"));
				expense.setUserId(rs.getInt("userId"));
				expenses.add(expense);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}

		return expenses;
	}

	@Override
	public List<Expense> getexpenseReport(String expenseType, String fromdate, String todate) {
		List<Expense> expenseReport = new ArrayList<Expense>();
		Expense expense = null;
		Connection connection = null;
		PreparedStatement preparedstatement = null;

		try {
			connection = DBUtil.getConnection();

			String query = "select * from expense where  expenseType=? and date between ? and ?";
			preparedstatement = connection.prepareStatement(query);
			
		
			preparedstatement.setString(1, expenseType);
			preparedstatement.setString(2,fromdate );
			preparedstatement.setString(3, todate);

			ResultSet rs = preparedstatement.executeQuery();
			while (rs.next()) {
				expense = new Expense();
				expense.setExpenseType(rs.getString("expenseType"));
				expense.setDate(rs.getString("date"));
				expense.setPrice(rs.getInt("price"));
				expense.setNoOfItems(rs.getInt("noOfItems"));
				expense.setTotal(rs.getString("total"));
				expense.setByWhom(rs.getString("byWhom"));
				expense.setUserId(rs.getInt("userId"));
				expenseReport.add(expense);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}

		return expenseReport;

	}


	@Override
	public PersonalInfo getPersonalInfo(int userid) {
		PersonalInfo personalinfo = new PersonalInfo();
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		try {
			connection = DBUtil.getConnection();

			String query = "select u.*, a.* from user u left join address a on u.id=a.userid where u.id=?";

			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setInt(1, userid);

			ResultSet rs = preparedstatement.executeQuery();
			while (rs.next()) {
				User user = new User();

				user.setFirstName(rs.getString("firstName"));
				user.setMiddleName(rs.getString("middleName"));
				user.setLastName(rs.getString("lastName"));
				user.setUsername(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setMobile(rs.getString("mobileNo"));

				Address address = new Address();

				address.setAddressLine1(rs.getString("addressLine1"));
				address.setAddressLine2(rs.getString("addressline2"));
				address.setCity(rs.getString("city"));
				address.setState(rs.getString("state"));
				address.setZip(rs.getString("zip"));
				address.setCountry(rs.getString("country"));
				address.setUserId(rs.getInt("userId"));
				
				personalinfo.setUser(user);
				personalinfo.setAddress(address);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return personalinfo;
	}

	@SuppressWarnings("null")
	@Override
	public boolean updatePersonalInfo(User user, Address address) {
		boolean UpadtePersonalInfo=false;
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		/*PersonalInfo personalinfo=null;*/
		
		try {
			connection = DBUtil.getConnection();
					
			String userUpdateQuery = "update user set firstName=?,middleName=?,lastName=?,userName=?,password=?,email=?,mobileNo=? where id =?";
			preparedstatement=connection.prepareStatement(userUpdateQuery);
			            preparedstatement.setString(1,user.getFirstName());
            			preparedstatement.setString(2,user.getMiddleName());
            			preparedstatement.setString(3,user.getLastName());
            			preparedstatement.setString(4,user.getUsername());
            			preparedstatement.setString(5,user.getPassword());
            			preparedstatement.setString(6,user.getEmail());
            			preparedstatement.setString(7,user.getMobile());
            			preparedstatement.setInt(8,user.getId());
			int numOfRecUpdated = preparedstatement.executeUpdate();
			UpadtePersonalInfo=numOfRecUpdated>0;
			
				if(address.getId() == 0) {
				String query="insert into address values(?,?,?,?,?,?,?,?)";	

					preparedstatement.setInt(1,address.getId());	
					preparedstatement.setString(2,address.getAddressLine1());
        			preparedstatement.setString(3,address.getAddressLine2());
        			preparedstatement.setString(4,address.getCity());
        			preparedstatement.setString(5,address.getState());
        			preparedstatement.setString(6,address.getZip());
        			preparedstatement.setString(7,address.getCountry());
        			preparedstatement.setInt(8,address.getUserId());
        			
        		int	records_inserted =preparedstatement.executeUpdate();
        		
        		UpadtePersonalInfo=records_inserted>0;

		
				} else {
					
					String Query="update address set addressLine1=?,addressLine2=?,city=?,state=?,zip=?,country=?,userid=? where id=?";
					preparedstatement=connection.prepareStatement(Query);
					preparedstatement.setString(1,address.getAddressLine1());
        			preparedstatement.setString(2,address.getAddressLine2());
        			preparedstatement.setString(3,address.getCity());
        			preparedstatement.setString(4,address.getState());
        			preparedstatement.setString(5,address.getZip());
        			preparedstatement.setString(6,address.getCountry());
        			preparedstatement.setInt(7,address.getUserId());
        			preparedstatement.setInt(8,address.getId());
					
                  //  int records_updated=preparedstatement.executeUpdate();
				  //=records_updated>0;
				    /*personalinfo.setUser(user);
				    personalinfo.setAddress(address);*/
                    /*if(UpadtePersonalInfo) 
                    {
                    connection.commit();
                    }else {
						connection.rollback();
					}
				*/
				}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		
		return UpadtePersonalInfo;
		
	}}

