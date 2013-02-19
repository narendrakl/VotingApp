package com.naren.voting;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.naren.voting.JDBCHelper;

public class Model {

	PreparedStatement ps1=null, ps2=null;
	ResultSet rs=null, rs1=null;
	public String voteDetails(VoteBean vb) 
	{
		Connection con = JDBCHelper.getConnection();
		
		if(con==null)
		{
			String msg = "";
			System.out.println("Sir Database is not working properly, contact Admin");
			return msg="Sir Database is not working properly, contact Admin";
		}
		else
		{
			System.out.println("Going to update table");
							
				try
				{
					String sql="update candidate_names set vote_count=vote_count+1 where unique_id in(?,?,?,?,?,?,?,?,?)";
					ps1=con.prepareStatement(sql);
					ps1.setString(1, vb.getUid1());
					ps1.setString(2, vb.getUid2());
					ps1.setString(3, vb.getUid3());
					ps1.setString(4, vb.getUid4());
					ps1.setString(5, vb.getUid5());
					ps1.setString(6, vb.getUid6());
					ps1.setString(7, vb.getUid7());
					ps1.setString(8, vb.getUid8());
					ps1.setString(9, vb.getUid9());
					ps1.execute();
					return Constants.SUCCESS;
				} 
				catch (SQLException e)
				{
					
					e.printStackTrace();
				}
				finally
				{
					JDBCHelper.close(rs);
					JDBCHelper.close(ps1);
					JDBCHelper.close(con);
				}
		}
		return "";
	}
	public String results(VoteBean vb) 
	{
		Connection con = JDBCHelper.getConnection();
		
		if(con==null)
		{
			String msg = "";
			System.out.println("Sir Database is not working properly, contact Admin");
			return msg="Sir Database is not working properly, contact Admin";
		}
		else
		{
			
			String sql ="select voting_posts.post, candidate_names.name, candidate_names.unique_id, candidate_names.vote_count from voting_posts, candidate_names where voting_posts.post = ? and candidate_names.post_slno=voting_posts.post_slno";
			String sql1="select sum(candidate_names.vote_count) from candidate_names where candidate_names.post_slno=1";
			try
			{
				String result="";
				ps2=con.prepareStatement(sql1);
				ps2.execute();
				rs1=ps2.getResultSet();
				ps1=con.prepareStatement(sql);
				ps1.setString(1, vb.getPname());
				ps1.execute();
				System.out.println("Inside of model after ps1 execution"+vb.getPname());
				rs = ps1.getResultSet();
				if(rs1.next())
				{
					result=result+rs1.getInt(1)+"@";
				}
					
				while(rs.next())
				{
					result = result+rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+"@";
					System.out.println(result); 
				}
				
				return result+"$";
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			finally
			{
				JDBCHelper.close(rs);
				JDBCHelper.close(ps1);
				JDBCHelper.close(con);
			}
		}
		return "";
	}

	

}
