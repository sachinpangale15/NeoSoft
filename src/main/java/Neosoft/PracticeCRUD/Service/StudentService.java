package Neosoft.PracticeCRUD.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Neosoft.PracticeCRUD.Entity.Student;
import Neosoft.PracticeCRUD.Repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepo;
	
	public Student saveStudent(Student student) {
		return studentRepo.save(student);
	}
	
	public List<Student> getAllStudent(){
		return studentRepo.findAll();
	}
	
	public Optional<Student> getStudentById(int id){ 
		return studentRepo.findById(id);
		
	}
	
	public Student updateStudent(int id, Student student) {
        Optional<Student> existingStudent = studentRepo.findById(id);
        if (existingStudent.isPresent()) {
            Student std = existingStudent.get();
            std.setName(student.getName());
            std.setAddress(student.getAddress());
            std.setNumber(student.getNumber());
            return studentRepo.save(std);
        } else {
            throw new RuntimeException("Student not found with id: " + id);
        }
    }
	
	public void deleteById(int id){
		 studentRepo.deleteById(id);
	}
	

}
