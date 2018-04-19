package ir.maktab.api;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ir.maktab.entities.Student;
import ir.maktab.managers.StudentManager;

@Path("/students")
public class StudentResources {
	StudentManager studentMng = StudentManager.getInstance();

	@POST
	@Path("/addstudent")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String save(Student student) {
		try {
			return studentMng.save(student);
		} catch (SQLException e) {
			studentMng.logException(e.getMessage(), "Student save");
			return null;
		}
	}

	@GET
	@Path("/student/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student load(@PathParam("id") int id) {
		try {
			return studentMng.load(id);
		} catch (SQLException e) {
			studentMng.logException(e.getMessage(), "Student load");
			return null;
		}
	}

	@GET
	@Path("/dltstudent/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String delete(@PathParam("id") int id) {
		try {
			return studentMng.delete(id);
		} catch (SQLException e) {
			studentMng.logException(e.getMessage(), "Student delete");
			return null;
		}
	}

	@GET
	@Path("/allstudents")
	@Produces(MediaType.APPLICATION_JSON)
	public Student[] findAll() {
		try {
			return studentMng.findAll();
		} catch (SQLException e) {
			studentMng.logException(e.getMessage(), "Student find all");
			return null;
		}
	}
}
