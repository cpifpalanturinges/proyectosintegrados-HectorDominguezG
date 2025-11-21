using ChefMind.Models.Database.Repositories;

namespace ChefMind.Models.Database
{
    public class UnitOfWork
    {
        public readonly ChefsMindContext _context;

        private UserRepository _userRepository;
        private AuthRepository _authRepository;

        public UserRepository UserRepository => _userRepository ??= new UserRepository(_context);
        public AuthRepository AuthRepository => _authRepository ??= new AuthRepository(_context);
    }
}
