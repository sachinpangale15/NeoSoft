package Neosoft.PracticeCRUD.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Neosoft.PracticeCRUD.Entity.Student;
import Neosoft.PracticeCRUD.Service.StudentService;

@RestController
@RequestMapping("a1/api/")
public class StudenrController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping
	public ResponseEntity<Student> createStudent(@RequestBody Student student){
		return ResponseEntity.ok(studentService.saveStudent(student));
	}
	
	@GetMapping
	public ResponseEntity<List<Student>> getAllStudent(){
		return ResponseEntity.ok(studentService.getAllStudent());
		
	}
	
    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id){
    	return studentService.getStudentById(id)
    			 .map(ResponseEntity::ok)
                 .orElse(ResponseEntity.notFound().build());
    	
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student studentDetails) {
    	Student updateStudent = studentService.updateStudent(id, studentDetails);

        if (updateStudent == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updateStudent);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
    	studentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
     
     

}
