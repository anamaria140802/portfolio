using System.Collections.Generic;
using System.Linq;
using System.Runtime.InteropServices;
using StudentManagement.Models;

namespace StudentManagement.Repositories
{
    public class StudentRepository : IStudentRepository
    {
        private readonly List<Student> _students = new();
        private int _nextId = 1;

        public IEnumerable<Student> GetAll()
        {
            return _students;
        }

        public Student GetById(int id)
        {
            return _students.FirstOrDefault(s => s.Id == id);
        }

        public void Add(Student student)
        {
            student.Id = _students.Any() ? _students.Max(s => s.Id) + 1 : 1;
            _students.Add(student);
        }

        public void Update(Student student)
        {
            var existingStudent = GetById(student.Id);
            if (existingStudent != null)
            {
                existingStudent.Nume = student.Nume;
                existingStudent.Facultate = student.Facultate;
                existingStudent.Specializare = student.Specializare;
                existingStudent.An = student.An;
                existingStudent.Seria = student.Seria;
                existingStudent.Grupa = student.Grupa;
                existingStudent.DataNasterii = student.DataNasterii;
                existingStudent.CNP = student.CNP;
                existingStudent.Email = student.Email;
                existingStudent.Telefon = student.Telefon;
                existingStudent.Oras = student.Oras;
                existingStudent.Adresa = student.Adresa;
                existingStudent.IBAN = student.IBAN;
            }
        }

        public void Delete(int id)
        {
            var student = GetById(id);
            if (student != null)
            {
                _students.Remove(student);
            }
        }
    }
}