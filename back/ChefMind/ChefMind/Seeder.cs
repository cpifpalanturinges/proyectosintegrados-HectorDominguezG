using ChefMind.Models.Database;
using ChefMind.Models.Database.Entities;

namespace ChefMind
{
    public class Seeder
    {
        public ChefsMindContext _chefsMindContext;
        public Seeder(ChefsMindContext chefsMindContext)
        {
            this._chefsMindContext = chefsMindContext;
        }

        public async Task SeedAsync()
        {
            await SeedUserAsync();
            await _chefsMindContext.SaveChangesAsync();

            //await SeedRecipeAsync();
            //await _chefsMindContext.SaveChangesAsync();
        }

        private async Task SeedUserAsync()
        {
            User[] users =
                [
                    new User(){
                        UserName = "Test",
                        Email = "test@gmail.com",
                        Password = "password",
                        Role = "admin"
                    }
                ];

            await _chefsMindContext.User.AddRangeAsync(users);
        }
    }
}
