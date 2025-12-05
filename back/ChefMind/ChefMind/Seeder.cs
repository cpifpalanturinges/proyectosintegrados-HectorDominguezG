using ChefMind.Helpers;
using ChefMind.Models.Database;
using ChefMind.Models.Database.Entities;

namespace ChefMind
{
    public class Seeder
    {
        public ChefsMindContext _chefsMindContext;
        public PasswordHelper _passwordHelper;
        public Seeder(ChefsMindContext chefsMindContext, PasswordHelper passwordHelper)
        {
            this._chefsMindContext = chefsMindContext;
            this._passwordHelper = passwordHelper;
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
                        Password = _passwordHelper.Hash("password"),
                        Role = "admin"
                    }
                ];

            await _chefsMindContext.User.AddRangeAsync(users);
        }
    }
}
