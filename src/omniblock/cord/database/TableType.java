/*
 *  XMPP API to chat and interact with the League of Legends ChatServers. 
 *
 *  Copyright (C) 2017  Josue Acevedo
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package omniblock.cord.database;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author wirlie
 *
 */
public enum TableType {
	RESOLVER("CREATE TABLE IF NOT EXISTS uuid_resolver ()");
	
	String createSql;
	
	TableType(String createSql) {
		this.createSql = createSql;
	}
	
	public void make(Statement stm) throws SQLException {
		stm.executeUpdate(createSql);
	}
}
