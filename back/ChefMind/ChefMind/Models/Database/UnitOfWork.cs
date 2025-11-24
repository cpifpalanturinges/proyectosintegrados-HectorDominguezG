using ChefMind.Models.Database.Repositories;

namespace ChefMind.Models.Database
{
    public class UnitOfWork
    {
        public readonly ChefsMindContext _context;

        private UserRepository _userRepository;

        public UserRepository UserRepository => _userRepository ??= new UserRepository(_context);

        public UnitOfWork(ChefsMindContext context)
        {
            _context = context;
        }

        public async Task<bool> SaveAsync()
        {
            return await _context.SaveChangesAsync() > 0;
        }
    }
}
