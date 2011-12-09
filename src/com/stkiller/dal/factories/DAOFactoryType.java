package com.example.dal.factories;

public enum DAOFactoryType {
	POSTGRE, MS_SQL, HIBERNATE;

	public String toString() {
		switch (this) {
			case POSTGRE: {
				return "Posgre";
			}
			case MS_SQL: {
				return "MS SQL";
			}
            case HIBERNATE:{
                return "Hibernate";
            }
			default: {
				return "Unknown DAOFactory type";
			}
		}
	}
}
