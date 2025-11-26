using ChefMind.Mappers;
using ChefMind.Models.Database;
using ChefMind.Models.Database.Dto;
using ChefMind.Models.Database.Entities;

namespace ChefMind.Services
{
    public class UserService
    {
        UnitOfWork _unitOfWork;
        UserMapper _userMapper;

        public UserService (UnitOfWork unitOfWork, UserMapper userMapper)
        {
            unitOfWork = _unitOfWork;
            userMapper = _userMapper;
        }

        public async Task<UserDto> GetUserById(int id)
        {
            User user = await _unitOfWork.UserRepository.GetByIdAsync(id);

            if (user == null)
                return null;

            return _userMapper.ToDto(user);
        }
    }
}
