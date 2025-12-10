using ChefMind.Models.Database.Entities;
using Microsoft.EntityFrameworkCore;

namespace ChefMind.Models.Database
{
    public class ChefsMindContext : DbContext
    {
        private const string DATABASE_PATH = "ChefsMind.db";
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

        protected override void OnConfiguring(DbContextOptionsBuilder options)
        {
            /// los datos de la url
            /// son los de electrospeed
            string serverConnection = "Server=db34983.public.databaseasp.net; Database=db34983; Uid=db34983; Pwd=C@g3%8GaNw6+";
            string baseDir = AppDomain.CurrentDomain.BaseDirectory;


            #if DEBUG
            options.UseSqlite($"DataSource={baseDir}{DATABASE_PATH}");
            #else
                options.UseMySql(serverConnection,ServerVersion.AutoDetect(serverConnection));
            #endif
        }
    }
}
