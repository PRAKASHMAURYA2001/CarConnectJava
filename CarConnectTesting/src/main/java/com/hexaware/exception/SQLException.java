package com.hexaware.exception;

public class SQLException  extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor for the SqlException class. It prints a message to the
	 * console when the exception is instantiated.
	 */
	public SQLException() {
		System.out.println("When executing a SQL query and the database is offline.");
	}

	/**
	 * Overrides the toString method to provide a custom error message.
	 *
	 * @return A string representation of the exception, indicating "When executing
	 *         a SQL query and the database is offline".
	 */
	@Override
	public String toString() {
		return "When executing a SQL query and the database is offline";
	}
}
