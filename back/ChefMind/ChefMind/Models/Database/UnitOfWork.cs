using ChefMind.Models.Database.Repositories;

namespace ChefMind.Models.Database
{
    public class UnitOfWork
    {
        public readonly ChefsMindContext _context;

        private UserRepository _userRepository;

        public UserRepository UserRepository => _userRepository ??= new UserRepository(_context);
    }
}
