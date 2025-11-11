using ChefMind.Models.Database.Entities;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Options;

namespace ChefMind.Models.Database
{
    public class ChefsMindContext : DbContext
    {
        private const string DATABASE_PATH = "ChefsMind.db";

        private readonly Settings _settings;

        DbSet<Ingredient> Ingredient {  get; set; }
        DbSet<Recipe> Recipe { get; set; }
        DbSet<RecipeIngredient> RecipeIngredient { get; set; }
        DbSet<ShoppingList> ShoppingList { get; set; }
        DbSet<User> User { get; set; }

        public ChefsMindContext(IOptions<Settings> options)
        {
            _settings = options.Value;
        }

        protected override void OnConfiguring(DbContextOptionsBuilder options)
        {

            string serverConnection = "";
            string baseDir = AppDomain.CurrentDomain.BaseDirectory;


            #if DEBUG
            options.UseSqlite($"DataSource={baseDir}{DATABASE_PATH}");
            #else
                options.UseMySql(serverConnection,ServerVersion.AutoDetect(serverConnection));
            #endif
        }

    }
}
