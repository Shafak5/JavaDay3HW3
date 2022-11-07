package business;

import java.util.List;

import core.logging.ILogger;
import dataAccess.IInstructorDao;
import entities.Instructor;

public class InstructorManager {
	private IInstructorDao iInstructorDao;
	private ILogger loggers;
	private List<Instructor> instructors;
	
	public InstructorManager(IInstructorDao iInstructorDao, ILogger loggers, List<Instructor> instructors) {
		this.iInstructorDao = iInstructorDao;
		this.loggers = loggers;
		this.instructors = instructors;
	}
	
	public void add(Instructor instructor){
		iInstructorDao.add(instructor);
		instructors.add(instructor);
	}

}
