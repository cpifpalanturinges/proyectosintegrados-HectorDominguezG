using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace ChefMind.Models.Database.Entities
{
    public class Recipe
    {
        [Key]
        public int Id { get; set; }
        public string Title { get; set; }
        public string Description { get; set; }
        public string ImageUrl { get; set; }
        public string Preptime { get; set; }
        public string CreatedBy {  get; set; }

        [ForeignKey(nameof(CreatedBy))]
        User User { get; set; }
    }
}
