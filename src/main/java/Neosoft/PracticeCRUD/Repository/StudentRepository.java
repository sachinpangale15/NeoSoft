package Neosoft.PracticeCRUD.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Neosoft.PracticeCRUD.Entity.Student;


@Repository
public interface StudentRepository  extends JpaRepository<Student, Integer>{

}
