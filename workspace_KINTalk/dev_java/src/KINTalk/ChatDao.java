package KINTalk;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
import util.DBConnectionMgr;

public class ChatDao {
	Connection					con 	= null;
	CallableStatement			cstmt	= null;
	OracleCallableStatement		ocstmt	= null;
	ResultSet					rs 		= null;
	DBConnectionMgr				dbMgr	= null;
}
