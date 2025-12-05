using ChefMind.Models.Database.Entities;
using Microsoft.EntityFrameworkCore;

namespace ChefMind.Models.Database
{
    public class ChefsMindContext : DbContext
    {
        public DbSet<Ingredient> Ingredient { get; set; }
        public DbSet<Recipe> Recipe { get; set; }
        public DbSet<RecipeIngredient> RecipeIngredient { get; set; }
        public DbSet<ShoppingList> ShoppingList { get; set; }
        public DbSet<User> User { get; set; }

        public ChefsMindContext(DbContextOptions<ChefsMindContext> options)
            : base(options)
        {
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<RecipeIngredient>()
                .HasKey(ri => new { ri.RecipeId, ri.IngredientId });

            base.OnModelCreating(modelBuilder);
        }
    }
}
