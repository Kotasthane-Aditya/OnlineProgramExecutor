package com.executor;

import java.io.File;


public interface IExecutor {

	String execute(String programCode);

	String execute(File programFile);

	IExecutor entryClass(String entryClass);

}
