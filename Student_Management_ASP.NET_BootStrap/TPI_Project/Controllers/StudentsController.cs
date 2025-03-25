using Microsoft.AspNetCore.Mvc;
using StudentManagement.Models;
using StudentManagement.Repositories;
using System;

namespace StudentManagement.Controllers
{
    public class StudentsController : Controller
    {
        private readonly IStudentRepository _repository;

        public StudentsController(IStudentRepository repository)
        {
            _repository = repository;
        }
        public bool AreEssentialFieldsValid(Student student)
        {
            bool isValid = true;

            if (string.IsNullOrWhiteSpace(student.Nume))
            {
                ModelState.AddModelError("Nume", "Nume is required.");
                isValid = false;
            }

            if (string.IsNullOrWhiteSpace(student.Facultate))
            {
                ModelState.AddModelError("Facultate", "Facultate is required.");
                isValid = false;
            }

            if (string.IsNullOrWhiteSpace(student.Specializare))
            {
                ModelState.AddModelError("Specializare", "Specializare is required.");
                isValid = false;
            }

            if (student.An <= 0)
            {
                ModelState.AddModelError("An", "An must be a positive integer.");
                isValid = false;
            }

            if (string.IsNullOrWhiteSpace(student.Seria))
            {
                ModelState.AddModelError("Seria", "Seria is required.");
                isValid = false;
            }

            if (student.Grupa <= 0)
            {
                ModelState.AddModelError("Grupa", "Grupa must be a positive integer.");
                isValid = false;
            }

            return isValid;
        }

        public IActionResult Index(string searchString)
        {
            ViewData["CurrentFilter"] = searchString;

            var students = _repository.GetAll();

            if (!string.IsNullOrEmpty(searchString))
            {
                students = students.Where(s =>
                    s.Nume.Contains(searchString) ||
                    s.Facultate.Contains(searchString) ||
                    s.Specializare.Contains(searchString) ||
                    s.An.ToString().Contains(searchString) ||
                    s.Seria.Contains(searchString) ||
                    s.Grupa.ToString().Contains(searchString)
                );
            }

            return View(students);
        }

        public IActionResult Create()
        {
            return View();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public IActionResult Create(Student student)
        {
            if (AreEssentialFieldsValid(student))
            {
                _repository.Add(student);
                return RedirectToAction(nameof(Index));
            }
            return View(student);
        }

        public IActionResult Details(int id)
        {
            var student = _repository.GetById(id);
            if (student == null)
            {
                return NotFound();
            }
            return View(student);
        }


        public IActionResult Edit(int id)
        {
            var student = _repository.GetById(id);
            if (student == null)
            {
                return NotFound();
            }
            return View(student);
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public IActionResult Edit(int id, Student student)
        {
            if (id != student.Id)
            {
                return NotFound();
            }

            if (AreEssentialFieldsValid(student))
            {
                _repository.Update(student);
                return RedirectToAction(nameof(Index));
            }
            return View(student);
        }

        public IActionResult Delete(int id)
        {
            var student = _repository.GetById(id);
            if (student == null)
            {
                return NotFound();
            }
            return View(student);
        }

        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public IActionResult DeleteConfirmed(int id)
        {
            _repository.Delete(id);
            return RedirectToAction(nameof(Index));
        }

        public IActionResult AddInformation(int id)
        {
            var student = _repository.GetById(id);
            if (student == null)
            {
                return NotFound();
            }
            return View(student);
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public IActionResult AddInformation(int id, Student student)
        {
            if (id != student.Id)
            {
                return NotFound();
            }

            if (ModelState.IsValid)
            {
                _repository.Update(student);
                return RedirectToAction(nameof(Details), new { id = student.Id });
            }
            return View(student);
        }

        public IActionResult EditInformation(int id)
        {
            var student = _repository.GetById(id);
            if (student == null)
            {
                return NotFound();
            }
            return View(student);
        }

        [HttpPost]
        public IActionResult EditInformation(Student student)
        {
            if (ModelState.IsValid)
            {
                _repository.Update(student);
                return RedirectToAction(nameof(Index));
            }
            return View(student);
        }



    }
}