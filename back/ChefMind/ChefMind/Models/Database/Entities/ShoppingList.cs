using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace ChefMind.Models.Database.Entities
{
    public class ShoppingList
    {
        [Key]
        public int Id { get; set; }
        public int UserId { get; set; }
        public DateTime CreatedAt { get; set; }
        public int IngredientId { get; set; }
        public string Quantity { get; set; }
        public bool Purchased { get; set; }

        [ForeignKey(nameof(UserId))]
        User User { get; set; }

        [ForeignKey(nameof(IngredientId))]
        Ingredient Ingredient { get; set; }
     }
}
