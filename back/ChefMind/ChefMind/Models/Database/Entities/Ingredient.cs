using System.ComponentModel.DataAnnotations;

namespace ChefMind.Models.Database.Entities
{
    public class Ingredient
    {
        [Key]
        public int Id { get; set; }
        public string Name { get; set; }
        public string Unit { get; set; }
        public string Weight { get; set; }
    }
}
