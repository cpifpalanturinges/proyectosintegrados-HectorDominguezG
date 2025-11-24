using ChefMind.Mappers;
using ChefMind.Models.Database;
using ChefMind.Models.Database.Entities;
using Microsoft.AspNetCore.Authentication.JwtBearer;
using Microsoft.Extensions.Options;
using Microsoft.IdentityModel.Tokens;

namespace ChefMind.Services
{
    public class AuthService
    {
        private readonly UnitOfWork _unitOfWork;
        private readonly TokenValidationParameters _tokenParameters;
        private readonly UserMapper _userMapper;

        public AuthService(UnitOfWork unitOfWork, IOptionsMonitor<JwtBearerOptions> jwtOptions, UserMapper userMapper)
        {
            _unitOfWork = unitOfWork;
            _tokenParameters = jwtOptions.Get(JwtBearerDefaults.AuthenticationScheme)
                .TokenValidationParameters;
            _userMapper = userMapper;
        }

        public async Task<User> InsertUser(User user)
        {
            User newUser = await _unitOfWork.UserRepository.InsertAsync(user);
            await _unitOfWork.SaveAsync();
            return newUser;
        }

    }
}
