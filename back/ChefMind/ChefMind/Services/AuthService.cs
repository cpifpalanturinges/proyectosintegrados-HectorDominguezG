using ChefMind.Mappers;
using ChefMind.Models.Database;
using ChefMind.Models.Database.Dto;
using ChefMind.Models.Database.Entities;
using Microsoft.AspNetCore.Authentication.JwtBearer;
using Microsoft.Extensions.Options;
using Microsoft.IdentityModel.Tokens;
using System.IdentityModel.Tokens.Jwt;
using System.Security.Claims;
using System.Text.RegularExpressions;

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

        public string ObtainToken(User user)
        {
            var tokenDescriptor = new SecurityTokenDescriptor
            {
                // EL CONTENIDO DEL JWT
                Claims = new Dictionary<string, object>
                {
                    { ClaimTypes.NameIdentifier, user.UserId },
                    { "name", user.UserName },
                    { ClaimTypes.Role, user.Role },
                },
                Expires = DateTime.UtcNow.AddYears(3),
                SigningCredentials = new SigningCredentials(
                        _tokenParameters.IssuerSigningKey,
                        SecurityAlgorithms.HmacSha256Signature
                    )
            };
            JwtSecurityTokenHandler tokenHandler = new JwtSecurityTokenHandler();
            SecurityToken token = tokenHandler.CreateToken(tokenDescriptor);
            return tokenHandler.WriteToken(token);
        }

        public async Task<User> Register(UserRegister createdUser)
        {
            if ( createdUser == null || !IsEmail(createdUser.Email)){
                return null;
            }

            User user = _userMapper.ToEntity(createdUser);

            try
            {
                User newUser = await InsertUser(user);
                return newUser;
            }
            catch (Exception e)
            {
                Console.Error.WriteLine(e.ToString());
            }

            return null;
        }

        public bool IsEmail(string email)
        {
            Regex validateEmailRegex = new Regex("^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$");
            return validateEmailRegex.IsMatch(email);
        }
    }
}
