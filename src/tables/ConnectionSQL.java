package tables;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionSQL {
	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;
	
	SearchBookForm search;
	
	try {
		String sql = "select * from BOOK";
		if(search.getTextBookID().getText().length()>0) {
			sql = sql + "where bookID like '%" + search.getTextBookID().getText() + "%'";
		}
	}
	
}
