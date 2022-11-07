import java.util.ArrayList;
import java.util.List;

import business.CourseManager;
import core.logging.DatabaseLogger;
import core.logging.FileLogger;
import core.logging.ILogger;
import core.logging.MailLogger;
import dataAccess.jdbc.JdbcCourseDao;
import entities.Course;

public class Main {

	public static void main(String[] args) throws Exception {


		ILogger[] loggers = new ILogger[] {new DatabaseLogger(), new FileLogger(), new MailLogger()};
		
		for(ILogger logger: loggers) {
			logger.log("successful");
		}
		
		Course course1 = new Course();
		course1.setId(1);
		course1.setName("kurs1");
		course1.setPrice(12);
		
		Course course2 = new Course();
		course2.setId(2);
		course2.setName("kurs1");
		course2.setPrice(23);
		
		
		List<Course> courses = new ArrayList<>();
		
		
		CourseManager courseManager = new CourseManager(new JdbcCourseDao(), loggers, courses);
		courseManager.add(course1);
		
		CourseManager courseManager2 = new CourseManager(new JdbcCourseDao(), loggers, courses);
		courseManager2.add(course2);

	}

}
