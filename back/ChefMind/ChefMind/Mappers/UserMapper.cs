using ChefMind.Models.Database.Dto;
using ChefMind.Models.Database.Entities;

namespace ChefMind.Mappers
{
    public class UserMapper
    {
        public UserDto ToDto(User user)
        {
            return new UserDto
            {
                Id = user.UserId,
                Name = user.UserName,
                Email = user.Email,
                Role = user.Role,
            };
        }
    }
}
