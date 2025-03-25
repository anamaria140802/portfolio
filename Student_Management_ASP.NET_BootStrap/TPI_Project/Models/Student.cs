using System;
using System.ComponentModel.DataAnnotations;
using static System.Net.Mime.MediaTypeNames;
using static System.Runtime.InteropServices.JavaScript.JSType;

namespace StudentManagement.Models
{
    public class Student
    {
        public int Id { get; set; }

        [Required]
        public string Nume { get; set; }

        [Required]
        public string Facultate { get; set; }

        [Required]
        public string Specializare { get; set; }

        [Required]
        public int An { get; set; }

        [Required]
        public string Seria { get; set; }

        [Required]
        public int Grupa { get; set; }

        [Display(Name = "Data de Nastere")]
        [DataType(DataType.Date)]
        [DateValidation(ErrorMessage = "Data de nastere invalida.")]
        public DateTime DataNasterii { get; set; }


        public string CNP { get; set; }

        public string Email { get; set; }

        [Phone]
        [RegularExpression(@"^\d{10}$", ErrorMessage = "Phone number must be 10 digits.")]
        public string Telefon { get; set; }

        public string Oras { get; set; }

        public string Adresa { get; set; }

        public string IBAN { get; set; }

    }
    public class DateValidationAttribute : ValidationAttribute
    {
        protected override ValidationResult IsValid(object value, ValidationContext validationContext)
        {
            var date = (DateTime?)value;
            if (date != null && (18 <= (DateTime.Now.Year- date.Value.Year) && 100 >=(DateTime.Now.Year - date.Value.Year)))
            {
                return ValidationResult.Success;
            }
            return new ValidationResult(ErrorMessage);
        }
    }
}