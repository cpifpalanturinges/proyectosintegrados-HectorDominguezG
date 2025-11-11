using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace ChefMind.Models.Database.Entities
{
    public class RecipeIngredient
    {
        [Key]
        public int RecipeId { get; set; }
        [Key]
        public int IngredientId { get; set; }
        public float Quantity { get; set; }

        [ForeignKey(nameof(IngredientId))]
        Ingredient Ingredient { get; set; }

        [ForeignKey(nameof(RecipeId))]
        Recipe Recipe { get; set; }
    }
}
