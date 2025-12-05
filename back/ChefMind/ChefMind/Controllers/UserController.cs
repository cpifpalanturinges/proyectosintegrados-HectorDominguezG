using ChefMind.Models.Database.Dto;
using ChefMind.Services;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace ChefMind.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class UserController : ControllerBase
    {
        UserService _userService;

        public UserController(UserService userService)
        {
            _userService = userService;
        }

        [HttpGet("{id}")]
        public async Task<UserDto> GetUserById(int id)
        {
            UserDto user = await _userService.GetUserById(id);
            if (user == null)
            {
                HttpContext.Response.StatusCode = StatusCodes.Status400BadRequest;
                return null;
            }

            return user;
        }
    }
}
