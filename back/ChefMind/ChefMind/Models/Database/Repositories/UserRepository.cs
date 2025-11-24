using ChefMind.Models.Database.Entities;
using ChefMind.Models.Database.Repositories.Repository;
using Microsoft.EntityFrameworkCore;

namespace ChefMind.Models.Database.Repositories
{
    public class UserRepository : Repository<User, int>
    {
        public UserRepository(ChefsMindContext context) : base(context) { }
        public async Task<User> GetUserByCredentialAsync(string credential)
        {
            return await GetQueryable()
                .FirstOrDefaultAsync(user => user.Email == credential || user.UserName == credential);
        }

    }
}
