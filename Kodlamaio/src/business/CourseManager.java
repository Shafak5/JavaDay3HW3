package business;

import java.util.List;

import core.logging.ILogger;
import dataAccess.ICourseDao;
import entities.Course;

public class CourseManager {
	private ICourseDao iCourseDao;
	private ILogger[] loggers;
	private List<Course> courses;

	public CourseManager(ICourseDao iCourseDao, ILogger[] loggers, List<Course> courses) {
		this.iCourseDao = iCourseDao;
		this.loggers = loggers;
		this.courses = courses;
	}

	public void add(Course course) throws Exception{
		if(course.getPrice()<0) {
			throw new Exception("kurs fiyati 0'dan kucuk olamaz");
		}
		for(Course newcourse : courses) {
			if (newcourse.getName().equals(course.getName())) {
				throw new Exception("kursun adi daha once kullanilmis");
			}
		}
		iCourseDao.add(course);
		courses.add(course);

		for(ILogger logger : loggers) {
			logger.log(course.getName() + " eklendi");
		}
	}

}
